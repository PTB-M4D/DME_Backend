package de.ptb.dsi.dme_backend.service.input;

import de.ptb.dsi.dme_backend.model.*;
import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.*;
import java.io.IOException;
import java.io.StringReader;
import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class InputReaderService implements IInputReaderService {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(InputReaderService.class);


    @Override
    public void loadData(ComparisonDataModel comparisonDataModel) throws ParserConfigurationException, IOException, SAXException, TransformerException, XPathExpressionException {
        for (String contributionId : comparisonDataModel.getContributions().keySet()) {
            Contribution contribution = comparisonDataModel.getContributions().get(contributionId);
            Document contributionFile = readDocument(contribution.getPidInputData());
            if (contributionFile == null) continue;
            for (EntityUnderComparison entity : comparisonDataModel.getEntities().values()) {
                for (String dataId : entity.getDataIdentifiers().keySet()) {
                    DataIdentifier dataIdentifier = entity.getDataIdentifiers().get(dataId);
                    SiReal siRealLoadedData = readData(dataIdentifier, contributionFile);
                    this.addDataToEntity(entity.getEntityData(), dataId, contributionId, siRealLoadedData);
                }
            }
        }
    }

    public Document readDocument(@Nonnull String pidInputData) throws ParserConfigurationException, IOException, SAXException {
        String urlPid =   pidInputData ;
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(urlPid, String.class, 200);
        byte[] byteBase64 = Base64.getDecoder().decode(response);
        String dccXml = new String(byteBase64);
        //parse the xml
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputSource is = new InputSource(new StringReader(dccXml));
        Document document = builder.parse(is);
        return document;
    }

    public SiReal readData(@Nonnull DataIdentifier dataIdentifier, @Nonnull Document document) throws  XPathExpressionException {
        SiReal siReal ;
        document.getDocumentElement().normalize();

        // get searchterms from dataIdentifier
        String refId = dataIdentifier.getRefId();
        List<String> refTypes = dataIdentifier.getRefTypes();

        List<String> searchTerms = new ArrayList<>();
        if (refId != null) {
            searchTerms.add("ancestor-or-self::*[@refId='" + refId + "']"); // get every Element that has refId or is a child of element with refId
        }
        if (refTypes != null) {
            for (String refType : refTypes) {
                searchTerms.add("contains(@refType, '" + refType +"')"); // get every element whose refType contains a specific string
            }
        }
        XPath xpath = XPathFactory.newInstance().newXPath();

        // construct xPath query
        String xPathExpression = "//*[";
        for (int i = 0; i < searchTerms.size(); i++) {
            if (i != 0) {
                xPathExpression += "and ";
            }
            xPathExpression += searchTerms.get(i);
            if (i < searchTerms.size() -1) {
                xPathExpression += " ";
            }
        }
        xPathExpression += "]";

        NodeList filteredNodes = (NodeList) xpath.compile(xPathExpression).evaluate( document, XPathConstants.NODESET);

        int index = dataIdentifier.getIndex();
        siReal = getSiRealFromNodes(filteredNodes, index);
        return siReal;
    }


    private SiReal getSiRealFromNodes(NodeList nodes, Integer index) throws XPathExpressionException {
        XPath xpath = XPathFactory.newInstance().newXPath();

        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);

            // check if node is a quantity and wether it hast XMLList or SiReal -> chose according strategy
            String quantityExpression = "boolean(//*[name()='dcc:quantity'])";
            Boolean nodeQuantityExist = (Boolean) xpath.evaluate(quantityExpression, node, XPathConstants.BOOLEAN);

            String siRealXmlListExpression = "boolean(//*[name()='si:realListXMLList'])";
            Boolean siRealXmlListNodeExist = (Boolean) xpath.evaluate(siRealXmlListExpression, node, XPathConstants.BOOLEAN);

            String siRealExpression = "boolean(//*[name()='si:real'])";
            Boolean siRealNodeExist = (Boolean) xpath.evaluate(siRealExpression, node, XPathConstants.BOOLEAN);

            // get siReal
            SiReal siReal = null;
            if (nodeQuantityExist && siRealXmlListNodeExist) {
                // get values of XML List
                String xPathExpression = "./realListXMLList/valueXMLList";
                String result = (String) xpath.compile(xPathExpression).evaluate(node, XPathConstants.STRING);
                List<Double> siValuesXMLList = Arrays.stream(result.split("\\s+"))
                        .map(Double::parseDouble).toList();

                // get unit of XML List
                xPathExpression = "./realListXMLList/unitXMLList";
                result = (String) xpath.compile(xPathExpression).evaluate(node, XPathConstants.STRING);
                List<String> siRealListUnitXMLList = Arrays.stream(result.split("\\s+")).toList();

                // get uncertainty of XML List
                xPathExpression = "./realListXMLList/expandedUncXMLList/uncertaintyXMLList";
                result = (String) xpath.compile(xPathExpression).evaluate(node, XPathConstants.STRING);
                List<Double> expandedUncXMLList = Arrays.stream(result.split("\\s+"))
                        .map(Double::parseDouble).toList();

                // get coverage factor of XML List
                xPathExpression = "./realListXMLList/expandedUncXMLList/coverageFactorXMLList";
                result = (String) xpath.compile(xPathExpression).evaluate(node, XPathConstants.STRING);
                List<Integer> coverageFactorXMLList = Arrays.stream(result.split("\\s+"))
                        .map(Integer::parseInt).toList();

                // get coverage probability of XML List
                xPathExpression = "./realListXMLList/expandedUncXMLList/coverageProbabilityXMLList";
                result = (String) xpath.compile(xPathExpression).evaluate(node, XPathConstants.STRING);
                List<Double> coverageProbabilityXMLList = Arrays.stream(result.split("\\s+"))
                        .map(Double::parseDouble).toList();

                // get distribution of XML List
                xPathExpression = "./realListXMLList/expandedUncXMLList/distributionXMLList";
                result = (String) xpath.compile(xPathExpression).evaluate(node, XPathConstants.STRING);
                List<String> siRealDistributionXMLList = Arrays.stream(result.split("\\s+")).toList();


                // build siReal
                SiExpandedMU siExpandedUnc = SiExpandedMU.builder()
                        .valueExpandedMU(getXMLListValueByIndex(expandedUncXMLList, index))//index
                        .coverageFactor(getXMLListValueByIndex(coverageFactorXMLList, index))
                        .coverageProbability(getXMLListValueByIndex(coverageProbabilityXMLList, index))
                        .distribution(getXMLListValueByIndex(siRealDistributionXMLList, index)).build();

                siReal = SiReal.builder().value(getXMLListValueByIndex(siValuesXMLList, index))// index
                        .unit(getXMLListValueByIndex(siRealListUnitXMLList, index))
                        .expandedMU(siExpandedUnc).build();

                return siReal;
            } else if (siRealNodeExist && nodeQuantityExist) {
                // get value of siReal
                String xPathExpression = "./real/value";
                String result = (String) xpath.compile(xPathExpression).evaluate(node, XPathConstants.STRING);
                Double siReaLValue = Double.valueOf(result);

                // get unit of siReal
                xPathExpression = "./real/unit";
                String siRealUnit = (String) xpath.compile(xPathExpression).evaluate(node, XPathConstants.STRING);

                // get uncertainty of siReal
                xPathExpression = "./real/expandedUnc/uncertainty";
                result = (String) xpath.compile(xPathExpression).evaluate(node, XPathConstants.STRING);
                Double siReaLUncertainty = Double.valueOf(result);

                // get coverage factor of siReal
                xPathExpression = "./real/expandedUnc/coverageFactor";
                result = (String) xpath.compile(xPathExpression).evaluate(node, XPathConstants.STRING);
                int siRealCoverageFactor = Integer.parseInt(result);

                // get coverage probability of siReal
                xPathExpression = "./real/expandedUnc/coverageProbability";
                result = (String) xpath.compile(xPathExpression).evaluate(node, XPathConstants.STRING);
                Double siRealCoverageProbability = Double.valueOf(result);

                // get distribution of siReal
                xPathExpression = "./real/expandedUnc/distribution";
                String siRealDistribution = (String) xpath.compile(xPathExpression).evaluate(node, XPathConstants.STRING);

                // build siReal
                SiExpandedMU siExpandedUnc = SiExpandedMU.builder()
                        .valueExpandedMU(siReaLUncertainty)//index
                        .coverageFactor(siRealCoverageFactor)
                        .coverageProbability(siRealCoverageProbability)
                        .distribution(siRealDistribution).build();

                siReal = SiReal.builder().value(siReaLValue)// index
                        .unit(siRealUnit)
                        .expandedMU(siExpandedUnc).build();

                return siReal;
            }
        }
        return null;
    }

    private <T> T getXMLListValueByIndex(List<T> list, int index){
        // gets value at index 0 if only one value is supplied in XMLList (e.g. uncertainty, distribution)
        // get value at index if a comple XML List is supplid
        int lenghtOfList = list.size();

        if (index < lenghtOfList) {
            return list.get(index);
        } else {
            return list.get(0);
        }
    }


    private void addDataToEntity(@Nonnull HashMap<String, ContributionEntityData> entityData, String identifierId, String contributionId, SiReal data) {
        ContributionEntityData contributionEntityData = entityData.get(identifierId);
        if (contributionEntityData == null) {
            entityData.put(identifierId, new ContributionEntityData());
            contributionEntityData = entityData.get(identifierId);
            contributionEntityData.getContributionData().put(contributionId, data);
        } else {
            contributionEntityData.getContributionData().put(contributionId, data);
        }
    }
}


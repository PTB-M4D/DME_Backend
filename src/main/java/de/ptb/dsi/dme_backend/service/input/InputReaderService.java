package de.ptb.dsi.dme_backend.service.input;

import de.ptb.dsi.dme_backend.model.*;
import jakarta.annotation.Nonnull;
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
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;/**/
import java.util.List;
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
//                    SiReal siRealLoadedData = readData(dataIdentifier, contributionFile);
//                    this.addDataToEntity(entity.getEntityData(), dataId, contributionId, siRealLoadedData);
                }
            }
        }
    }

    public Document readDocument(@Nonnull String pidInputData) throws ParserConfigurationException, IOException, SAXException {
        String urlPid = "http://localhost:8085/api/d-dcc/dcc/" + pidInputData + "";
//        String urlPid = "https://d-si.ptb.de/api/d-dcc/dcc/" + pidInputData + "";
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(urlPid, String.class, 200);
        byte[] byteBase64 = Base64.getDecoder().decode(response);
        String dccXml = new String(byteBase64);
        //parse the xml
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputSource is = new InputSource(new StringReader(dccXml));
        Document document = builder.parse(new InputSource(new StringReader(dccXml)));
        return document;
    }


    public SiReal readData() throws ParserConfigurationException, IOException, SAXException, XPathExpressionException {
//    public SiReal readData(@Nonnull DataIdentifier dataIdentifier, @Nonnull Document document) throws  XPathExpressionException {
        Document document;
        SiReal siReal = new SiReal();
//        document = readDocument("Temp_Comparison_PTB_1");
        document = readDocument("Mass_Comparison_PTB");
        document.getDocumentElement().normalize();
        XPath xpath = XPathFactory.newInstance().newXPath();
        if (document == null) {
            log.warn("Document is null");
            return null;
        }
//        String refId = dataIdentifier.getRefId();
//        int index= dataIdentifier.getIndex();
        String refId = "blackbody01";
        // Prüfen, ob refId definiert ist und nach Elementen mit dem angegebenen refId suchen
        XPathExpression exprRefId = xpath.compile("//*[@refId='" + refId + "']");
        NodeList refIdNodes = (NodeList) exprRefId.evaluate(document, XPathConstants.NODESET);
        log.info(refIdNodes != null && refIdNodes.getLength() > 0 ? "Found nodes for refId: {}" : "No nodes found for refId: {}", refId);
        if (refIdNodes.getLength() != 0 && refIdNodes != null) {
            String refType = "basic_measuredValue basic_arithmenticMean temperature_ITS-90";
            siReal = searchRefTypeInNode(refType, refIdNodes);
        } else {
//             Suche nach dcc-Elementen mit dem angegebenen refType
//            String refType = dataIdentifier.getRefType();
            String refType = "basic_measuredValue";
            XPathExpression exprRefTye = xpath.compile("//*[@refType='" + refType + "']");
            NodeList siRealNodeXMLList = (NodeList) exprRefTye.evaluate(document, XPathConstants.NODESET);
            siReal = searchRefTypeInNode(refType, siRealNodeXMLList);
        }
        return siReal;
    }

    private SiReal searchRefTypeInNode(String refType, NodeList nodes) throws XPathExpressionException {
        XPath xpath = XPathFactory.newInstance().newXPath();
        SiReal siReal = null;
        //        int index= dataIdentifier.getIndex();
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            XPathExpression exprRefTyp = xpath.compile("//*[@refType='" + refType + "']");
            NodeList refTypeNode = (NodeList) exprRefTyp.evaluate(node, XPathConstants.NODESET);
            NodeList siRealRefTypeListNode = refTypeNode.item(0).getChildNodes();
            String quantityExpression = "boolean(//*[name()='dcc:quantity'])";
            Boolean nodeQuantityExist = (Boolean) xpath.evaluate(quantityExpression, node, XPathConstants.BOOLEAN);
            System.out.println("nodeQuantityExist:  " + nodeQuantityExist);
            String siRealXmlListExpression = "boolean(//*[name()='si:realListXMLList'])";
            Boolean siRealXmlListNodeExist = (Boolean) xpath.evaluate(siRealXmlListExpression, node, XPathConstants.BOOLEAN);
            System.out.println("siRealXmlListNodeExist:  " + siRealXmlListNodeExist);
            String siRealExpression = "boolean(//*[name()='si:real'])";
            Boolean siRealNodeExist = (Boolean) xpath.evaluate(siRealExpression , node, XPathConstants.BOOLEAN);
            System.out.println("siRealNodeExist:  " +  siRealNodeExist);
            if (refTypeNode.getLength() != 0 && nodeQuantityExist && siRealXmlListNodeExist) {

                List<Double> siValuesXMLList = Arrays.stream(evaluateXPath(xpath, siRealRefTypeListNode, "//*[@refType='" + refType + "']/realListXMLList/valueXMLList")
                                .item(0).getTextContent()
                                .split("\\s+"))
                        .map(Double::parseDouble).collect(Collectors.toList());
                String siRealListUnitXMLList = evaluateXPath(xpath, siRealRefTypeListNode, "//*[@refType='" + refType + "']/realListXMLList/unitXMLList")
                        .item(0).getTextContent();
                List<Double> expandedUncXMLList = Arrays.stream(evaluateXPath(xpath, siRealRefTypeListNode, "//*[@refType='" + refType + "']/realListXMLList/expandedUncXMLList/uncertaintyXMLList")
                                .item(0).getTextContent()
                                .split("\\s+"))
                        .map(Double::parseDouble).collect(Collectors.toList());
                System.out.println(" siRealXMLList"+ siValuesXMLList);
                int coverageFactorXMLList = Integer.parseInt(evaluateXPath(xpath, siRealRefTypeListNode, "//*[@refType='" + refType + "']/realListXMLList/expandedUncXMLList/coverageFactorXMLList").item(0).getTextContent());
                Double siRealCoverageProbabilityXMLList = Double.valueOf(evaluateXPath(xpath, siRealRefTypeListNode, "//*[@refType='" + refType + "']/realListXMLList/expandedUncXMLList/coverageProbabilityXMLList")
                        .item(0).getTextContent());
                String siRealDistributionXMLList = evaluateXPath(xpath, siRealRefTypeListNode, "//*[@refType='" + refType + "']/realListXMLList/expandedUncXMLList/distributionXMLList")
                        .item(0).getTextContent();
                SiExpandedUnc siExpandedUnc = SiExpandedUnc.builder()
                        .uncertainty(expandedUncXMLList.get(0))
                        .coverageFactor(coverageFactorXMLList)
                        .coverageProbability(siRealCoverageProbabilityXMLList)
                        .distribution(siRealDistributionXMLList).build();
                siReal = SiReal.builder().value(siValuesXMLList.get(0))
                        .unit(siRealListUnitXMLList)
                        .expUnc(siExpandedUnc).build();
                System.out.println("siReal: "+siReal);
            } else if(siRealNodeExist && refTypeNode.getLength() != 0 && nodeQuantityExist &&  siRealNodeExist) {

                    Double siReaLValue = Double.valueOf(evaluateXPath(xpath, siRealRefTypeListNode, "//*[@refType='" + refType + "']/real/value").item(0).getTextContent());
                    String siReaLUnit = evaluateXPath(xpath, siRealRefTypeListNode, "//*[@refType='" + refType + "']/real/unit").item(0).getTextContent();
                    String siReaLDateTime = evaluateXPath(xpath, siRealRefTypeListNode, "//*[@refType='" + refType + "']/real/dateTime").item(0).getTextContent();
                    Double siReaLUncertainty = Double.valueOf(evaluateXPath(xpath, siRealRefTypeListNode, "//*[@refType='" + refType + "']/real/expandedUnc/uncertainty").item(0).getTextContent());
                    int siReaLCoverageFactor = Integer.parseInt(evaluateXPath(xpath, siRealRefTypeListNode, "//*[@refType='" + refType + "']/real/expandedUnc/coverageFactor").item(0).getTextContent());
                    Double siRealCoverageProbability = Double.valueOf(evaluateXPath(xpath, siRealRefTypeListNode, "//*[@refType='" + refType + "']/real/expandedUnc/coverageProbability").item(0).getTextContent());
                    SiExpandedUnc siExpandedUnc = SiExpandedUnc.builder()
                            .uncertainty(siReaLUncertainty)
                            .coverageFactor(siReaLCoverageFactor)
                            .coverageProbability(siRealCoverageProbability)
                            .build();
                    siReal = SiReal.builder()
                            .value(siReaLValue)
                            .unit(siReaLUnit)
                            .dateTime(siReaLDateTime)
                            .expUnc(siExpandedUnc).build();
                    System.out.println("siReaL: " + siReal);
                }
            else {return null;}
        }
        return siReal;
    }


    private NodeList evaluateXPath(@Nonnull XPath xpath, @Nonnull NodeList nodeList, @Nonnull String expression) {
        try {
            return (NodeList) xpath.compile(expression).evaluate(nodeList, XPathConstants.NODESET);
        } catch (XPathExpressionException e) {
            log.error("Error evaluating XPath: {}", expression, e);
            return null;
        }
    }

    private void addDataToEntity(@Nonnull HashMap<String, ContributionEntityData> entityData, String identifierId, String contributionId, SiReal data) {
        ContributionEntityData contributionEntityData = entityData.get(identifierId);
        if (contributionEntityData != null) {
            contributionEntityData.getContributionData().put(contributionId, data);
        }
    }
}


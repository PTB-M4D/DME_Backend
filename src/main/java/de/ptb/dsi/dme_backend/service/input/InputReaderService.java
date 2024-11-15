package de.ptb.dsi.dme_backend.service.input;

import de.ptb.dsi.dme_backend.model.*;
import jakarta.annotation.Nonnull;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.Document;
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
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;

@Service
@AllArgsConstructor
public class InputReaderService implements IInputReaderService {


    @Override
    public void loadData(ComparisonDataModel comparisonDataModel) throws ParserConfigurationException, IOException, SAXException, TransformerException {
        for (String contributionId : comparisonDataModel.getContributions().keySet()) {
            Contribution contribution = comparisonDataModel.getContributions().get(contributionId);
            Document contributionFile = readDocument(contribution.getPidInputData());
            for (EntityUnderComparison entity : comparisonDataModel.getEntities().values()) {
                for (String dataId : entity.getDataIdentifiers().keySet()) {
                    DataIdentifier dataIdentifier = entity.getDataIdentifiers().get(dataId);
//                    SiReal siRealLoadedData = readData(dataIdentifier,contributionFile);
//                    this.addDataToEntity(entity.getEntityData(), dataId, contributionId, siRealLoadedData);
                }
            }
        }
    }

    public Document readDocument(String pidInputData) throws ParserConfigurationException, IOException, SAXException {
        String urlPid = "http://localhost:8085/api/d-dcc/dcc/" + pidInputData + "";
//        String urlPid = "https://d-si.ptb.de/api/d-dcc/dcc/" + pidInputData + "";
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(urlPid, String.class, 200);
        byte[] byteBase64 = Base64.getDecoder().decode(response);
        String decodedXml = new String(byteBase64);

        //parse the xml
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputSource is = new InputSource(new StringReader(decodedXml));
        Document document = builder.parse(new InputSource(new StringReader(decodedXml)));
        return document;
    }

    public Document readData() throws ParserConfigurationException, IOException, SAXException, XPathExpressionException {
//        public SiReal readData(DataIdentifier dataIdentifier, Document document ) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException {
        Document document;
//        document = readDocument("Temp_Comparison_PTB_1");
        document = readDocument("Mass_Comparison_PTB");
//        document.getDocumentElement().normalize();

        XPath xpath = XPathFactory.newInstance().newXPath();
        NodeList elements;
//        String refId = dataIdentifier.getRefId();
        String refId = "blackbody01";

        // Schritt 2: Prüfen, ob refId definiert ist
        // Suche nach Elementen mit dem angegebenen refId
        XPathExpression exprRefId = xpath.compile("//*[@refId='" + refId + "']");
        elements = (NodeList) exprRefId.evaluate(document, XPathConstants.NODESET);

        if (elements.getLength() != 0) {
            // Suche nach Elementen mit dem angegebenen refType basic_humidityRelativeMin
//            String refType = dataIdentifier.getRefType();
            String refTypeTemp = "temperature_measuredValueSensor2";
            XPathExpression exprRefTye = xpath.compile("//*[@refType='" + refTypeTemp + "']/realListXMLList");
            elements = (NodeList) exprRefTye.evaluate(document, XPathConstants.NODESET);
            if (elements.getLength() != 0) {
                String firstElement = elements.item(0).getTextContent();
                System.out.println("tempSiRealXmlList:" + firstElement);
            }
        } else {
//             Suche nach dcc-Elementen mit dem angegebenen refType
//            String refType = dataIdentifier.getRefType();
            String refTypeMasse = "basic_measuredValue";
            XPathExpression exprRefTye = xpath.compile("//*[@refType='" + refTypeMasse + "']/real");
            elements = (NodeList) exprRefTye.evaluate(document, XPathConstants.NODESET);
            String firstElement = elements.item(0).getTextContent();
            System.out.println("siReal: " + firstElement);

        }
        //            //1 refType und refId auslesen
//            // 2 prüfen ob rfId definiert ist
////           2.1 wenn ja lese alle elemente die den refId beinhalten
////            2.2 wenn nein weiter Schritt 3
////            3 fall 2.1 lese alle dcc elemente, die den refType haben aus der liste mit den refIds
////               ansonsten 2.2 ganze dcc durchsuchen
//            // 4 refId und refType gefilterte elemente nur den ersten element auslesen
////            4.1 prüfe ob Node dccQuantity ist
////            prüfe ob in quantity siReal oder siRealXmlList
////            4.1.1 siReal
////            4.1.2 siRealXmlList index abholen aus dataIdentIdentifier

        return document;
    }


    private void addDataToEntity(@Nonnull HashMap<String, ContributionEntityData> entityData, String identifierId, String contributionId, SiReal data) {
        ContributionEntityData contributionEntityData = entityData.get(identifierId);
        contributionEntityData.getContributionData().put(contributionId, data);
    }


}

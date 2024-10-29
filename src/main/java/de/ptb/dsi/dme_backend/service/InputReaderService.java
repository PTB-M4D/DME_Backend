package de.ptb.dsi.dme_backend.service;

import de.ptb.dsi.dme_backend.model.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Base64;
import java.util.HashMap;

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
                    SiReal siRealLoadedData = readData(dataIdentifier,contributionFile);
                    this.addDataToEntity(entity.getEntityData(), dataId, contributionId, siRealLoadedData);
                }
            }
        }
    }

    public Document readDocument(String pidInputData) throws ParserConfigurationException, IOException, SAXException {
        Document document;
        String urlPid = "http://localhost:8085/api/d-dcc/dcc/" + pidInputData + "";
//        String urlPid = "https://d-si.ptb.de/api/d-dcc/dccPidList" + pidInputData + "";
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(urlPid, String.class, 200);
        byte[] byteBase64 = Base64.getDecoder().decode(response);
        String decodedXml = new String(byteBase64);

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        builder = factory.newDocumentBuilder();
        document = builder.parse(new InputSource(new StringReader(decodedXml)));
        return document;

    }

    public SiReal readData(DataIdentifier dataIdentifier, Document document ) throws TransformerException, ParserConfigurationException, IOException, SAXException {
        return null;
    }
    private void addDataToEntity(HashMap<String, ContributionEntityData> entityData, String identifierId, String contributionId, SiReal data) {
        ContributionEntityData contributionEntityData = entityData.get(identifierId);
        contributionEntityData.getContributionData().put(contributionId, data);
    }

}

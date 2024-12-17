package de.ptb.dsi.dme_backend.service;


import com.fasterxml.jackson.databind.JsonNode;
import de.ptb.dsi.dme_backend.model.*;
import de.ptb.dsi.dme_backend.service.domain.VirtualMassComparisonService;
import de.ptb.dsi.dme_backend.service.domain.VirtualRadTemperatureComparisonService;
import jakarta.xml.bind.JAXBException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;


@Service
@AllArgsConstructor
public class DmeService {
    VirtualRadTemperatureComparisonService virtualRadTemperatureComparisonService;
    VirtualMassComparisonService virtualMassComparisonService;


    public OutputReport evaluate(JsonNode inputJson) throws DatatypeConfigurationException, XPathExpressionException, JAXBException, ParserConfigurationException, IOException, TransformerException, SAXException {

        JsonNode data = inputJson.get("keyComparisonData");
        String smartStandard = (data.get("smartStandardEvaluationMethod")).asText();

        if (smartStandard.equals("radiationTempComparison")) {
            return virtualRadTemperatureComparisonService.evaluateComparison(inputJson);
        }
        if (smartStandard.equals("massIntercomparison")) {
            return virtualMassComparisonService.evaluateComparison(inputJson);
        } else return new OutputReport("pidReport not found", "base64 not found");
//TODO exceptions ergänzen
    }

}

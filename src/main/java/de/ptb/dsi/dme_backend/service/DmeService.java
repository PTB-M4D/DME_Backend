package de.ptb.dsi.dme_backend.service;

import com.fasterxml.jackson.databind.JsonNode;
import de.ptb.dsi.dme_backend.model.*;
import de.ptb.dsi.dme_backend.service.domain.IComparisonEvaluationService;
import de.ptb.dsi.dme_backend.service.domain.VirtualMassComparisonService;
import de.ptb.dsi.dme_backend.service.domain.VirtualRadTemperatureComparisonService;
import jakarta.xml.bind.JAXBException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
@AllArgsConstructor
public class DmeService {
    private final Map<String, IComparisonEvaluationService> serviceMap = new HashMap<>();
    @Autowired
    public DmeService(List<IComparisonEvaluationService> services) {
        for (IComparisonEvaluationService service : services) {
            if (service instanceof VirtualRadTemperatureComparisonService) {
                serviceMap.put("radiationTempComparison", service);
            } else if (service instanceof VirtualMassComparisonService) {
                serviceMap.put("massIntercomparison", service);
            }
        }
    }
         public OutputReport evaluate(JsonNode inputJson) throws DatatypeConfigurationException, XPathExpressionException, JAXBException, ParserConfigurationException, IOException, TransformerException, SAXException {
             OutputReport outputReport = null;
             JsonNode data = inputJson.get("keyComparisonData");
             String evaluationMethod = data.get("smartStandardEvaluationMethod").asText();
             switch (evaluationMethod) {
                 case "radiationTempComparison":
                     IComparisonEvaluationService TempService = serviceMap.get("radiationTempComparison");
                     if (TempService != null) {
                         outputReport = TempService.evaluateComparison(inputJson);
                     }
                     break;
                 case "massIntercomparison":
                     IComparisonEvaluationService massService = serviceMap.get("massIntercomparison");
                     if (massService != null) {
                         outputReport = massService.evaluateComparison(inputJson);
                     }
                     break;
                 default:
                     System.out.println("Method not recognized.");
                     break;
             }
             return outputReport;
         }
//    public OutputReport evaluate(JsonNode inputJson) throws DatatypeConfigurationException, XPathExpressionException, JAXBException, ParserConfigurationException, IOException, TransformerException, SAXException {
//        OutputReport outputReport = null;
//        JsonNode data = inputJson.get("keyComparisonData");
//        String method = data.get("smartStandardEvaluationMethod").asText();
//
//
//            for (IComparisonEvaluationService virtualService : virtualServices) {
//                switch (method) {
//                    case "radiationTempComparison":
//                        if (virtualService instanceof VirtualRadTemperatureComparisonService) {
//                            outputReport = virtualService.evaluateComparison(inputJson);
//                        }
//                        break;
//                    case "massIntercomparison":
//                        if (virtualService instanceof VirtualMassComparisonService) {
//                            outputReport = virtualService.evaluateComparison(inputJson);
//                        }
//                        break;
//                }
//            }
//        return outputReport;
//    }
}
////TODO exceptions ergänzen
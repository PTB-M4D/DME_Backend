package de.ptb.dsi.dme_backend.service;


import com.fasterxml.jackson.databind.JsonNode;
import de.ptb.dsi.dme_backend.model.*;
import de.ptb.dsi.dme_backend.service.domain.IComparisonEvaluationService;
import de.ptb.dsi.dme_backend.service.domain.LaboratoryMedicineComparisonService;
import de.ptb.dsi.dme_backend.service.domain.MassComparisonService;
import de.ptb.dsi.dme_backend.service.domain.RadTemperatureComparisonService;
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
            if (service instanceof RadTemperatureComparisonService) {
                serviceMap.put("radiationTempComparison", service);
            } else if (service instanceof MassComparisonService) {
                serviceMap.put("massIntercomparison", service);
            } else if (service instanceof LaboratoryMedicineComparisonService) {
                serviceMap.put("laboratoryMedicineComparison", service);
            }
        }
    }

    public OutputReport evaluate(JsonNode inputJson) throws DatatypeConfigurationException, XPathExpressionException, JAXBException, ParserConfigurationException, IOException, TransformerException, SAXException {
        OutputReport outputReport;
        IComparisonEvaluationService evaluationService = null;
        JsonNode data = inputJson.get("keyComparisonData");
        String evaluationMethod = data.get("smartStandardEvaluationMethod").asText();
        if (evaluationMethod == null || evaluationMethod.isEmpty()) {
            throw new IllegalArgumentException("Evaluation method cannot be null or empty.");
        }
        switch (evaluationMethod) {
            case "radiationTempComparison":
                evaluationService = serviceMap.get("radiationTempComparison");
                break;
            case "massIntercomparison":
                evaluationService = serviceMap.get("massIntercomparison");
                break;
            case "laboratoryMedicineComparison":
                evaluationService = serviceMap.get("laboratoryMedicineComparison");
                break;
            default:
                System.out.println("Method not recognized.");
                break;
        }
        if (evaluationService == null) {
            throw new IllegalArgumentException("Evaluation service not found for method: " + evaluationMethod);
        }
        outputReport = evaluationService.evaluateComparison(inputJson);
        return outputReport;
    }
//    List<IComparisonEvaluationService> virtualServices;
//    public OutputReport evaluate(JsonNode inputJson) throws DatatypeConfigurationException, XPathExpressionException, JAXBException, ParserConfigurationException, IOException, TransformerException, SAXException {
//        OutputReport outputReport = null;
//        JsonNode data = inputJson.get("keyComparisonData");
//        String method = data.get("smartStandardEvaluationMethod").asText();
//
//
//            for (IComparisonEvaluationService virtualService : virtualServices) {
//                switch (method) {
//                    case "radiationTempComparison":
//                        if (virtualService instanceof RadTemperatureComparisonService) {
//                            outputReport = virtualService.evaluateComparison(inputJson);
//                        }
//                        break;
//                    case "massIntercomparison":
//                        if (virtualService instanceof MassComparisonService) {
//                            outputReport = virtualService.evaluateComparison(inputJson);
//                        }
//                        break;
//                }
//            }
//        return outputReport;
//    }
}
////TODO exceptions ergänzen
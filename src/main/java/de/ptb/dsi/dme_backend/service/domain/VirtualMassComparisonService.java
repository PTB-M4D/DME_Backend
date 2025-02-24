package de.ptb.dsi.dme_backend.service.domain;

import com.fasterxml.jackson.databind.JsonNode;
import de.ptb.dsi.dme_backend.model.*;
import de.ptb.dsi.dme_backend.model.dcc.*;
import de.ptb.dsi.dme_backend.service.input.InputReaderService;
import de.ptb.dsi.dme_backend.service.output.DccServiceOutputWriter;
import de.ptb.dsi.dme_backend.service.submodel.*;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

@Service
@AllArgsConstructor

public class VirtualMassComparisonService implements IComparisonEvaluationService {

    private final InputReaderService inputReaderService;
    private final StandardBilateralEnValueCalculationService bilateralEnValueCalculationService;
    private final DccServiceOutputWriter dccServiceOutputWriter;
    private final StandardBilateralDeviationCalculationService bilateralDeviationCalculationService;

    @Override
    public OutputReport evaluateComparison(JsonNode inputJson) throws XPathExpressionException, ParserConfigurationException, IOException, TransformerException, SAXException, JAXBException, DatatypeConfigurationException {

        OutputReport outputReport = null;
        ComparisonDataModel comparisonDataModel = new ComparisonDataModel();
        JsonNode dataReport = inputJson.get("keyComparisonData");

        // 1) Contribution Inhalte kommen aus UI
        for (JsonNode participant_node : dataReport.get("participantList")) {
            participant_node = participant_node.get("participant");

            String participantName = participant_node.get("name").asText();
            String pidDcc = participant_node.get("pidDCC").asText();
            String[] parts = pidDcc.split("/");
            String contributionId = parts[parts.length-1];

            Contribution participant = new Contribution(contributionId, participantName, pidDcc);
            comparisonDataModel.getContributions().put(participant.getContributionId(), participant);
        }

        // 2) smartStandard und PidReport festlegen -> wählt korrekte Administrativdaten in Outputwriter
        String smartStandard = dataReport.get("smartStandardEvaluationMethod").asText();
        comparisonDataModel.setSmartStandard(smartStandard);

        String pidReport= dataReport.get("pidReport").asText();
        comparisonDataModel.setPidReport(pidReport);

        // 3) Dataidentifier festlegen (später über UI) -> Werte im DCC finden, refType basic measured value (später über UI)
        DataIdentifier dataIdentifier = DataIdentifier.builder()
                .refType("basic_measuredValue")
                .refTypes(Collections.singletonList("basic_measuredValue"))
                .id("measuredValue") //für Temperature würde noch refId dazukommen
                .siLabel("measured mass")
                .index(0).build();

        // 4) EntityUnderComparison erzeugen z.B. "mass" oder "temp_setpoint1"
        EntityUnderComparison entityUnderComparison = new EntityUnderComparison();
        entityUnderComparison.setEntityId("measuredValue"); // kommt aus UI? automatisch generiert?
        entityUnderComparison.getDataIdentifiers().put(dataIdentifier.getId(), dataIdentifier);
        comparisonDataModel.getEntities().put(entityUnderComparison.getEntityId(), entityUnderComparison); // EntityUnderComparison ins comparsionDatamodel einfügen


        // 5) Input Reader starten
        // mit dataIdentifier aus den EntityUnderComparison imComparisonDataModel, die entsprechenden Werte aus dem DCC einlesen
        // EntityUnderComparison -> ContributionEntityData -> Hashmap<SiReal> {"1": SiReal, "2": SiReal, "3": SiReal}

        inputReaderService.loadData(comparisonDataModel);

        // Schleife über alle EntityUnderComparison
        // Auswertung hier nur für EntityUnderComparison mit id = "mass"
        Set<String> entityUnderComparisonIds = comparisonDataModel.getEntities().keySet();
        for (String entityUnderComparisonId : entityUnderComparisonIds) {
            EntityUnderComparison entity = comparisonDataModel.getEntities().get(entityUnderComparisonId);
            int lastOutlierLength = -1;
            int currentOutlierLength = 0;
            //----- Auswerteschleife beginnt hier
            while (lastOutlierLength != currentOutlierLength) {
                lastOutlierLength = currentOutlierLength;
                // AnalysisOutput in EntityUnderComparison erzeugen
                String investigatedDataIdentifierId = "measuredValue"; // Data under investigation
                AnalysisOutput analysisOutput = new AnalysisOutput(investigatedDataIdentifierId);

                // Wenn schon vorheriger Analysisoutput vorhanden -> Outlier liste holen
                analysisOutput.setOutliers(new ArrayList<>());
                if (currentOutlierLength > 0) {
                    analysisOutput.setOutliers(entity.getAnalysisOutputs().get((entity.getAnalysisOutputs().size()) - 1).getOutliers());
                }

                // Outlier aus Contribution aussortieren -> neue Liste ohne Outlier
                List<String> outliers = analysisOutput.getOutliers();
                HashMap<String, SiReal> contributionData = entity.getEntityData().get(investigatedDataIdentifierId).getContributionData();
                HashMap<String, SiReal> contributingData = new HashMap<>();
                for (String id : contributionData.keySet()) {
                    if (!outliers.contains(id)) {
                        contributingData.put(id, contributionData.get(id));
                    }
                }

                // weigehted mean berechnen
                WeightedMeanCalculationService weightedMeanCalculationService = new WeightedMeanCalculationService();
                ReferenceValue referenceValue = weightedMeanCalculationService.calculateReferenceValue(contributingData);
                analysisOutput.setRefValue(referenceValue);

                // En werte berechnen
//                HashMap<String, SiReal> contributionMeasuredValues = new HashMap<>();
//                for (String contributionId : comparisonDataModel.getContributions().keySet()){
//                    contributionMeasuredValues.put(contributionId, entity.getEntityData().get(contributionId).getContributionData().get(contributionId));
//                }
                StandardEnValueCalculationService enValueCalculationService = new StandardEnValueCalculationService();
                HashMap<String, EnValue> enValues = enValueCalculationService.calculateEnValue(contributionData, referenceValue, analysisOutput.getOutliers());
                analysisOutput.setEnValues(enValues);

                // Berecnung der Bilateralen En Werte
                HashMap<String, Contribution> contributions = comparisonDataModel.getContributions();
                HashMap<String, HashMap<String, BilateralEnValue>> bilateralEnValues =
                        bilateralEnValueCalculationService.calculateBilateralEnValues(entity.getEntityData().get(investigatedDataIdentifierId).getContributionData(), contributions);
                analysisOutput.setBilateralEnValues(bilateralEnValues);

                // Berechnung der bilateralen Abweichungen der Messwerte
                HashMap<String, HashMap<String, SiReal>> bilateralDeviations =
                        bilateralDeviationCalculationService.calculateBilateralDeviations(entity.getEntityData().get(investigatedDataIdentifierId).getContributionData(), contributions);
                analysisOutput.setBilateralDeviations(bilateralDeviations);


                // ConsistencyCheck
                EnCriterionConsistencyCheckService consistencyCheckService = new EnCriterionConsistencyCheckService();
                consistencyCheckService.evaluateConsistency(analysisOutput);

                // Entscheidung, ob geflaggte Contributions als Outlier aufgenommen werden sollen
                DecisionProcessingService decisionProcessingService = new DecisionProcessingService();
                decisionProcessingService.processDecision(analysisOutput, true);

                // AnalysisOutput in EntityUnderComparison hinzufügen
                entity.getAnalysisOutputs().add(analysisOutput);

                // hat sich Anzahl der Outlier geändert? Kriterium für nächsten Durchlauf
                currentOutlierLength = entity.getAnalysisOutputs().get(entity.getAnalysisOutputs().size() - 1).getOutliers().size();
            }
        }
        String base64 = dccServiceOutputWriter.createOutputReport(comparisonDataModel);
        outputReport= new OutputReport(pidReport,base64);

        return outputReport;
    }

}





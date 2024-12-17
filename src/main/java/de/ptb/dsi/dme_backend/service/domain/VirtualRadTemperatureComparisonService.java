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
public class VirtualRadTemperatureComparisonService implements IComparisonEvaluationService {
    //
    private final InputReaderService inputReaderService;
    private final Pt100TemperatureFromResistanceCalculatorService pt100TemperatureFromResistanceCalculatorService;
    private final StandardDifferenceCalculatorService differenceCalculatorService;
    private final StandardBilateralEnValueCalculationService bilateralEnValueCalculationService;
    private final DccServiceOutputWriter dccServiceOutputWriter;
    @Override
    public OutputReport evaluateComparison(JsonNode inputJson) throws XPathExpressionException, ParserConfigurationException, IOException, TransformerException, SAXException, JAXBException, DatatypeConfigurationException {


        JsonNode dataReport = inputJson.get("keyComparisonData");
        String pidReport= dataReport.get("pidReport").asText();
        System.out.println("pidReport:   "+ pidReport);
        List<Contribution> contributionList = new ArrayList<>();
        OutputReport outputReport = null;
        for (JsonNode participant_node : dataReport.get("participantList")) {
            participant_node = participant_node.get("participant");
            String participantName =participant_node.get("name").asText();
            String pidDcc= participant_node.get("pidDCC").asText();
            Contribution participant = new Contribution(participantName, participantName, pidDcc);
            contributionList.add(participant);
            ComparisonDataModel comparisonDataModel = new ComparisonDataModel();
            comparisonDataModel.getContributions().put(participant.getContributionId(), participant);
            System.out.println("comparisonDataModel:   " + comparisonDataModel);
            // 1) Contribution Inhalte kommen aus UI
            // 2) Dataidentifier festlegen (später über UI) -> Werte im DCC finden, refType basic measured value (später über UI)
            // 3) Dataidentifier festlegen (später über UI) -> Werte im DCC finden, refType basic measured value (später über UI)
        DataIdentifier dataIdentRadTemp1 = DataIdentifier.builder()
                .id("radTemp")
                .siLabel("Radiation temperature at setpoint 1")
                .refId("blackbody01")
                .refType("basic_measuredValue basic_arithmenticMean temperature_ITS-90")
                .index(0).build();
        DataIdentifier dataIdentRadTemp2 = DataIdentifier.builder()
                .id("radTemp")
                .siLabel("Radiation temperature at setpoint 2")
                .refId("blackbody01")
                .refType("basic_measuredValue basic_arithmenticMean temperature_ITS-90")
                .index(1).build();
        DataIdentifier dataIdentRadTemp3 = DataIdentifier.builder()
                .id("radTemp")
                .siLabel("Radiation temperature at setpoint 3")
                .refId("blackbody01")
                .refType("basic_measuredValue basic_arithmenticMean temperature_ITS-90")
                .index(2).build();

        DataIdentifier dataIdentSensor11 = DataIdentifier.builder()
                .id("sensor1")
                .siLabel("Resistance of pt-100 at setpoint 1")
                .refId("blackbody01")
                .refType("temperature_measuredValueSensor1")
                .index(0).build();
        DataIdentifier dataIdentSensor12 = DataIdentifier.builder()
                .id("sensor1")
                .siLabel("Resistance of pt-100 at  setpoint 2")
                .refId("blackbody01")
                .refType("temperature_measuredValueSensor1")
                .index(1).build();
        DataIdentifier dataIdentSensor13 = DataIdentifier.builder()
                .id("sensor1")
                .siLabel("Resistance of pt-100 at  setpoint 3")
                .refId("blackbody01")
                .refType("temperature_measuredValueSensor1")
                .index(2).build();

        // 4) EntityUnderComparison erzeugen z.B. "mass" oder "temp_setpoint1"
        EntityUnderComparison entityUnderComparison1 = new EntityUnderComparison();
        entityUnderComparison1.setEntityId("temp-setpoint1"); // "radTemp"
        entityUnderComparison1.getDataIdentifiers().put(dataIdentRadTemp1.getId(), dataIdentRadTemp1);
        entityUnderComparison1.getDataIdentifiers().put(dataIdentSensor11.getId(), dataIdentSensor11);

        EntityUnderComparison entityUnderComparison2 = new EntityUnderComparison();
        entityUnderComparison2.setEntityId("temp-setpoint2"); // "radTemp"
        entityUnderComparison2.getDataIdentifiers().put(dataIdentRadTemp2.getId(), dataIdentRadTemp2);
        entityUnderComparison2.getDataIdentifiers().put(dataIdentSensor12.getId(), dataIdentSensor12);

        EntityUnderComparison entityUnderComparison3 = new EntityUnderComparison();
        entityUnderComparison3.setEntityId("temp-setpoint3"); // "radTemp"
        entityUnderComparison3.getDataIdentifiers().put(dataIdentRadTemp3.getId(), dataIdentRadTemp3);
        entityUnderComparison3.getDataIdentifiers().put(dataIdentSensor13.getId(), dataIdentSensor13);

        // EntityUnderComparison ins comparsionDatamodel einfügen
        comparisonDataModel.getEntities().put(entityUnderComparison1.getEntityId(), entityUnderComparison1);
        comparisonDataModel.getEntities().put(entityUnderComparison2.getEntityId(), entityUnderComparison2);
        comparisonDataModel.getEntities().put(entityUnderComparison3.getEntityId(), entityUnderComparison3);



        // 5) Input Reader starten
        // mit dataIdentifier aus den EntityUnderComparison imComparisonDataModel, die entsprechenden Werte aus dem DCC einlesen
        // EntityUnderComparison -> ContributionEntityData -> Hashmap<SiReal> {"1": SiReal, "2": SiReal, "3": SiReal}
        inputReaderService.loadData(comparisonDataModel);


        // Schleife über alle EntityUnderComparison
        // Auswertung hier nur für EntityUnderComparison mit id = "mass"
        Set<String> entityUnderComparisonIds = comparisonDataModel.getEntities().keySet();
        for (String entityUnderComparisonId : entityUnderComparisonIds) {
            EntityUnderComparison entity = comparisonDataModel.getEntities().get(entityUnderComparisonId);

            // Badtemperatur aus Widerstandswert Sensor 1 berechnen
            // pt100 temperatur berechnen und zur EntityUnderComparison hinzufügen
            ContributionEntityData sensor1Data = entity.getEntityData().get("sensor1");
            ContributionEntityData bathTempData = new ContributionEntityData();
            for (String key : sensor1Data.getContributionData().keySet()){
                SiReal resistance = sensor1Data.getContributionData().get(key);
                SiReal bathTemp = pt100TemperatureFromResistanceCalculatorService.calculateTemperature(resistance);
                bathTempData.getContributionData().put(key, bathTemp);
            }

            // neuen Dataidentifier anlegen und zur EntityUnderComparison hinzufügen
            DataIdentifier dataIdentifierBathTemp = DataIdentifier.builder()
                    .id("pt100Temp")
                    .refType("temperature_referenceValue")
                    .refId("blackbody01")
                    .siLabel("Temperature reference calculated from pt-100 resistance")
                    .index(entity.getDataIdentifiers().get("sensor1").getIndex()).build();
            entity.getDataIdentifiers().put(dataIdentifierBathTemp.getId(), dataIdentifierBathTemp);
            entity.getEntityData().put(dataIdentifierBathTemp.getId(), bathTempData);
            System.out.println("pt100 Temperatur fertig");

            // Temperaturdifferenz radianceTemperature - BadTemperatur berechnen -> eigentliche Vergleichsgröße
            ContributionEntityData radTempData = entity.getEntityData().get("radTemp");
            ContributionEntityData tempDiffData = new ContributionEntityData();
            for (String key : radTempData.getContributionData().keySet()){
                SiReal radTemp = radTempData.getContributionData().get(key);
                SiReal bathTemp = bathTempData.getContributionData().get(key);
                SiReal tempDiff = differenceCalculatorService.calculateDifference(radTemp, bathTemp);
                tempDiffData.getContributionData().put(key, tempDiff);
            }

            // neuen Dataidentifier anlegen und zur EntityUnderComparison hinzufügen
            DataIdentifier dataIdentifierTempDiff = DataIdentifier.builder()
                    .id("tempDiff")
                    .refType("temperature_differenceValue")
                    .refId("blackbody01")
                    .siLabel("Temperature differences between reference temperatures and radiance temperatures")
                    .index(entity.getDataIdentifiers().get("radTemp").getIndex()).build();
            entity.getDataIdentifiers().put(dataIdentifierTempDiff.getId(), dataIdentifierTempDiff);
            entity.getEntityData().put(dataIdentifierTempDiff.getId(), tempDiffData);
            System.out.println("Temperatur Difference fertig");


            //Enwerte berechnen und Outlier aussortieren
            int lastOutlierLength = -1;
            int currentOutlierLength = 0;
            //----- Auswerteschleife beginnt hier
            while (lastOutlierLength != currentOutlierLength) {
                lastOutlierLength = currentOutlierLength;

                // AnalysisOutput in EntityUnderComparison erzeugen
                String investigatedDataIdentifierId = "tempDiff"; // Data under investigation
                AnalysisOutput analysisOutput = new AnalysisOutput(investigatedDataIdentifierId);

                // Wenn schon vorheriger Analysisoutput vorhanden -> Outlier liste holen
                analysisOutput.setOutliers(new ArrayList<>());
                if (currentOutlierLength > 0) {
                    analysisOutput.setOutliers(entity.getAnalysisOutputs().get((entity.getAnalysisOutputs().size())-1).getOutliers());
                }

                // Outlier aus Contribution aussortieren -> neue Liste ohne Outlier
                HashMap<String, SiReal> allContributionData = entity.getEntityData().get(investigatedDataIdentifierId).getContributionData();
                HashMap<String ,SiReal> contributingData = new HashMap<>();
                for (String id : allContributionData.keySet()) {
                    if (!analysisOutput.getOutliers().contains(id)) {
                        contributingData.put(id, allContributionData.get(id));
                    }
                }

                // weigehted mean berechnen
                WeightedMeanCalculationService weightedMeanCalculationService = new WeightedMeanCalculationService();
                ReferenceValue referenceValue = weightedMeanCalculationService.calculateReferenceValue(contributingData);
                analysisOutput.setRefValue(referenceValue);

                // En werte berechnen
                StandardEnValueCalculationService enValueCalculationService = new StandardEnValueCalculationService();
                HashMap<String, EnValue> enValues = enValueCalculationService.calculateEnValue(allContributionData, referenceValue, analysisOutput.getOutliers());
                analysisOutput.setEnValues(enValues);
                // Berecnung der Bilateralen En Werte
                HashMap<String, Contribution> contributions = comparisonDataModel.getContributions();
                HashMap<String, HashMap<String, BilateralEnValue>> bilateralEnValues =
                        bilateralEnValueCalculationService.calculateBilateralEnValues(entity.getEntityData().get(investigatedDataIdentifierId).getContributionData(), contributions);
                analysisOutput.setBilateralEnValues(bilateralEnValues);

                // ConsistencyCheck
                EnCriterionConsistencyCheckService consistencyCheckService = new EnCriterionConsistencyCheckService();
                consistencyCheckService.evaluateConsistency(analysisOutput);

                // Entscheidung, ob geflaggte Contributions als Outlier aufgenommen werden sollen
                DecisionProcessingService decisionProcessingService = new DecisionProcessingService();
                decisionProcessingService.processDecision(analysisOutput, true);

                // AnalysisOutput in EntityUnderComparison hinzufügen
                entity.getAnalysisOutputs().add(analysisOutput);

                // hat sich Anzahl der Outlier geändert? Kriterium für nächsten Durchlauf
                currentOutlierLength = entity.getAnalysisOutputs().get(entity.getAnalysisOutputs().size()-1).getOutliers().size();
            }
        }

        // Output report erzeugen
        // API antwort als JSON bzw base64
            String base64 = dccServiceOutputWriter.createOutputReportTemp(comparisonDataModel);
            outputReport= new OutputReport(pidReport,base64);
        }
        return outputReport;
    }


}

package de.ptb.dsi.dme_backend.service.domain;

import de.ptb.dsi.dme_backend.model.*;
import de.ptb.dsi.dme_backend.service.input.InputReaderService;
import de.ptb.dsi.dme_backend.service.submodel.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class VirtualRadTemperatureComparisonService implements IComparisonEvaluationService {
    //    private ComparisonDataModel comparisonDataModel;
    private final InputReaderService inputReaderService;
    private final Pt100TemperatureFromResistanceCalculatorService pt100TemperatureFromResistanceCalculatorService;
    private final StandardDifferenceCalculatorService differenceCalculatorService;

    @Override
    public String evaluateComparison(String inputJson) throws XPathExpressionException, ParserConfigurationException, IOException, TransformerException, SAXException {

        ComparisonDataModel comparisonDataModel = new ComparisonDataModel();

        // 1) Contribution Inhalte kommen aus UI
        Contribution contribution1 = new Contribution("PTB1", "PTB","Temp_Comparison_PTB_1");
        Contribution contribution2 = new Contribution("PTB2", "PTB","Temp_Comparison_PTB_2");
        Contribution contribution3 = new Contribution("PTB3", "PTB","Temp_Comparison_PTB_3");
        Contribution contribution4 = new Contribution("PTB4", "PTB","Temp_Comparison_PTB_4_Ausreisser");

        // 2) Contributions im Comparisondatamodel einfügen
        comparisonDataModel.getContributions().put(contribution1.getContributionId(), contribution1);
        comparisonDataModel.getContributions().put(contribution2.getContributionId(), contribution2);
        comparisonDataModel.getContributions().put(contribution3.getContributionId(), contribution3);
        comparisonDataModel.getContributions().put(contribution4.getContributionId(), contribution4);


        // 3) Dataidentifier festlegen (später über UI) -> Werte im DCC finden, refType basic measured value (später über UI)
        DataIdentifier dataIdentRadTemp1 = DataIdentifier.builder()
                .id("radTemp")
                .siLabel("setpoint1")
                .refId("blackbody01")
                .refType("basic_measuredValue basic_arithmenticMean temperature_ITS-90")
                .index(0).build();
        DataIdentifier dataIdentRadTemp2 = DataIdentifier.builder()
                .id("radTemp")
                .siLabel("setpoint2")
                .refId("blackbody01")
                .refType("basic_measuredValue basic_arithmenticMean temperature_ITS-90")
                .index(1).build();
        DataIdentifier dataIdentRadTemp3 = DataIdentifier.builder()
                .id("radTemp")
                .siLabel("setpoint3")
                .refId("blackbody01")
                .refType("basic_measuredValue basic_arithmenticMean temperature_ITS-90")
                .index(2).build();

        DataIdentifier dataIdentSensor11 = DataIdentifier.builder()
                .id("sensor1")
                .siLabel("setpoint1")
                .refId("blackbody01")
                .refType("temperature_measuredValueSensor1")
                .index(0).build();
        DataIdentifier dataIdentSensor12 = DataIdentifier.builder()
                .id("sensor1")
                .siLabel("setpoint2")
                .refId("blackbody01")
                .refType("temperature_measuredValueSensor1")
                .index(1).build();
        DataIdentifier dataIdentSensor13 = DataIdentifier.builder()
                .id("sensor1")
                .siLabel("setpoint3")
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
                AnalysisOutput analysisOutput = new AnalysisOutput();
                if (currentOutlierLength > 0) {
                    analysisOutput.setOutliers(entity.getAnalysisOutputs().get((entity.getAnalysisOutputs().size())-1).getOutliers());
                }

                // Outlier aus Contribution aussortieren -> neue Liste ohne Outlier
                List<String> outliers = analysisOutput.getOutliers();
                HashMap<String, SiReal> allContributionData = entity.getEntityData().get("tempDiff").getContributionData();
                HashMap<String ,SiReal> contributingData = new HashMap<>();
                for (String id : allContributionData.keySet()) {
                    if (!outliers.contains(id)) {
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
        return null;
    }
}

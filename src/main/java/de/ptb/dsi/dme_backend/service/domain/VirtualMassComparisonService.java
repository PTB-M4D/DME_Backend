package de.ptb.dsi.dme_backend.service.domain;

import de.ptb.dsi.dme_backend.model.*;
import de.ptb.dsi.dme_backend.service.submodel.DecisionProcessingService;
import de.ptb.dsi.dme_backend.service.submodel.EnCriterionConsistencyCheckService;
import de.ptb.dsi.dme_backend.service.submodel.StandardEnValueCalculationService;
import de.ptb.dsi.dme_backend.service.submodel.WeightedMeanCalculationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class VirtualMassComparisonService implements IComparisonEvaluationService {
//    private ComparisonDataModel comparisonDataModel;

    @Override
    public String evaluateComparison(String inputJson) {

        // 1) Contribution Inhalte kommen aus UI
        Contribution contribution1 = new Contribution("1", "UME","Mass_Comparison_UME");
        Contribution contribution2 = new Contribution("2", "NRC","Mass_Comparison_NRC");
        Contribution contribution3 = new Contribution("3", "PTB","Mass_Comparison_PTB_outlier");

        // 2) Dataidentifier festlegen (später über UI) -> Werte im DCC finden, refType basic measured value (später über UI)
        DataIdentifier dataIdentifier = new DataIdentifier();
        dataIdentifier.setRefType("basic_measuredValue"); //für Temperature würde noch refId dazukommen

        // 3) ComparisonDataModel erzeugen und auffüllen
        // Hard coded Erzeugung des ComparisonDataModels -> später durch InputReader
        ComparisonDataModel comparisonDataModel = new ComparisonDataModel();
        comparisonDataModel.getContributions().put(contribution1.getContributionId(), contribution1);
        comparisonDataModel.getContributions().put(contribution2.getContributionId(), contribution2);
        comparisonDataModel.getContributions().put(contribution3.getContributionId(), contribution3);

        // 4) EntityUnderComparison erzeugen z.B. "mass" oder "temp_setpoint1"
        EntityUnderComparison entityUnderComparison = new EntityUnderComparison();
        entityUnderComparison.setEntityId("mass"); // kommt aus UI? automatisch generiert?
        entityUnderComparison.getDataIdentifiers().put("1", dataIdentifier); // sollte ggf nur einen dataIdentifier pro EntityUnderComparison?
        comparisonDataModel.getEntities().put("mass", entityUnderComparison); // EntityUnderComparison ins comparsionDatamodel einfügen

        // 5) Input Reader starten
        // mit dataIdentifier aus den EntityUnderComparison imComparisonDataModel, die entsprechenden Werte aus dem DCC einlesen
        // EntityUnderComparison -> ContributionEntityData -> Hashmap<SiReal> {"1": SiReal, "2": SiReal, "3": SiReal}
        ContributionEntityData contributionEntityData1 = new ContributionEntityData();
        contributionEntityData1.getContributionData().put(contribution1.getContributionId(), new SiReal(1.000000271, new SiExpandedUnc(1.0E-7, 2)));

        ContributionEntityData contributionEntityData2 = new ContributionEntityData();
        contributionEntityData2.getContributionData().put(contribution2.getContributionId(), new SiReal(1.000000249, new SiExpandedUnc(5.7E-8, 2)));

        ContributionEntityData contributionEntityData3 = new ContributionEntityData();
        contributionEntityData3.getContributionData().put(contribution3.getContributionId(), new SiReal(1.000000424, new SiExpandedUnc(4.6E-8, 2)));

        comparisonDataModel.getEntities().get("mass").getEntityData().put(contribution1.getContributionId(), contributionEntityData1);
        comparisonDataModel.getEntities().get("mass").getEntityData().put(contribution2.getContributionId(), contributionEntityData2);
        comparisonDataModel.getEntities().get("mass").getEntityData().put(contribution3.getContributionId(), contributionEntityData3);


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
                AnalysisOutput analysisOutput = new AnalysisOutput();
                if (currentOutlierLength > 0) {
                    analysisOutput.setOutliers(entity.getAnalysisOutputs().get((entity.getAnalysisOutputs().size())-1).getOutliers());
                }
                // Outlier aus Contribution aussortieren -> neue Liste ohne Outlier
                List<String> outliers = analysisOutput.getOutliers();
                HashMap<String, ContributionEntityData> contributionEntityData = entity.getEntityData();
                List<ParticipantMeasuredValue> contributingData = new ArrayList<>();
                for (String id : contributionEntityData.keySet()) {
                    if (!outliers.contains(id)) {
                        contributingData.add(new ParticipantMeasuredValue(contributionEntityData.get(id).getContributionData().get(id)));
                    }
                }

                // weigehted mean berechnen
                WeightedMeanCalculationService weightedMeanCalculationService = new WeightedMeanCalculationService();
                ReferenceValue referenceValue = weightedMeanCalculationService.calculateReferenceValue(contributingData);
                analysisOutput.setRefValue(referenceValue);

                // En werte berechnen
                HashMap<String, SiReal> contributionMeasuredValues = new HashMap<>();
                for (String contributionId : comparisonDataModel.getContributions().keySet()){
                    contributionMeasuredValues.put(contributionId, entity.getEntityData().get(contributionId).getContributionData().get(contributionId));
                }
                StandardEnValueCalculationService enValueCalculationService = new StandardEnValueCalculationService();
                HashMap<String, EnValue> enValues = enValueCalculationService.calculateEnValue(contributionMeasuredValues, referenceValue, analysisOutput.getOutliers());
                analysisOutput.setEnValues(enValues);

                // ConsistencyCheck
                EnCriterionConsistencyCheckService consistencyCheckService = new EnCriterionConsistencyCheckService();
//                consistencyCheckService.evaluateConsistency(analysisOutput);

                // Entscheidung, ob geflaggte Contributions als Outlier aufgenommen werden sollen
                DecisionProcessingService decisionProcessingService = new DecisionProcessingService();
//                decisionProcessingService.processDecision(analysisOutput, true);

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

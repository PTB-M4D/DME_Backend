package de.ptb.dsi.dme_backend.service.domain;

import de.ptb.dsi.dme_backend.model.ComparisonDataModel;

public class VirtualMassComparisonService implements IComparisonEvaluationService {
    private ComparisonDataModel comparisonDataModel;
    @Override
    public String evaluateComparison(String inputJson) {

        // 1) Daten einlesen
        // List<ParticipantMeasuredValue> {"1": SiReal, "2": SiReal, "3": SiReal}

        // weigehted mean und en werte ohne outlier berechnen

        // List<String> Outlier : Id vom participantMeasuredResult | Anfang leer und wird daufgefüllt nach jedem durchgang
        // 2.0) Neue List<ParticipantMeasuredValue> ohne Outlier -> neuer Service?
        // 2.1) weighted Mean berechnen | calculateReferenceValue(List<ParticipantMeasuredValue> participantMeasuredValueValue)
        // 3) Enwerte berechenen | calculateEnValue(HashMap<String, SiReal> contributionMeasuredValues, ReferenceValue referenceValue, List<String> outlierContributions)
        // 4) Consistency check | List<ConsistencyCheckResult> |(En >1 -> Outlier) -> z.B. Id "2", "3" hat EnWert >1 -> Outlier Liste und neu Referenzwert
        // 5) Outlier aussortieren -> OutlierExclusionService -> List<String> outlierContributions

        // Output Report genereieren


        return null;
    }
}

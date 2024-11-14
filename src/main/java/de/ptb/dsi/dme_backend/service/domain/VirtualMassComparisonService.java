package de.ptb.dsi.dme_backend.service.domain;

import de.ptb.dsi.dme_backend.model.ComparisonDataModel;

public class VirtualMassComparisonService implements IComparisonEvaluationService {
    private ComparisonDataModel comparisonDataModel;
    @Override
    public String evaluateComparison(String inputJson) {

        // Daten einlesen
        // Dataidentifier festlegen -> Werte im DCC finden, refType basic measured value (später über UI)
        // Input Reader starten
        // EntityUnderComparison -> ContributionEntityData ->Hashmap<SiReal> {"1": SiReal, "2": SiReal, "3": SiReal}

        // AnalysisOutput in EntityUnderComparison erzeugen
        // Schleife
            // Outlier aus Contribution aussortieren -> neue Liste ohne Outlier
            // weigehted mean
            // en werte berechnen
            // ConsistencyCheck
            // descisonProcess (automatic)^-> ggf Outlier auffüllen un falls Anzahl geändert nochmal Schleife mit neuen AnalysisOutput

        //----- bis hier coden

        // Output report erzeugen
        // API antwort als JSON bzw base64



        return null;
    }
}

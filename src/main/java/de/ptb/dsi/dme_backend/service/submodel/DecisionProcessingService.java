package de.ptb.dsi.dme_backend.service.submodel;


import de.ptb.dsi.dme_backend.model.AnalysisOutput;
import de.ptb.dsi.dme_backend.model.EnValue;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class DecisionProcessingService {
    public void processDecision(AnalysisOutput analysisOutput, boolean automatic){
//        -	Alice defines, if the decision processing is manual (she provides the ID of a participant to be removed) or if it should be processed automatically based in the latest ConsistencyCheckResult
//        -	If an outlier is removed, the ID of the outlier is written to AnalysisOutput.
//        -	If a participant is defined as outlier, a new AnalysisOutput is added to ComparisonDataModel and the outlier is removed from the list ParticipantMeasuredValuesContributing and put to list ParticipantMeasuredValuesOutliers

        if (automatic){

            if (!analysisOutput.getCheckResult().isConsistent()) {
                String method = analysisOutput.getCheckResult().getMethodType();

                //Automatische En Wert Entscheidung: id auf Outlier Liste im AnalysisOutput setzen
                if (method.equals("En Value Criterion")) {
                    String id = analysisOutput.getCheckResult().getNonConsistentContribution();
                    analysisOutput.getOutliers().add(id);
                }
            }
        }
    }

}

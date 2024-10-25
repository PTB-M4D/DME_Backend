package de.ptb.dsi.dme_backend.service.submodel;


import de.ptb.dsi.dme_backend.model.AnalysisOutput;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DecisionProcessingService {
    public boolean processDecision(List<AnalysisOutput> analysisOutputs){
//        -	Alice defines, if the decision processing is manual (she provides the ID of a participant to be removed) or if it should be processed automatically based in the latest ConsistencyCheckResult
//        -	If an outlier is removed, the ID of the outlier is written to AnalysisOutput.
//        -	If a participant is defined as outlier, a new AnalysisOutput is added to ComparisonDataModel and the outlier is removed from the list ParticipantMeasuredValuesContributing and put to list ParticipantMeasuredValuesOutliers
     return true;
    }
}

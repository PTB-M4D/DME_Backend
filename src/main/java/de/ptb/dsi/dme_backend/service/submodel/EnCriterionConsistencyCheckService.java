package de.ptb.dsi.dme_backend.service.submodel;

import de.ptb.dsi.dme_backend.model.AnalysisOutput;
import de.ptb.dsi.dme_backend.model.BilateralEnValue;
import de.ptb.dsi.dme_backend.model.ConsistencyCheckResult;
import de.ptb.dsi.dme_backend.model.EnValue;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class EnCriterionConsistencyCheckService implements IConsistencyCheckService {

    @Override
    public void evaluateConsistency(AnalysisOutput analysisOutput) {
        String methodType = "EnCriterion";
        Double highestInconsistentValue = 1.0;
        String idOfNonConsistentContribution = null;

        HashMap<String, EnValue> enValues = analysisOutput.getEnValues();

//        HashMap<String, HashMap<String,BilateralEnValue>> bilateralEnValues = analysisOutput.getBilateralEnValues();

        //Standard En-Values
        for(String key : enValues.keySet()){
            if (!analysisOutput.getOutliers().contains(key)) {
                Double currentValue = enValues.get(key).getEnValueRaw().getValue();
                if (currentValue > highestInconsistentValue) {
                    highestInconsistentValue = currentValue;
                    idOfNonConsistentContribution = key;
                }
            }
        }

        //Bilateral En-Values
        /*for(String keyOuter : bilateralEnValues.keySet()){
            for(String keyInner : bilateralEnValues.get(keyOuter).keySet()){
                Double currentValue = bilateralEnValues.get(keyOuter).get(keyInner).getEnValue().getEnValueRaw().getValue();
                if(currentValue > highestInconsistentValue){
                    highestInconsistentValue = currentValue;
                    idOfNonConsistentContribution = keyOuter;
                }
            }
        }*/

        analysisOutput.setCheckResult(new ConsistencyCheckResult(methodType, highestInconsistentValue <= 1.0, idOfNonConsistentContribution));
    }

}

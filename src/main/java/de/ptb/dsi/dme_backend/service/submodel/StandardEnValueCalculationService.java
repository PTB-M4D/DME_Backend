package de.ptb.dsi.dme_backend.service.submodel;


import de.ptb.dsi.dme_backend.model.BilateralEnValue;
import de.ptb.dsi.dme_backend.model.EnValue;
import de.ptb.dsi.dme_backend.model.ReferenceValue;
import de.ptb.dsi.dme_backend.model.SiReal;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.lang.Math;

@Service
public class StandardEnValueCalculationService implements IEnValueCalculationService {

    @Override
    public HashMap<String, EnValue> calculateEnValue(HashMap<String, SiReal> contributionMeasuredValues, ReferenceValue referenceValue, List<String> outlierContributions) {
        //create Hashmap for output
        HashMap<String, EnValue> EnValues = new HashMap<>();

        //loop through list of contributionMeasuredValues and calculate correlated/uncorrelated EnValue
        for (String key : contributionMeasuredValues.keySet()) {
            SiReal value = contributionMeasuredValues.get(key);
            EnValue enValue;

            //if Outlier use uncorrelated EnValue, otherwise use correlated enValue
            if(outlierContributions.contains(key)) {
                 enValue = calculateUncorrelatedEnValue(value, referenceValue);
            } else {
                enValue = calculateCorrelatedEnValue(value, referenceValue);
            }
            EnValues.put(key, enValue);
        }
        return EnValues;
    }

    public EnValue calculateCorrelatedEnValue(SiReal value, ReferenceValue refValue) {
        double x = value.getValue();
        double u_x = value.getExpUnc().getUncertainty();
        double xRef = refValue.getSiReal().getValue();
        double u_xRef = refValue.getSiReal().getExpUnc().getUncertainty();
        //TODO check if converage is 95 %

        double En = Math.abs((x - xRef) / Math.sqrt(u_x*u_x - u_xRef*u_xRef));

        return new EnValue(new SiReal(En), "correlated EnValue");
    }

    public EnValue calculateUncorrelatedEnValue(SiReal value, ReferenceValue refValue) {
        double x = value.getValue();
        double u_x = value.getExpUnc().getUncertainty();
        double xRef = refValue.getSiReal().getValue();
        double u_xRef = refValue.getSiReal().getExpUnc().getUncertainty();
        //TODO check if converage is 95 %

        double En = Math.abs((x - xRef) / Math.sqrt(u_x*u_x + u_xRef*u_xRef));

        return new EnValue(new SiReal(En), "uncorrelated EnValue");
    }

    public void checkForNullSiReal(SiReal siReal){
        if(siReal.getValue() == null){
            throw new NullPointerException("Value in SiReal cannot be null.");
        }
    }
    public void checkForNullInSiExpUnc(SiReal siReal){
        if(siReal.getExpUnc().getUncertainty() == null){
            throw new NullPointerException("Uncertainty in ExpUnc cannot be null.");
        }
    }

}

package de.ptb.dsi.dme_backend.service.submodel;


import de.ptb.dsi.dme_backend.model.BilateralEnValue;
import de.ptb.dsi.dme_backend.model.Contribution;
import de.ptb.dsi.dme_backend.model.EnValue;
import de.ptb.dsi.dme_backend.model.SiReal;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class StandardBilateralEnValueCalculationService implements IBilateralEnCalculationService {


    public HashMap<String, HashMap<String, BilateralEnValue>> calculateBilateralEnValues(HashMap<String, SiReal> contributionMeasuredValues,
                                                                                         HashMap<String, Contribution> contributions) {

        //Check whether both arrays have an equal amount of entries
        if(contributionMeasuredValues.size() != contributions.size()){
            throw new IllegalArgumentException("Encountered a different number of contributionMeasuredValues and contributions.");
        }
        //Check if required fields are empty
        checkForNullInContributionMeasuredValues(contributionMeasuredValues);
        checkForNullInContributions(contributions);
        checkForNullInSiExpUnc(contributionMeasuredValues);

        // Keys for contributions und contributionMeasuredValues should be identical
        ArrayList<String> keyList = new ArrayList<>(contributions.keySet());

        HashMap<String, HashMap<String, BilateralEnValue>> bilateralEnValueMatrix = new HashMap<>();
        for (int i = 0; i < keyList.size(); i++) {
            HashMap<String, BilateralEnValue> bilateralEnValues = new HashMap<>();
            for (int j = 0 ; j < keyList.size(); j++) {
                //Expanded uncertainty (95 %) are needed for bilateral En values
                double xi = contributionMeasuredValues.get(keyList.get(i)).getValue();
                double xj = contributionMeasuredValues.get(keyList.get(j)).getValue();
                double ui = contributionMeasuredValues.get(keyList.get(i)).getExpUnc().getUncertainty();
                double uj = contributionMeasuredValues.get(keyList.get(j)).getExpUnc().getUncertainty();

                double enValueDouble = Math.abs(xi - xj) / Math.sqrt(ui * ui + uj * uj);

                // format Data into SiReal -> EnValue -> BilateralEnValue -> HashMap<String, BilateralEnValue>
                SiReal enValueSiReal = new SiReal(enValueDouble);
                EnValue enValue = new EnValue(enValueSiReal, "bilateral EnValue");
                BilateralEnValue bilateralEnValue = new BilateralEnValue(
                        "bilateral En value calculation",
                        enValue,
                        "bilateral En Value",
                        contributions.get(keyList.get(i)).getContributionId(),
                        contributions.get(keyList.get(j)).getContributionId());

                // add to inner Hashmap
                String key = Integer.toString(j);
                bilateralEnValues.put(key, bilateralEnValue);
            }
            // add to outer Hashmap
            bilateralEnValueMatrix.put(Integer.toString(i), bilateralEnValues);
        }
        return bilateralEnValueMatrix;
    }

    public void checkForNullInContributionMeasuredValues(HashMap<String, SiReal> contributionMeasuredValues){
        for (SiReal siReal : contributionMeasuredValues.values()) {
            if(siReal.getValue() == null){
                throw new NullPointerException("Value in SiReal cannot be null.");
            }
        }
    }
    public void checkForNullInSiExpUnc(HashMap<String, SiReal> contributionMeasuredValues){
        for (SiReal siReal : contributionMeasuredValues.values()) {
            if(siReal.getExpUnc().getUncertainty() == null){
                throw new NullPointerException("Uncertainty in ExpUnc cannot be null.");
            }
        }
    }


    public void checkForNullInContributions(HashMap<String, Contribution> contributions){
        for (Contribution contribution : contributions.values()) {
            if(contribution.getContributionId() == null){
                throw new NullPointerException("ContributionId in contribution cannot be null.");
            }
        }
    }


}
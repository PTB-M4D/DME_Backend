package de.ptb.dsi.dme_backend.service.submodel;

import de.ptb.dsi.dme_backend.model.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class StandardBilateralDeviationCalculationService implements IBilateralDeviationCalculationService {

    @Override
    public HashMap<String, HashMap<String, SiReal>> calculateBilateralDeviations(HashMap<String, SiReal> contributionMeasuredValues,
                                                                                         HashMap<String, Contribution> contributions) {

        // Keys for contributions und contributionMeasuredValues should be identical
        ArrayList<String> keyList = new ArrayList<>(contributions.keySet());

        HashMap<String, HashMap<String, SiReal>> bilateralDeviationsMatrix = new HashMap<>();
        for (int i = 0; i < keyList.size(); i++) {
            HashMap<String, SiReal> bilateralDeviations = new HashMap<>();
            for (int j = 0 ; j < keyList.size(); j++) {

                //Expanded uncertainty (95 %) are used for calculating the uncertainty of the deviation
                double xi = contributionMeasuredValues.get(keyList.get(i)).getValue();
                double xj = contributionMeasuredValues.get(keyList.get(j)).getValue();
                double ui = contributionMeasuredValues.get(keyList.get(i)).getExpandedMU().getValueExpandedMU();
                double uj = contributionMeasuredValues.get(keyList.get(j)).getExpandedMU().getValueExpandedMU();

                double deviationDouble = xi - xj;
                double deviationUncertaintyDouble = Math.sqrt(ui*ui + uj*uj);

                // format Data into SiReal  -> HashMap<String, SiReal>
                String label = "Difference:" + keyList.get(i) + " - " + keyList.get(j);
                String unit = contributionMeasuredValues.get(keyList.get(i)).getUnit();
                SiExpandedMU deviationUncertainty = SiExpandedMU.builder()
                        .valueExpandedMU(deviationUncertaintyDouble)
                        .coverageFactor(2)
                        .build();

                SiReal deviationSiReal = new SiReal(label,deviationDouble, unit, deviationUncertainty);

                // add to inner Hashmap
                bilateralDeviations.put(keyList.get(j), deviationSiReal);
            }
            // add to outer Hashmap
            bilateralDeviationsMatrix.put(keyList.get(i), bilateralDeviations);
        }
        return bilateralDeviationsMatrix;
    }

}

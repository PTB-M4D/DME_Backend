package de.ptb.dsi.dme_backend.service.submodel;

import de.ptb.dsi.dme_backend.model.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@AllArgsConstructor
@Service
public class StandardDeviationToReferenceCalculationService implements IDeviationToReferenceCalculationService {

    private final StandardDifferenceCalculatorService differenceCalculatorService;

    @Override
    public HashMap<String, SiReal> calculateDeviationsToReference(HashMap<String, SiReal> contributionMeasuredValues,
                                                           ReferenceValue referenceValue) {

        ArrayList<String> keyList = new ArrayList<>(contributionMeasuredValues.keySet());
        HashMap<String, SiReal> deviationsToReference = new HashMap<>();
        for (int i = 0; i < keyList.size(); i++) {

            String label = "Difference: Reference - " + keyList.get(i);
            SiReal deviationToReferenceSiReal = differenceCalculatorService.calculateDifference(
                    referenceValue.getSiReal(),
                    contributionMeasuredValues.get(keyList.get(i)),
                    label);

//            //Expanded uncertainty (95 %) are used to calculate the uncertainty of the difference value
//            double xi = contributionMeasuredValues.get(keyList.get(i)).getValue();
//            double ui = contributionMeasuredValues.get(keyList.get(i)).getExpandedMU().getValueExpandedMU();
//
//            double ref = referenceValue.getValue();
//            double uRef = referenceValue.getExpandedMU().getValueExpandedMU();
//
//            double deviationToReference = ref - xi;
//            double uncertaintyDeviationToReference = Math.sqrt(ui*ui + uRef*uRef);
//
//            // format Data into SiReal -> -> HashMap<String, SiReal>
//            String label = "Difference: Reference - " + keyList.get(i) ;
//            String unit = referenceValue.getUnit();
//            SiExpandedMU deviationUncertainty = SiExpandedMU.builder()
//                    .valueExpandedMU(uncertaintyDeviationToReference)
//                    .coverageFactor(2)
//                    .build();
//
//            SiReal deviationToReferenceSiReal = new SiReal(label,deviationToReference, unit, deviationUncertainty);

            // add to inner Hashmap
            deviationsToReference.put(keyList.get(i), deviationToReferenceSiReal);
        }
        return deviationsToReference;

    }
}

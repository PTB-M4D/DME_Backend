package de.ptb.dsi.dme_backend.service.submodel;


import de.ptb.dsi.dme_backend.model.ParticipantMeasuredValue;
import de.ptb.dsi.dme_backend.model.ReferenceValue;
import de.ptb.dsi.dme_backend.model.SiExpandedUnc;
import de.ptb.dsi.dme_backend.model.SiReal;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class WeightedMeanCalculationService implements IReferenceValueCalculationService {

    //TODO: Coverage factor?
    @Override
    public ReferenceValue calculateReferenceValue(List<ParticipantMeasuredValue> participantMeasuredValueValue) {
        //Calculate reference value and uncertainty
        double referenceUncertainty = 0, referenceValue = 0, sumWeightedValues = 0, sumWeights = 0;

        for (ParticipantMeasuredValue measurement : participantMeasuredValueValue) {
            //Potentiate standard uncertainty for further use
            Double currentPotentiatedStandardUncertainty = Math.pow(measurement.getSiReal().getExpUnc().getUncertainty(), 2);

            //Calculate weighted values and weights
            sumWeightedValues += measurement.getSiReal().getValue() / currentPotentiatedStandardUncertainty;
            sumWeights += 1 / currentPotentiatedStandardUncertainty;
        }

        //Calculate uncertainty reference and, using that, the reference value
        referenceUncertainty = 1 / sumWeights;
        referenceValue = sumWeightedValues * referenceUncertainty;

        //Create necessary siReal instance and return in a new ReferenceValue instance
        SiReal siReal = new SiReal(referenceValue, new SiExpandedUnc(referenceUncertainty, 2));
        return new ReferenceValue(siReal);
    }
}

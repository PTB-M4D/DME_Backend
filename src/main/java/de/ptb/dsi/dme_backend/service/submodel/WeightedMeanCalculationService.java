package de.ptb.dsi.dme_backend.service.submodel;


import de.ptb.dsi.dme_backend.model.ParticipantMeasuredValue;
import de.ptb.dsi.dme_backend.model.ReferenceValue;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class WeightedMeanCalculationService implements IReferenceValueCalculationService {

    @Override
    public ReferenceValue calculateReferenceValue(List<ParticipantMeasuredValue> participantMeasuredValueValue) {
        return null;
    }
}

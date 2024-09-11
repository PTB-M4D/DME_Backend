package de.ptb.dsi.dme_backend.service;


import de.ptb.dsi.dme_backend.model.ParticipantMeasuredValue;
import de.ptb.dsi.dme_backend.model.ReferenceValue;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class WeightedMeanCalculationService implements ReferenceValueCalculationService{

    @Override
    public ReferenceValue calculateReferenceValue(List<ParticipantMeasuredValue> participantMeasuredValueValue) {
        return null;
    }
}

package de.ptb.dsi.dme_backend.service.submodel;


import de.ptb.dsi.dme_backend.model.ParticipantMeasuredValue;
import de.ptb.dsi.dme_backend.model.ReferenceValue;

import java.util.List;

public interface IReferenceValueCalculationService {
    ReferenceValue calculateReferenceValue(List<ParticipantMeasuredValue> participantMeasuredValueValue);
}

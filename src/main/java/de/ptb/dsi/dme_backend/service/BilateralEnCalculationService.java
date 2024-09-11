package de.ptb.dsi.dme_backend.service;

import de.ptb.dsi.dme_backend.model.ParticipantMeasuredValue;

import java.util.List;
import java.util.Map;

public interface BilateralEnCalculationService {
    Map<String, Double> calculateBilateralEnValues(List<ParticipantMeasuredValue> listParticipantMeasuredValue);

}

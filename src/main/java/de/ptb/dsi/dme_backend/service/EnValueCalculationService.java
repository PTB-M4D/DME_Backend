package de.ptb.dsi.dme_backend.service;


import de.ptb.dsi.dme_backend.model.EnValue;
import de.ptb.dsi.dme_backend.model.ParticipantMeasuredValue;
import de.ptb.dsi.dme_backend.model.ReferenceValue;

import java.util.List;

public interface EnValueCalculationService {
//    -	Calculates all En-values for given lists of participantMeasuredValues contributing and outliers as well as a given ReferenceValue and writes it to AnalysisOutput
    List<EnValue> calculateEnValue(List<ParticipantMeasuredValue> participantMeasuredValues, ReferenceValue referenceValue);

//coreliert und uncorreliert
}

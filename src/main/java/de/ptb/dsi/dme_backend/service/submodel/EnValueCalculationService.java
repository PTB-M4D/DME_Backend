package de.ptb.dsi.dme_backend.service.submodel;


import de.ptb.dsi.dme_backend.model.EnValue;
import de.ptb.dsi.dme_backend.model.ParticipantMeasuredValue;
import de.ptb.dsi.dme_backend.model.ReferenceValue;
import de.ptb.dsi.dme_backend.model.SiReal;

import java.util.HashMap;
import java.util.List;

public interface EnValueCalculationService {
//    -	Calculates all En-values for given lists of participantMeasuredValues contributing and outliers as well as a given ReferenceValue and writes it to AnalysisOutput
   HashMap<String,EnValue> calculateEnValue(HashMap<String, SiReal> contributionMeasuredValues, ReferenceValue referenceValue, List<String> outlierContributions);

//coreliert und uncorreliert
}

package de.ptb.dsi.dme_backend.service.submodel;

import de.ptb.dsi.dme_backend.model.BilateralEnValue;
import de.ptb.dsi.dme_backend.model.ParticipantMeasuredValue;
import de.ptb.dsi.dme_backend.model.SiReal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface BilateralEnCalculationService {
   public HashMap<String, HashMap<String, BilateralEnValue>> calculateBilateralEnValues(HashMap<String, SiReal> contributionMeasuredValues);

}

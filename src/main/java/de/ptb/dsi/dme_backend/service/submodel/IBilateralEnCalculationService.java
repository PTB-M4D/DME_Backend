package de.ptb.dsi.dme_backend.service.submodel;

import de.ptb.dsi.dme_backend.model.BilateralEnValue;
import de.ptb.dsi.dme_backend.model.SiReal;

import java.util.HashMap;

public interface IBilateralEnCalculationService {
    HashMap<String, HashMap<String, BilateralEnValue>> calculateBilateralEnValues(HashMap<String, SiReal> contributionMeasuredValues);

}

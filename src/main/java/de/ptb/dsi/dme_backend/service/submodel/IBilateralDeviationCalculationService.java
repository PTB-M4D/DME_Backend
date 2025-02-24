package de.ptb.dsi.dme_backend.service.submodel;

import de.ptb.dsi.dme_backend.model.BilateralEnValue;
import de.ptb.dsi.dme_backend.model.Contribution;
import de.ptb.dsi.dme_backend.model.SiReal;

import java.util.HashMap;

public interface IBilateralDeviationCalculationService {
    HashMap<String, HashMap<String, SiReal>> calculateBilateralDeviations(HashMap<String, SiReal> contributionMeasuredValues,
                                                                                         HashMap<String, Contribution> contributions);
}

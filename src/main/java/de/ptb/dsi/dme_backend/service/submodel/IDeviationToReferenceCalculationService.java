package de.ptb.dsi.dme_backend.service.submodel;

import de.ptb.dsi.dme_backend.model.Contribution;
import de.ptb.dsi.dme_backend.model.ReferenceValue;
import de.ptb.dsi.dme_backend.model.SiReal;

import java.util.HashMap;

public interface IDeviationToReferenceCalculationService {

    HashMap<String, SiReal> calculateDeviationsToReference(HashMap<String, SiReal> contributionMeasuredValues,
                                                           ReferenceValue referenceValue);
}

package de.ptb.dsi.dme_backend.service.submodel;

import de.ptb.dsi.dme_backend.model.SiReal;

public interface IDifferenceCalculatorService {

    SiReal calculateDifference(SiReal siReal1, SiReal siReal2, String label);

}

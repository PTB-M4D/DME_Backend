package de.ptb.dsi.dme_backend.service.input;

import de.ptb.dsi.dme_backend.model.ComparisonDataModel;
import de.ptb.dsi.dme_backend.model.SiReal;
import java.util.HashMap;


public interface IInputReaderService {
    void loadData(ComparisonDataModel comparisonDataModel);
}

package de.ptb.dsi.dme_backend.service.submodel;


import de.ptb.dsi.dme_backend.model.EnValue;
import de.ptb.dsi.dme_backend.model.ReferenceValue;
import de.ptb.dsi.dme_backend.model.SiReal;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;

@Service
public class StandardEnValueCalculationService implements IEnValueCalculationService {

    @Override
    public HashMap<String, EnValue> calculateEnValue(HashMap<String, SiReal> contributionMeasuredValues, ReferenceValue referenceValue, List<String> outlierContributions) {
        return null;
    }
}

package de.ptb.dsi.dme_backend.service.submodel;

import de.ptb.dsi.dme_backend.model.AnalysisOutput;
import de.ptb.dsi.dme_backend.model.ConsistencyCheckResult;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnCriterionConsistencyCheckService implements IConsistencyCheckService {

    @Override
    public void evaluateConsistency(AnalysisOutput analysisOutput) {
        // 1) Alle En Value > 1 testen
        // wenn En Value > 1 existiert: größten En Value suchen und ConsistencyCheckResult in analysisOutput setzen
    }

}

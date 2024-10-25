package de.ptb.dsi.dme_backend.service.submodel;

import de.ptb.dsi.dme_backend.model.ConsistencyCheckResult;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnCriterionConsistencyCheckService implements ConsistencyCheckService{

    @Override
    public List<ConsistencyCheckResult> inconsistentParticipantList() {
        return null;
    }

    @Override
    public boolean isConsistent() {
        return false;
    }
}

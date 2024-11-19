package de.ptb.dsi.dme_backend.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Data
public class EntityUnderComparison {
    String entityId; // z.B. "mass" z.B temperatur
    HashMap<String,DataIdentifier> dataIdentifiers ; // sollte nur 1 dataIdentifier sein?
    HashMap<String, ContributionEntityData> entityData;// key dataIdentifierId -> evtl unnötig? key=contributionid?
    List<AnalysisOutput> analysisOutputs;

    public EntityUnderComparison() {
        dataIdentifiers = new HashMap<>();
        entityData = new HashMap<>();
        analysisOutputs = new ArrayList<>();
    }
}

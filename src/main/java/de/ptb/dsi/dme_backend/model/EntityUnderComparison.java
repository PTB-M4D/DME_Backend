package de.ptb.dsi.dme_backend.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Data
public class EntityUnderComparison {
    String entityId; // z.B temperatur
    HashMap<String,DataIdentifier> dataIdentifiers ; // key dataIdentifierId | z.B. "1" -> "basic_measuredValue", "2" -> "basic_measuredValueSensor1"
    HashMap<String, ContributionEntityData> entityData;// key dataIdentifierId | "1" -> basic_measuredvalue von allen Contributions
    List<AnalysisOutput> analysisOutputs;

    public EntityUnderComparison() {
        dataIdentifiers = new HashMap<>();
        entityData = new HashMap<>();
        analysisOutputs = new ArrayList<>();
    }
}

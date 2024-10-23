package de.ptb.dsi.dme_backend.model;

import java.util.HashMap;
import java.util.List;

public class EntityUnderComparison {
    String entityId;
    HashMap<String,DataIdentifier> dataIdentifiers;
    HashMap<String, ContributionEntityData> entityData;// key dataIdentifierId
    List<AnalysisOutput> analysisOutputs;
}

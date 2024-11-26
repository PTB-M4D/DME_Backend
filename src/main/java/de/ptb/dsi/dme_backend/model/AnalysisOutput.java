package de.ptb.dsi.dme_backend.model;

import lombok.Data;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Data
public class AnalysisOutput {
    private ReferenceValue refValue;
    private HashMap<String,EnValue> enValues;//key ContributionId
    private HashMap<String,HashMap<String,BilateralEnValue>> bilateralEnValues;//keys ContributionIds
    private ConsistencyCheckResult checkResult;
    private List<String> outliers;//contributionIds

    public AnalysisOutput(){
        this.enValues = new HashMap<>();
        this. bilateralEnValues = new HashMap<String,HashMap<String,BilateralEnValue>>();
        this.outliers = new ArrayList<>();
    }
}

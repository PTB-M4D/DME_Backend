package de.ptb.dsi.dme_backend.model;

import lombok.Data;
import org.eclipse.jetty.util.component.HaltLifeCycleListener;

import java.util.HashMap;

@Data
public class AnalysisOutput {
    private ReferenceValue refValue;
    private HashMap<String,EnValue> enValues;//key ContributionId
}

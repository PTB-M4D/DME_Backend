package de.ptb.dsi.dme_backend.model.dcc;

import lombok.Data;

@Data
public class ExpandedUnc {
    private double uncertainty;
    private int coverageFactor;
    private double coverageProbability;
}

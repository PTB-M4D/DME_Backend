package de.ptb.dsi.dme_backend.model.dcc;

import lombok.Data;

@Data
public class InfluenceConditionQuantitySiReal {
    private double value;
    private String unit;
    private ExpandedUnc expandedUnc;
}

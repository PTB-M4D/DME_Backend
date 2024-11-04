package de.ptb.dsi.dme_backend.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SiExpandedUnc {
    Double uncertainty;
    int coverageFactor;
    Double coverageProbability;
    String distribution;

    public SiExpandedUnc(Double uncertainty, int coverageFactor){
        this.uncertainty = uncertainty;
        this.coverageFactor = coverageFactor;
    }
}

package de.ptb.dsi.dme_backend.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SiExpandedMU {
    Double valueExpandedMU;
    int coverageFactor;
    Double coverageProbability;
    String distribution;

    public SiExpandedMU(Double uncertainty, int coverageFactor){
        this.valueExpandedMU = uncertainty;
        this.coverageFactor = coverageFactor;
    }
}

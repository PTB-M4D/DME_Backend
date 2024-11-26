package de.ptb.dsi.dme_backend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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

package de.ptb.dsi.dme_backend.model;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SiReal {
    static long instanceCounter=0;
    Long id;
    String name;
    Double value;
    String unit;
    String dateTime;
    SiExpandedUnc expUnc;
    //Double expUnc;

    public SiReal(Double value) {
        this.value = value;
    }

    public SiReal(Double value, SiExpandedUnc expUnc) {
        this.value = value;
        this.expUnc = expUnc;
    }
}

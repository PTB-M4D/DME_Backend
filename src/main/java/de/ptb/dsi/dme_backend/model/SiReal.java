package de.ptb.dsi.dme_backend.model;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor

public class SiReal {
    Long id;
    String name;
    Double value;
    String unit;
    String dateTime;
    SiExpandedUnc expUnc;

    public SiReal(Double value) {
        this.value = value;
    }

    public SiReal(Double value, SiExpandedUnc expUnc) {
        this.value = value;
        this.expUnc = expUnc;
    }
}

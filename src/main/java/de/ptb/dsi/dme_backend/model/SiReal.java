package de.ptb.dsi.dme_backend.model;



import lombok.*;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class SiReal {
    Long id;
    String label;
    Double value;
    String unit;
    Integer significantDigit;
    String dateTime;
    SiExpandedMU expandedMU;

    public SiReal(Double value) {
        this.value = value;
    }

    public SiReal(Double value, SiExpandedMU expUnc) {
        this.value = value;
        this.expandedMU = expUnc;
    }
}

package de.ptb.dsi.dme_backend.model;



import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
// 1. Basic measured quantity
//         (o) - element label             (string)
//         (o) - element quantityTypeQUDT  (qudt:quantitykind Type)
//         (m) - element value             (decimal value type)
//         (m) - element unit              (string - SI format)
//         (o) - element significantDigit  (integer)
//         (o) - element dateTime          (xs:dateTime)
//
//         2. Measured quantity with univariate measurement uncertainty
//         (o) - element label             (string)
//         (o) - element quantityTypeQUDT  (qudt:quantitykind Type)
//         (m) - element value             (decimal value type)
//         (m) - element unit              (string - SI format)
//         (o) - element significantDigit  (integer)
//         (o) - element dateTime          (xs:dateTime)
//         (m) - element measurementUncertaintyUnivariate (si:measurementUncertaintyUnivaraiteType)
//         # with choice   si:standardMU
//         or si:expandedMU
//         or si:coverageIntervalMU
//         # or [deprecated] si:expandedUnc
//         # or [deprecated] si:coverageInterval

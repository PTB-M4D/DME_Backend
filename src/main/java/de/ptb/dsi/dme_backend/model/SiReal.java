package de.ptb.dsi.dme_backend.model;

import lombok.Data;

@Data
public class SiReal {
    String name;
    Double value;
    String unit;
    String dateTime;
    SiExpandedUnc expUnc;

}

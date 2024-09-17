package de.ptb.dsi.dme_backend.model;


import lombok.Data;

@Data
public class SiReal {
    static long instanceCounter=0;
    Long id;
    String name;
    Double value;
    String unit;
    String dateTime;
    Double expUnc;
//    SiExpandedUnc expUnc;

    public SiReal(){
        instanceCounter++;
        id=instanceCounter;
    }
}

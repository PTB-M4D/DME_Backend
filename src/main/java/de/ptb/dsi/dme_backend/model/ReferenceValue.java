package de.ptb.dsi.dme_backend.model;

import lombok.Data;

@Data
public class ReferenceValue {
    private SiReal siReal;

    public ReferenceValue(){}

    public ReferenceValue(SiReal siReal){
        this.siReal = siReal;
    }
}

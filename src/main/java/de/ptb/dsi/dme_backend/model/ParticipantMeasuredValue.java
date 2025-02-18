package de.ptb.dsi.dme_backend.model;

import lombok.Data;

@Data
public class ParticipantMeasuredValue {
    private SiReal siReal;

    public ParticipantMeasuredValue(){}
    public ParticipantMeasuredValue(SiReal siReal){
        this.siReal = siReal;
    }
}

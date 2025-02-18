package de.ptb.dsi.dme_backend.model;

import lombok.Data;

@Data
public class EnValue {
    private SiReal enValueRaw;
    private SiReal enValueRounded;
    private String method;

    public EnValue(SiReal enValueRaw, String method) {
        this.enValueRaw = enValueRaw;
        this.method = method;
    }
}

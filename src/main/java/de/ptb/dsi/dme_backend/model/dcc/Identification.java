package de.ptb.dsi.dme_backend.model.dcc;

import lombok.Data;

@Data
public class Identification {
    private String issuer;
    private String value;
    private IdentificationName name;
}

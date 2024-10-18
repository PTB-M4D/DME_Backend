package de.ptb.dsi.dme_backend.model.dcc;

import lombok.Data;

@Data
public class Software {
    private IdentificationName name;
    private String release;
}

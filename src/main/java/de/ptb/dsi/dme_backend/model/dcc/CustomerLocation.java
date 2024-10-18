package de.ptb.dsi.dme_backend.model.dcc;

import lombok.Data;

@Data
public class CustomerLocation {
    private String city ;
    private String countryCode;
    private String postCode;
    private String state;
    private String street;
}

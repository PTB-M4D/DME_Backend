package de.ptb.dsi.dme_backend.model.dcc;

import lombok.Data;

@Data
public class Customer {
    private CustomerName name;
    private CustomerLocation location;
}

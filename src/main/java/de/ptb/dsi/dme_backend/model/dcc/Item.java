package de.ptb.dsi.dme_backend.model.dcc;

import lombok.Data;

import java.util.List;
@Data
public class Item {
    private ItemName name;
    private ItemDescription description;
    private Manufacturer manufacturer;
    private List<Identification> identifications;
    private List<ItemQuantity> itemQuantities;
}

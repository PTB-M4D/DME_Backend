package de.ptb.dsi.dme_backend.model;

import lombok.Data;

import java.util.List;
@Data
public class DataIdentifier {
    String id;
    List<String> refIds;
    List<String> refTypes;
    String siLabel;
}

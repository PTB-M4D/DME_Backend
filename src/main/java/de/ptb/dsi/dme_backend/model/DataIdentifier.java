package de.ptb.dsi.dme_backend.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class DataIdentifier {
    String id; // key for inputReader dataIdentifierId
    String refId;
    String refType;
    String siLabel;
    Integer index;


}

package de.ptb.dsi.dme_backend.model;

import lombok.Data;

@Data
public class BilateralEnValue {
    private String methodType;
    private EnValue enValue;
    private String method;
    private String contributionA; //contributionId
    private String contributionB;//contributionId

}

package de.ptb.dsi.dme_backend.model.dcc;

import lombok.Data;

@Data
public class UsedMethod {
    private UsedMethodsName name;
    private UsedMeDescription usedMeDescription;
    private String norm;
}

package de.ptb.dsi.dme_backend.model;

import lombok.Data;

@Data
public class Contribution {
    String contributionId;
    String participant;
    String pidInputData;

    public Contribution(String contributionId){
        this.contributionId = contributionId;
    }
}

package de.ptb.dsi.dme_backend.model;

import lombok.Data;

import java.util.HashMap;
@Data
public class ContributionEntityData {
    HashMap<String, SiReal> contributionData;// key contributionId

    public ContributionEntityData(){
        this.contributionData = new HashMap<>();
    }
}

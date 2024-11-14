package de.ptb.dsi.dme_backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contribution {
    String contributionId;
    String participant;
    String pidInputData;

    public Contribution(String contributionId){
        this.contributionId = contributionId;
    }
}

package de.ptb.dsi.dme_backend.model;

import lombok.Data;

@Data
public class ConsistencyCheckResult {
    private String methodType;
    private boolean isConsistent;
    private String nonConsistentContribution;//    ID of non-consistent contribution
}

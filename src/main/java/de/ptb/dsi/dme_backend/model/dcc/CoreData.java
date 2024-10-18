package de.ptb.dsi.dme_backend.model.dcc;


import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class CoreData {
    private String countryCodeISO3166_1;
    private String usedLangCodeISO639_1;
    private String mandatoryLangCodeISO639_1;
    private List<Identification> identifications;
    private Date beginPerformanceDate;
    private Date endPerformanceDate;
    private String performanceLocation;
    private Date issueDate;
}

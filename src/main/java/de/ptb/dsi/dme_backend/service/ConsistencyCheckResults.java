package de.ptb.dsi.dme_backend.service;

import java.util.List;

public interface ConsistencyCheckResults {
    //    –	When the data is inconsistent, it provides data indicating that it is inconsistent and showing, potential participants that may be marked as outliers
    List<String> inconsistentParticipantList();
    //   –	The service performs consistency check to identify, if the comparison outcomes are consistent or if they are inconsistent.
    boolean isConsistent();
}

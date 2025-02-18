package de.ptb.dsi.dme_backend.service.submodel;

import de.ptb.dsi.dme_backend.model.AnalysisOutput;
import de.ptb.dsi.dme_backend.model.ConsistencyCheckResult;

import java.util.List;

public interface IConsistencyCheckService {
//    –	When the data is inconsistent, it provides data indicating that it is inconsistent and showing, potential participants that may be marked as outliers
    void evaluateConsistency(AnalysisOutput analysisOutput);
//   –	The service performs consistency check to identify, if the comparison outcomes are consistent or if they are inconsistent.
    // -sets one ConsitencyCheckResult in AnalysisOutput

}

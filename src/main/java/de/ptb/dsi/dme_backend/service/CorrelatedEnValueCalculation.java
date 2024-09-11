package de.ptb.dsi.dme_backend.service;



import de.ptb.dsi.dme_backend.model.EnValue;
import de.ptb.dsi.dme_backend.model.ParticipantMeasuredValue;
import de.ptb.dsi.dme_backend.model.ReferenceValue;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CorrelatedEnValueCalculation implements EnValueCalculationService{

//    Responsibilities
//-	Calculates all En-values for given lists of participantMeasuredValues contributing and outliers as well as a given ReferenceValue and writes it to AnalysisOutput

    @Override
    public List<EnValue> calculateEnValue( List<ParticipantMeasuredValue> participantMeasuredValues, ReferenceValue referenceValue) {
        return null;
    }

//    Collaborators
//–	AnalysisOutput (ReferenceValue)
//–	Lists of ParticipantMeasuredValuesContributing (input)
//–	ParticipantMeasuredValuesOutlier (input)
//–	List of EnValues
//–	EnValue
}

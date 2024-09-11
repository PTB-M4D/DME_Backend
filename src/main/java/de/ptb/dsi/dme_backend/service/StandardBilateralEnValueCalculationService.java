package de.ptb.dsi.dme_backend.service;


import de.ptb.dsi.dme_backend.model.ParticipantMeasuredValue;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StandardBilateralEnValueCalculationService implements BilateralEnCalculationService{
    @Override
    public Map<String, Double> calculateBilateralEnValues(List<ParticipantMeasuredValue> listParticipantMeasuredValue) {
        Map<String, Double> enValues = new HashMap<>();

// Berechnung des bilateralen En-Wertes zwischen jedem Paar von Teilnehmern
        for (int i = 0; i < listParticipantMeasuredValue.size(); i++) {
            for (int j = i + 1; j < listParticipantMeasuredValue.size(); j++) {
                ParticipantMeasuredValue participant1 = listParticipantMeasuredValue.get(i);
                ParticipantMeasuredValue participant2 = listParticipantMeasuredValue.get(j);

                double xi = participant1.getSiReal().getValue();
                double xj = participant2.getSiReal().getValue();
                double ui = participant1.getSiReal().getExpUnc().getUncertainty();
                double uj = participant2.getSiReal().getExpUnc().getUncertainty();

                double enValue = Math.abs(xi - xj) / Math.sqrt(ui * ui + uj * uj);

                String key = participant1.getSiReal().getName() + " , " + participant2.getSiReal().getName();
                enValues.put(key, enValue);

            }
        }
        return enValues;
    }
}
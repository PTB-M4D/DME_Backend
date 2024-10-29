package de.ptb.dsi.dme_backend.service;

import de.ptb.dsi.dme_backend.model.ParticipantMeasuredValue;
import de.ptb.dsi.dme_backend.model.ReferenceValue;
import de.ptb.dsi.dme_backend.model.SiReal;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class WeightedMeanCalculationServiceTest {

    //Create participantMeasuredValueList from array lists
    private static List<ParticipantMeasuredValue> getParticipantMeasuredValues(ArrayList<Double> values, ArrayList<Double> uncertainties) {
        List<ParticipantMeasuredValue> participantMeasuredValueList = new ArrayList<ParticipantMeasuredValue>();

        for(int i = 0; i < values.size(); i++){
            participantMeasuredValueList.add(new ParticipantMeasuredValue(new SiReal(values.get(i), uncertainties.get(i))));
        }

        return participantMeasuredValueList;
    }

    //Calculation test
    @Test
    public void testWeightedMeanCalculation(){
        //Create example data
        ArrayList<Double> values = new ArrayList<>(), uncertainties = new ArrayList<>();

        values.add(5.0);
        values.add(20.0);
        values.add(15.0);

        uncertainties.add(30.0);
        uncertainties.add(60.0);
        uncertainties.add(10.0);

        List<ParticipantMeasuredValue> participantMeasuredValueList = getParticipantMeasuredValues(values, uncertainties);

        //Create expected result
        //TODO: Use real test data
        ReferenceValue expectedResult = new ReferenceValue(new SiReal(0.0, 0.0 *2));

        //Create instance and run function
        WeightedMeanCalculationService serviceToTest = new WeightedMeanCalculationService();
        assertEquals(expectedResult, serviceToTest.calculateReferenceValue(participantMeasuredValueList));
    }

    //
}
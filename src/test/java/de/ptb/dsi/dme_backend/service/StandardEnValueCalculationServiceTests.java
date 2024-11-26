package de.ptb.dsi.dme_backend.service;

import de.ptb.dsi.dme_backend.model.*;
import de.ptb.dsi.dme_backend.service.submodel.StandardEnValueCalculationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class StandardEnValueCalculationServiceTests {

    private HashMap<String, SiReal> contributionMeasuredValues;
    private StandardEnValueCalculationService standardEnValueCalculationService;
    private List<String> outlierContributions;

    @BeforeEach
    void init(){
        standardEnValueCalculationService = new StandardEnValueCalculationService();

        //Example Values
        contributionMeasuredValues = new HashMap<>();
        contributionMeasuredValues.put("1", new SiReal(22.11, new SiExpandedMU(1.0, 2)));
        contributionMeasuredValues.put("2", new SiReal(22.22, new SiExpandedMU(1.0, 2)));
        contributionMeasuredValues.put("3", new SiReal(23.40, new SiExpandedMU(0.5, 2)));

        outlierContributions = Arrays.asList("1", "3");
    }

    @Test
    public void testOutlierCalculation(){

        ReferenceValue referenceValue = new ReferenceValue(new SiReal(22.9883333,
                new SiExpandedMU(0.40824829, 2)));
        HashMap<String, EnValue> enValues = standardEnValueCalculationService.calculateEnValue(
                contributionMeasuredValues, referenceValue, outlierContributions);

        assertEquals(enValues.get("1").getMethod(), "uncorrelated EnValue");
        assertEquals(enValues.get("2").getMethod(), "correlated EnValue");
        assertEquals(enValues.get("3").getMethod(), "uncorrelated EnValue");
    }

    @Test
    public void testCorrelatedEnValueCalculation(){

        //creating Inputs

        ReferenceValue referenceValue = new ReferenceValue(new SiReal(22.9883333,
                new SiExpandedMU(0.40824829, 2)));

        // Formatting the result
        EnValue expectedResult = new EnValue(new SiReal(0.962165959), "correlated EnValue");

        // calculating correlated EnValue
        EnValue result = standardEnValueCalculationService.calculateCorrelatedEnValue(
                contributionMeasuredValues.get("1"), referenceValue);

        double epsilon = 0.00001;
        assertEquals(expectedResult.getEnValueRaw().getValue(), result.getEnValueRaw().getValue(), epsilon);
    }

    @Test
    public void testUncorrelatedEnValueCalculation(){

        //creating Inputs

        ReferenceValue referenceValue = new ReferenceValue(new SiReal(22.1650000,
                new SiExpandedMU(0.707106781, 2)));

        // Formatting the result
        EnValue expectedResult = new EnValue(new SiReal(1.4260552), "uncorrelated EnValue");

        // calculating correlated EnValue
        EnValue result = standardEnValueCalculationService.calculateUncorrelatedEnValue(
                contributionMeasuredValues.get("3"), referenceValue);

        double epsilon = 0.00001;
        assertEquals(expectedResult.getEnValueRaw().getValue(), result.getEnValueRaw().getValue(), epsilon);
    }


}

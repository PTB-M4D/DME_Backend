package de.ptb.dsi.dme_backend;

import de.ptb.dsi.dme_backend.model.*;
import de.ptb.dsi.dme_backend.service.submodel.StandardBilateralEnValueCalculationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class StandardBilateralEnValueCalculationServiceTests {

    private HashMap<String, SiReal> contributionMeasuredValues;
    private HashMap<String, Contribution> contributions;
    StandardBilateralEnValueCalculationService StandardBilateralEnValueCalculationService;

    @BeforeEach
    void init(){
        StandardBilateralEnValueCalculationService = new StandardBilateralEnValueCalculationService();

        //Example Values
        contributionMeasuredValues = new HashMap<>();
        contributionMeasuredValues.put("0", new SiReal(1.0, new SiExpandedUnc(0.4, 2)));
        contributionMeasuredValues.put("1", new SiReal(1.5, new SiExpandedUnc(0.3, 2)));

        contributions = new HashMap<>();
        contributions.put("0", new Contribution("123"));
        contributions.put("1", new Contribution("456"));


    }

    @Test
    public void testBilateralEnValueCalculation(){

        // Formatting the result
        HashMap<String, BilateralEnValue> bilateralEnValues0 = new HashMap<>();
        bilateralEnValues0.put("0", new BilateralEnValue(
                "bilateral En value calculation",
                new EnValue(new SiReal(0.0), "bilateral EnValue"),
                "bilateral En Value",
                "123",
                "123"));
        bilateralEnValues0.put("1", new BilateralEnValue(
                "bilateral En value calculation",
                new EnValue(new SiReal(1.0), "bilateral EnValue"),
                "bilateral En Value",
                "123",
                "456"));

        HashMap<String, BilateralEnValue> bilateralEnValues1 = new HashMap<>();
        bilateralEnValues1.put("0", new BilateralEnValue(
                "bilateral En value calculation",
                new EnValue(new SiReal(1.0), "bilateral EnValue"),
                "bilateral En Value",
                "456",
                "123"));
        bilateralEnValues1.put("1", new BilateralEnValue(
                "bilateral En value calculation",
                new EnValue(new SiReal(0.0), "bilateral EnValue"),
                "bilateral En Value",
                "456",
                "456"));

        //Expected result
        HashMap<String, HashMap<String, BilateralEnValue>> expectedResult = new HashMap<>();
        expectedResult.put("0", bilateralEnValues0);
        expectedResult.put("1", bilateralEnValues1);

        //Call Function
//        StandardBilateralEnValueCalculationService StandardBilateralEnValueCalculationService = new StandardBilateralEnValueCalculationService();
        HashMap<String, HashMap<String, BilateralEnValue>> result =
                StandardBilateralEnValueCalculationService
                        .calculateBilateralEnValues(contributionMeasuredValues, contributions);

        // asserts
        assertEquals(result, expectedResult);
    }

    @Test
    public void testExceptionSizesOfValuesAndContributions(){

        //Example Values
        contributions.remove("1");

        //Call Function
//        StandardBilateralEnValueCalculationService StandardBilateralEnValueCalculationService = new StandardBilateralEnValueCalculationService();

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> StandardBilateralEnValueCalculationService
                        .calculateBilateralEnValues(contributionMeasuredValues, contributions));

        assertEquals("Encountered a different number of contributionMeasuredValues and contributions.",
                exception.getMessage());
    }

    @Test
    public void testExceptionNullValuesInContributions(){
        contributions.put("0", new Contribution());

        NullPointerException exception = assertThrows(NullPointerException.class,
                () -> StandardBilateralEnValueCalculationService
                        .calculateBilateralEnValues(contributionMeasuredValues, contributions));

        assertEquals("ContributionId in contribution cannot be null.",
                exception.getMessage());
    }

    @Test
    public void testExceptionNullValuesInContributionMeasuredValues(){
        contributionMeasuredValues.put("0", new SiReal(null, new SiExpandedUnc(0.4, 2)));

        NullPointerException exception = assertThrows(NullPointerException.class,
                () -> StandardBilateralEnValueCalculationService
                        .calculateBilateralEnValues(contributionMeasuredValues, contributions));

        assertEquals("Value in SiReal cannot be null.",
                exception.getMessage());
    }

    @Test
    public void testExceptionNullValuesInExpUnc(){
        contributionMeasuredValues.put("0", new SiReal(1.0, new SiExpandedUnc()));

        NullPointerException exception = assertThrows(NullPointerException.class,
                () -> StandardBilateralEnValueCalculationService
                        .calculateBilateralEnValues(contributionMeasuredValues, contributions));

        assertEquals("Uncertainty in ExpUnc cannot be null.",
                exception.getMessage());
    }


}

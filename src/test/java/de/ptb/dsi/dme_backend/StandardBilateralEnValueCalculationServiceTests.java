package de.ptb.dsi.dme_backend;

import de.ptb.dsi.dme_backend.model.*;
import de.ptb.dsi.dme_backend.service.submodel.StandardBilateralEnValueCalculationService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class StandardBilateralEnValueCalculationServiceTests {



    @Test
    public void testBilateralEnValueCalculation(){
        //Example Values
        HashMap<String, SiReal> contributionMeasuredValues = new HashMap<>();
        contributionMeasuredValues.put("0", new SiReal(1.0, new SiExpandedUnc(0.4, 1)));
        contributionMeasuredValues.put("1", new SiReal(1.5, new SiExpandedUnc(0.3, 1)));

        HashMap<String, Contribution> contributions = new HashMap<>();
        contributions.put("0", new Contribution("123"));
        contributions.put("1", new Contribution("456"));

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
        StandardBilateralEnValueCalculationService StandardBilateralEnValueCalculationService = new StandardBilateralEnValueCalculationService();
        HashMap<String, HashMap<String, BilateralEnValue>> result =
                StandardBilateralEnValueCalculationService
                        .calculateBilateralEnValues(contributionMeasuredValues, contributions);

        // asserts
        assertEquals(result, expectedResult);
    }
}

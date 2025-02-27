package de.ptb.dsi.dme_backend.service.plot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ScatterPlotWithErrorBarsTest {


    //DME Plot example data
    @BeforeEach
    void init() {

        //plot name
        String plotTitle = "Calibration PT-100";

        //axis labels
        String axisLabelX = "Temperature pt-100 / °C";
        String axisLabelY = "Reference Value / °C";

        //values as List<Double[]>
        List<Double[]> values = new ArrayList<>();
        values.add(new Double[]{1.0, 5.3, 3.1, 7.8});
        values.add(new Double[]{2.0, 10.2, 6.9, 12.5});
        values.add(new Double[]{3.0, -3.6, -5.2, 0.0});
        values.add(new Double[]{4.0, 7.9, 2.4, 9.3});
        values.add(new Double[]{5.0, -2.1, -8.5, 1.6});

        //x axis range
        Double rangeMin = 0.0;
        Double rangeMax = 6.0;
    }

    @Test
    public void testCreatePlot() {

    }

}

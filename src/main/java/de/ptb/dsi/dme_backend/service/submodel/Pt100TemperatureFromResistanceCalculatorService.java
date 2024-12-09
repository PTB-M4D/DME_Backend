package de.ptb.dsi.dme_backend.service.submodel;

import de.ptb.dsi.dme_backend.model.SiExpandedMU;
import de.ptb.dsi.dme_backend.model.SiReal;
import org.springframework.stereotype.Service;

@Service
public class Pt100TemperatureFromResistanceCalculatorService implements ITemperatureFromResistanceCalculatorService {

    @Override
    public SiReal calculateTemperature(SiReal resistance) {

        // Clibration Factors
        double aPt100 = -0.0000640851395582478;
        double bPt100 = 0.391809225298376;
        double cPt100 = 100.036630814515;

        //calculate Temperature
        Double r = resistance.getValue();
        double expMU = resistance.getExpandedMU().getValueExpandedMU();
        int covFactor = resistance.getExpandedMU().getCoverageFactor();

        double temperature = (-bPt100 + Math.sqrt(Math.pow(bPt100, 2) - 4 * aPt100 * cPt100 + 4 * aPt100 * r)) / (2 * aPt100);

        //Uncertainty calculation:
        double uncMKT50 = 1.417744687875780; //Uncertainty of bath (nonlinearity,...)
        double uncKalPt100 = 3; //Uncertainty of pt100 calibration generalized
        double uncR = expMU / covFactor;
        double uncRad = uncR/r/(0.014388/0.00001/Math.pow((273.15+temperature),2)); // from comparison with radiation thermometer
        double uncTemperature = Math.sqrt(uncMKT50*uncMKT50 + uncKalPt100*uncKalPt100 + uncRad*uncRad) * covFactor/1000; //k=2

        // Build SiReal result
        SiReal result = SiReal.builder()
                .label("pt100 Temperature")
                .value(temperature)
                .unit("\\degreecelsius")
                .expandedMU(SiExpandedMU.builder()
                        .valueExpandedMU(uncTemperature)
                        .coverageFactor(covFactor)
                        .coverageProbability(resistance.getExpandedMU().getCoverageProbability()).
                        distribution(resistance.getExpandedMU().getDistribution()).build())
                .build();

        return result;
    }
}

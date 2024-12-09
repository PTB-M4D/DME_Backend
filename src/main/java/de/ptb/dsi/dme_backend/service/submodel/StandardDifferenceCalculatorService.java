package de.ptb.dsi.dme_backend.service.submodel;

import de.ptb.dsi.dme_backend.model.SiExpandedMU;
import de.ptb.dsi.dme_backend.model.SiReal;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StandardDifferenceCalculatorService implements IDifferenceCalculatorService {
    @Override
    public SiReal calculateDifference(SiReal siReal1, SiReal siReal2) {


        double val1 = siReal1.getValue();
        double val2 = siReal2.getValue();

        double uncVal1 = siReal1.getExpandedMU().getValueExpandedMU() / siReal1.getExpandedMU().getCoverageFactor();
        double uncVal2 = siReal2.getExpandedMU().getValueExpandedMU() / siReal2.getExpandedMU().getCoverageFactor();

        double diff = val1 - val2;
        double uncDiff = Math.sqrt(uncVal1*uncVal1 +uncVal2*uncVal2) * 2;


        // build new ExpandedUncertaintyXMLList and SiRealXMLList
        SiReal result = SiReal.builder()
                .label("TeperatureDifference")
                .value(diff)
                .unit(siReal1.getUnit())
                .expandedMU(SiExpandedMU.builder()
                        .valueExpandedMU(uncDiff)
                        .coverageFactor(2)
                        .coverageProbability(0.95)
                        .distribution(siReal1.getExpandedMU().getDistribution())
                        .build())
                .build();

        return result;
    }
}

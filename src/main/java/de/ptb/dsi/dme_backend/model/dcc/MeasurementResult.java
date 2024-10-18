package de.ptb.dsi.dme_backend.model.dcc;

import lombok.Data;

import java.util.List;

@Data
public class MeasurementResult {
    private MeasurementResultName name;
    private List<UsedMethod> usedMethods;
    private List<MeasuringEquipment> measuringEquipments;
    private List <InfluenceCondition> influenceConditions;
    private List<Result> results;
}

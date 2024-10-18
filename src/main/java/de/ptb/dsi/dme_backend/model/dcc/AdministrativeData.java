package de.ptb.dsi.dme_backend.model.dcc;

import lombok.Data;

import java.util.List;
@Data
public class AdministrativeData {
    private DccSoftware dccSoftware;
    private CoreData coreData;
    private List<Item> items;
    private CalibrationLaboratory calibrationLaboratory;
    private List<RespPerson> respPersons;
    private Customer customer;
    private List <Statement> statements;
    private List<MeasurementResult>measurementResults;

}

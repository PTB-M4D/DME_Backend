package de.ptb.dsi.dme_backend.model.dcc;

import lombok.Data;

import java.util.List;
@Data
public class DigitalCalibrationCertificate {
    private AdministrativeData administrativeData;
    private List<MeasurementResult>  measurementResults;
}

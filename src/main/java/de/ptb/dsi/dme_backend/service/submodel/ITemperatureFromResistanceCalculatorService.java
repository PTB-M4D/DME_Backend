package de.ptb.dsi.dme_backend.service.submodel;

import de.ptb.dsi.dme_backend.model.SiReal;

public interface ITemperatureFromResistanceCalculatorService {

    SiReal calculateTemperature(SiReal resistance);

}

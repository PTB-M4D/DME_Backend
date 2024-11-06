package de.ptb.dsi.dme_backend.service.submodel;

import de.ptb.dsi.dme_backend.model.BilateralEnValue;
import de.ptb.dsi.dme_backend.model.Contribution;
import de.ptb.dsi.dme_backend.model.SiReal;

import java.util.HashMap;

public interface IBilateralEnCalculationService {
   //public HashMap<String, HashMap<String, BilateralEnValue>> calculateBilateralEnValues(HashMap<String, SiReal> contributionMeasuredValues);
   public HashMap<String, HashMap<String, BilateralEnValue>> calculateBilateralEnValues(HashMap<String, SiReal> contributionMeasuredValues,
                                                                                        HashMap<String, Contribution> contributions);
}

//contribution 1
//35 °C -> 10
//40 °C - 12
//45 °C - 13

//contribution 2
//35 °C -> 11
//40 °C - 12
//45 °C - 13


//HashMap
//"1": 10
//"2": 11
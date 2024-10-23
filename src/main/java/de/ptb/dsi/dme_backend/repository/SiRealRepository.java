package de.ptb.dsi.dme_backend.repository;


import de.ptb.dsi.dme_backend.model.SiReal;
import de.ptb.dsi.dme_backend.model.dcc.DigitalCalibrationCertificate;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Data
public class SiRealRepository {
    private final List<SiReal>siRealList = new ArrayList<>();

    DigitalCalibrationCertificate dcc =new DigitalCalibrationCertificate();
    public List<SiReal> getSiRealList() {
        return siRealList;
    }
    public DigitalCalibrationCertificate getDcc(){
        return dcc;
    }
    public SiReal findById(int id){
        for(SiReal siReal: siRealList){
            if(siReal.getId() == id){
                return siRealList.get(id);
            }
        }
        return null;
    }

    public SiReal save(SiReal siReal){
        SiReal si= new SiReal();
        si.setId(siReal.getId());
        si.setName(siReal.getName());
        si.setValue(siReal.getValue());
        si.setUnit(siReal.getUnit());
        si.setDateTime(siReal.getDateTime());
        si.setExpUnc(siReal.getExpUnc());
        siRealList.add(si);
        return si;
    }
}

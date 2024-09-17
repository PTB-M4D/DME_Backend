package de.ptb.dsi.dme_backend.service;


import de.ptb.dsi.dme_backend.model.SiReal;
import de.ptb.dsi.dme_backend.repository.SiRealRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SiRealService {
    SiRealRepository siRealRepository;

    public SiReal save(SiReal siReal){
        return siRealRepository.save(siReal);
    }

    public SiReal findById(int id){
       return siRealRepository.findById(id);
    }

    public List<SiReal> getSiRealList() {
        return siRealRepository.getSiRealList();
    }

}

package de.ptb.dsi.dme_backend.controller;

import de.ptb.dsi.dme_backend.model.SiReal;
import de.ptb.dsi.dme_backend.model.dcc.DigitalCalibrationCertificate;
import de.ptb.dsi.dme_backend.repository.SiRealRepository;
import de.ptb.dsi.dme_backend.service.SiRealService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/dme-comparison")
@AllArgsConstructor
public class DmeController {

   private final SiRealService siRealService;
    private final SiRealRepository siRealRepository ;
    @RequestMapping(value = "/sayHello", method = RequestMethod.GET)
    public String sayHelloWorld() {return " Test Hi";
    }
    @RequestMapping(value = "/addSiReal", method = RequestMethod.POST)
    public ResponseEntity<SiReal> addSiReal(@RequestBody SiReal siReal)
    {
        return new ResponseEntity<>(siRealService.save(siReal), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/siRealList", method = RequestMethod.GET)
    public ResponseEntity <List<SiReal>> getSiRealList()
    {
        return new ResponseEntity<>(siRealService.getSiRealList(), HttpStatus.OK);
    }
    @RequestMapping(value = "/dcc", method = RequestMethod.GET ,produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<DigitalCalibrationCertificate> getDcc(){
       return new ResponseEntity<>(siRealService.getDcc(), HttpStatus.OK);
   }
}


package de.ptb.dsi.dme_backend.controller;

import de.ptb.dsi.dme_backend.model.SiReal;

import de.ptb.dsi.dme_backend.repository.SiRealRepository;
import de.ptb.dsi.dme_backend.service.InputReaderService;
import de.ptb.dsi.dme_backend.service.submodel.SiRealService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;

@RestController
@RequestMapping(path = "/api/dme-comparison")
@AllArgsConstructor
public class DmeController {

   private final SiRealService siRealService;
    private final InputReaderService inputReaderService;
    private final SiRealRepository siRealRepository ;

    @RequestMapping(value = "/dcc/{pid}", method = RequestMethod.GET )
    public ResponseEntity<Document> readDocument(@PathVariable String pid) throws ParserConfigurationException, IOException, SAXException {
        return new ResponseEntity<>(inputReaderService.readDocument(pid), HttpStatus.OK);
    }


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

}


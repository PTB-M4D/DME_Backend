package de.ptb.dsi.dme_backend.controller;

import de.ptb.dsi.dme_backend.model.SiReal;
import de.ptb.dsi.dme_backend.service.domain.VirtualMassComparisonService;
import de.ptb.dsi.dme_backend.service.input.InputReaderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(path = "/api/dme-comparison")
@AllArgsConstructor
public class DmeController {

    private final InputReaderService inputReaderService;

    @RequestMapping(value = "/dcc/{pid}", method = RequestMethod.GET)
    public ResponseEntity<Document> readDocument(@PathVariable String pid) throws ParserConfigurationException, IOException, SAXException {
        return new ResponseEntity<>(inputReaderService.readDocument(pid), HttpStatus.OK);
    }

    @RequestMapping(value = "/testMass", method = RequestMethod.GET)
    public String compareMass()  {
        VirtualMassComparisonService virtualMassComparisonService = new VirtualMassComparisonService();
        virtualMassComparisonService.evaluateComparison("");
        return "evaluation complete";
    }

    @RequestMapping(value = "/sayHello", method = RequestMethod.GET)
    public String sayHelloWorld() {return " Test Hi";}
}


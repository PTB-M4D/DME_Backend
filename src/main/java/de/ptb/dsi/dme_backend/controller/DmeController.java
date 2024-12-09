package de.ptb.dsi.dme_backend.controller;

import de.ptb.dsi.dme_backend.model.DataIdentifier;
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
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;


@RestController
@RequestMapping(path = "/api/dme-comparison")
@AllArgsConstructor
public class DmeController {

    private final InputReaderService inputReaderService;
    private final VirtualMassComparisonService virtualMassComparisonService;
    private  final DccServiceOutputWriter dccService;
    private final VirtualRadTemperatureComparisonService virtualRadTemperatureComparisonService;

    @RequestMapping(value = "/dcc/{pid}", method = RequestMethod.GET )
    public ResponseEntity<Document> readDocument(@PathVariable String pid) throws ParserConfigurationException, IOException, SAXException {
        return new ResponseEntity<>(inputReaderService.readDocument(pid), HttpStatus.OK);
    }
//    @RequestMapping(value = "/sireal", method = RequestMethod.GET)
//    public ResponseEntity<SiReal> readData(@PathVariable DataIdentifier dataIdentifier, @PathVariable Document document) throws ParserConfigurationException, IOException, SAXException, TransformerException, XPathExpressionException {
//        return new ResponseEntity<>(inputReaderService.readData(dataIdentifier,document), HttpStatus.OK);
//    }
//    @RequestMapping(value = "/sireal", method = RequestMethod.GET)
//    public ResponseEntity<SiReal> readData() throws ParserConfigurationException, IOException, SAXException, TransformerException, XPathExpressionException {
//        return new ResponseEntity<>(inputReaderService.readData(), HttpStatus.OK);
//    }
    @RequestMapping(value = "/testMass", method = RequestMethod.GET)
    public String compareMass()  {
        virtualMassComparisonService.evaluateComparison("");
        return "evaluation complete";
    }

    @RequestMapping(value = "/testTemp", method = RequestMethod.GET)
    public String compareTemp() throws XPathExpressionException, ParserConfigurationException, IOException, TransformerException, SAXException {
        virtualRadTemperatureComparisonService.evaluateComparison("");
        return "evaluation complete";
    }

    @GetMapping(value = "/outputReport", produces = {MediaType.APPLICATION_XML_VALUE} )
    public  ResponseEntity< String> getDcc() throws JAXBException, DatatypeConfigurationException {

        return new ResponseEntity<>(dccService.getOutputReport(), HttpStatus.OK);}
    @RequestMapping(value = "/sayHello", method = RequestMethod.GET)
    public String sayHelloWorld() {return " Test Hi";}
}


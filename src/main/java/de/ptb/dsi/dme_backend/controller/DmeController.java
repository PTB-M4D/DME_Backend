package de.ptb.dsi.dme_backend.controller;

import com.fasterxml.jackson.databind.JsonNode;
import de.ptb.dsi.dme_backend.model.OutputReport;
import de.ptb.dsi.dme_backend.service.domain.VirtualMassComparisonService;
import de.ptb.dsi.dme_backend.service.domain.VirtualRadTemperatureComparisonService;
import de.ptb.dsi.dme_backend.service.input.InputReaderService;
import de.ptb.dsi.dme_backend.service.DmeService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.xml.bind.JAXBException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;

@OpenAPIDefinition(
        info = @Info(
                title = "D-Comparison Service Backend API",
                termsOfService = "https://d-si.ptb.de/#/d-comparison",
                description = "This API exposes endpoints to manage D-Comparison.",
                version = "v0.3",
                contact = @Contact(
                        name = "D-SI Services",
                        url = "https://d-si.ptb.de",
                        email = "Daniel.Hutzschenreuter@ptb.de")),
        servers = {
                @Server(url = "http://localhost:8080", description = "Server URL in development environment")
        })
@Tag(name = "D-Comparison Controller")
@RestController
@RequestMapping(path = "/api/dme-comparison")
@AllArgsConstructor
public class DmeController {

    private final InputReaderService inputReaderService;
    private final VirtualMassComparisonService virtualMassComparisonService;
    private final DmeService dccService;
    private final VirtualRadTemperatureComparisonService virtualRadTemperatureComparisonService;


    @RequestMapping(value = "/evaluateComparison", method = RequestMethod.POST)
    public ResponseEntity<OutputReport> evaluateDKCR(@RequestBody
                                                     @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "A Json Node contain all participants and the PIDDCC", content = @Content(schema = @Schema(example = "{\n" +
                                                             "\"keyComparisonData\" : {\n" +
                                                             "\"pidReport\" : \"mass_Report\",\n" +
                                                             "\"smartStandardEvaluationMethod\" : \"massIntercomparison\",\n" +
                                                             "\"participantList\" : [ {\n" +
                                                             "\"participant\" : {\n" +
                                                             "\n" +
                                                             "\"name\" : \"CENAM\",\n" +
                                                             "\"pidDCC\" : \"https://d-si.ptb.de/api/d-dcc/dcc/Mass_Comparison_CENAM\"\n" +
                                                             "}\n" +
                                                             "}, {\n" +
                                                             "\"participant\" : {\n" +
                                                             "\n" +
                                                             "\"name\" : \"INRIM\",\n" +
                                                             "\"pidDCC\" : \"https://d-si.ptb.de/api/d-dcc/dcc/Mass_Comparison_INRIM\"\n" +
                                                             "}\n" +
                                                             "}, {\n" +
                                                             "\"participant\" : {\n" +
                                                             "\n" +
                                                             "\"name\" : \"KRISS\",\n" +
                                                             "\"pidDCC\" : \"https://d-si.ptb.de/api/d-dcc/dcc/Mass_Comparison_KRISS\"\n" +
                                                             "}\n" +
                                                             "} ]\n" +
                                                             "}\n" +
                                                             "}")))
                                                     JsonNode inputJson) throws DatatypeConfigurationException, JAXBException, XPathExpressionException, ParserConfigurationException, IOException, TransformerException, SAXException {
        return new ResponseEntity<>(dccService.evaluate(inputJson), HttpStatus.CREATED);
    }
    @RequestMapping(value = "/evaluateComparisonTemp", method = RequestMethod.POST)
    public ResponseEntity<OutputReport> evaluateDKCRTemp(@RequestBody
                                                     @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "A Json Node contain all participants and the PIDDCC", content = @Content(schema = @Schema(example = "{\n" +
                                                             "\"keyComparisonData\" : {\n" +
                                                             "\"pidReport\" : \"Temp_Report\",\n" +
                                                             "\"smartStandardEvaluationMethod\" : \"radiationTempComparison\",\n" +
                                                             "\"participantList\" : [ {\n" +
                                                             "\"participant\" : {\n" +
                                                             "\n" +
                                                             "\"name\" : \"PTB_1\",\n" +
                                                             "\"pidDCC\" : \"http://localhost:8085/api/d-dcc/dcc/Temp_Comparison_PTB_1\"\n" +
                                                             "}\n" +
                                                             "}, {\n" +
                                                             "\"participant\" : {\n" +
                                                             "\n" +
                                                             "\"name\" : \"PTB_2\",\n" +
                                                             "\"pidDCC\" : \"http://localhost:8085/api/d-dcc/dcc/Temp_Comparison_PTB_2\"\n" +
                                                             "}\n" +
                                                             "}, {\n" +
                                                             "\"participant\" : {\n" +
                                                             "\n" +
                                                             "\"name\" : \"PTB_3\",\n" +
                                                             "\"pidDCC\" : \"http://localhost:8085/api/d-dcc/dcc/Temp_Comparison_PTB_3\"\n" +
                                                             "}\n" +
                                                             "} ]\n" +
                                                             "}\n" +
                                                             "}")))
                                                     JsonNode inputJson) throws DatatypeConfigurationException, JAXBException, XPathExpressionException, ParserConfigurationException, IOException, TransformerException, SAXException {
        return new ResponseEntity<>(dccService.evaluate(inputJson), HttpStatus.CREATED);
    }
    @RequestMapping(value = "/sayHello", method = RequestMethod.GET)
    public String sayHelloWorld() {
        return " Test Hi";
    }
}


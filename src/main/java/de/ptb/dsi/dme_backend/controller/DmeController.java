package de.ptb.dsi.dme_backend.controller;

import com.fasterxml.jackson.databind.JsonNode;
import de.ptb.dsi.dme_backend.model.OutputReport;
import de.ptb.dsi.dme_backend.service.DmeService;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
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
import org.xml.sax.SAXException;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;

@OpenAPIDefinition(
        info = @Info(
                title = "DME Service Backend API",
                termsOfService = "https://d-si.ptb.de/#/d-comparison",
                description = "This API exposes endpoints to manage DME .",
                version = "v0.3",
                contact = @Contact(
                        name = "D-SI Services",
                        url = "https://d-si.ptb.de",
                        email = "Daniel.Hutzschenreuter@ptb.de")),
        servers = {
                @Server(url = "https://d-si.ptb.de", description = "URL in production  environment"),
                @Server(url = "http://localhost:8083", description = "URL in development environment")

        })
@Tag(name = "DME Controller")
@RestController
@RequestMapping(path = "/api/d-comparison")
@AllArgsConstructor
public class DmeController {

    private final DmeService dmeService;

    @RequestMapping(value = "/evaluateComparison", method = RequestMethod.POST)
    @Operation(
            summary = "Retrieve a JSON with the fileName and the Base64 string encoded DCC",
            description = "POST request where the RequestBody a JSON_KeyComparisonData  with pidReport name, a list of participants, the evaluationMethod (mass, temperature...), and DCC PIDs as the message and receives a JSON with Base64 encoded DCC back."
            )
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<OutputReport> evaluateDKCR(@RequestBody
                                                     @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "A Json Node contain keyComparisonData", content = @Content(schema = @Schema(example = "{\n" +
                                                             "\"keyComparisonData\" : {\n" +
                                                             "\"pidReport\" : \"mass_Report\",\n" +
                                                             "\"smartStandardEvaluationMethod\" : \"massIntercomparison\",\n" +
                                                             "\"participantList\" : [ {\n" +
                                                             "\"participant\" : {\n" +
                                                             "\n" +
                                                             "\"name\" : \"CENAM\",\n" +
                                                             "\"pidDCC\" : \"https://d-si.ptb.de/api/d-dcc/dcc/Mass_Comparison_CENAM\"\n" +
                                                             "}\n" +
                                                             "},{\n" +
                                                             "\"participant\" : {\n" +
                                                             "\n" +
                                                             "\"name\" : \"IMIJ\",\n" +
                                                             "\"pidDCC\" : \"https://d-si.ptb.de/api/d-dcc/dcc/Mass_Comparison_NMIJ\"\n" +
                                                             "}\n" +
                                                             "},{\n" +
                                                             "\"participant\" : {\n" +
                                                             "\n" +
                                                             "\"name\" : \"PTB_Ausreisser\",\n" +
                                                             "\"pidDCC\" : \"https://d-si.ptb.de/api/d-dcc/dcc/Mass_Comparison_PTB_Ausreisser\"\n" +
                                                             "}\n" +
                                                             "},{\n" +
                                                             "\"participant\" : {\n" +
                                                             "\n" +
                                                             "\"name\" : \"PTB\",\n" +
                                                             "\"pidDCC\" : \"https://d-si.ptb.de/api/d-dcc/dcc/Mass_Comparison_PTB\"\n" +
                                                             "}\n" +
                                                             "},{\n" +
                                                             "\"participant\" : {\n" +
                                                             "\"name\" : \"NRC\",\n" +
                                                             "\"pidDCC\" : \"https://d-si.ptb.de/api/d-dcc/dcc/Mass_Comparison_NRC\"\n" +
                                                             "}\n" +
                                                             "},{\n" +
                                                             "\"participant\" : {\n" +
                                                             "\n" +
                                                             "\"name\" : \"NPL\",\n" +
                                                             "\"pidDCC\" : \"https://d-si.ptb.de/api/d-dcc/dcc/Mass_Comparison_NPL\"\n" +
                                                             "}\n" +
                                                             "},{\n" +
                                                             "\"participant\" : {\n" +
                                                             "\n" +
                                                             "\"name\" : \"NIM\",\n" +
                                                             "\"pidDCC\" : \"https://d-si.ptb.de/api/d-dcc/dcc/Mass_Comparison_NIM\"\n" +
                                                             "}\n" +
                                                             "},{\n" +
                                                             "\"participant\" : {\n" +
                                                             "\n" +
                                                             "\"name\" : \"UME\",\n" +
                                                             "\"pidDCC\" : \"https://d-si.ptb.de/api/d-dcc/dcc/Mass_Comparison_UME\"\n" +
                                                             "}\n" +
                                                             "},{\n" +
                                                             "\"participant\" : {\n" +
                                                             "\n" +
                                                             "\"name\" : \"MSL\",\n" +
                                                             "\"pidDCC\" : \"https://d-si.ptb.de/api/d-dcc/dcc/Mass_Comparison_MSL\"\n" +
                                                             "}\n" +
                                                             "},{\n" +
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
        return new ResponseEntity<>(dmeService.evaluate(inputJson), HttpStatus.CREATED);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(
            summary = "Retrieve a JSON with the fileName and the Base64 string encoded DCC",
            description = "POST request where the RequestBody a JSON_KeyComparisonData  with pidReport name, a list of participants, the evaluationMethod (mass, temperature...), and DCC PIDs as the message and receives a JSON with Base64 encoded DCC back.")
    @RequestMapping(value = "/evaluateComparisonTemp", method = RequestMethod.POST)
    public ResponseEntity<OutputReport> evaluateDKCRTemp(@RequestBody
                                                     @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "A Json Node contain keyComparisonData", content = @Content(schema = @Schema(example = "{\n" +
                                                             "\"keyComparisonData\" : {\n" +
                                                             "\"pidReport\" : \"Temp_Report\",\n" +
                                                             "\"smartStandardEvaluationMethod\" : \"radiationTempComparison\",\n" +
                                                             "\"participantList\" : [ {\n" +
                                                             "\"participant\" : {\n" +
                                                             "\n" +
                                                             "\"name\" : \"PTB_1\",\n" +
                                                             "\"pidDCC\" : \"https://d-si.ptb.de/api/d-dcc/dcc/Temp_Comparison_PTB_1\"\n" +
                                                             "}\n" +
                                                             "}, {\n" +
                                                             "\"participant\" : {\n" +
                                                             "\n" +
                                                             "\"name\" : \"PTB_2\",\n" +
                                                             "\"pidDCC\" : \"https://d-si.ptb.de/api/d-dcc/dcc/Temp_Comparison_PTB_2\"\n" +
                                                             "}\n" +
                                                             "}, {\n" +
                                                             "\"participant\" : {\n" +
                                                             "\n" +
                                                             "\"name\" : \"PTB_3\",\n" +
                                                             "\"pidDCC\" : \"https://d-si.ptb.de/api/d-dcc/dcc/Temp_Comparison_PTB_3\"\n" +
                                                             "}\n" +
                                                             "} ]\n" +
                                                             "}\n" +
                                                             "}")))
                                                     JsonNode inputJson) throws DatatypeConfigurationException, JAXBException, XPathExpressionException, ParserConfigurationException, IOException, TransformerException, SAXException {
        return new ResponseEntity<>(dmeService.evaluate(inputJson), HttpStatus.CREATED);
    }
    @RequestMapping(value = "/testDme", method = RequestMethod.GET)
    @Hidden
    public String sayHelloWorld() {
        return " DME Service";
    }
}


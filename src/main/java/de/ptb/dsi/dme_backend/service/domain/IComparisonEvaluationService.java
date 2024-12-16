package de.ptb.dsi.dme_backend.service.domain;

import com.fasterxml.jackson.databind.JsonNode;
import de.ptb.dsi.dme_backend.model.OutputReport;
import jakarta.xml.bind.JAXBException;
import org.xml.sax.SAXException;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;

public interface IComparisonEvaluationService {
    OutputReport evaluateComparison(JsonNode inputJson) throws XPathExpressionException, ParserConfigurationException, IOException, TransformerException, SAXException, JAXBException, DatatypeConfigurationException;
}

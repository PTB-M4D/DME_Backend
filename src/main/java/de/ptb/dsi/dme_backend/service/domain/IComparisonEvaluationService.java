package de.ptb.dsi.dme_backend.service.domain;

import jakarta.xml.bind.JAXBException;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;

public interface IComparisonEvaluationService {
    String evaluateComparison(String inputJson) throws XPathExpressionException, ParserConfigurationException, IOException, TransformerException, SAXException, JAXBException;
}

package de.ptb.dsi.dme_backend.service.input;

import de.ptb.dsi.dme_backend.model.ComparisonDataModel;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;



public interface IInputReaderService {
    void loadData(ComparisonDataModel comparisonDataModel) throws ParserConfigurationException, IOException, SAXException, TransformerException;
//    Document readDocument(String pidInputData) throws ParserConfigurationException, IOException, SAXException;
}

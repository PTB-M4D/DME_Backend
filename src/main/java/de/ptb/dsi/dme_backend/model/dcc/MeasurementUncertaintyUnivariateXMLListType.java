//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2024.11.29 um 02:25:21 PM CET 
//


package de.ptb.dsi.dme_backend.model.dcc;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>Java-Klasse für measurementUncertaintyUnivariateXMLListType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="measurementUncertaintyUnivariateXMLListType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice&gt;
 *         &lt;element name="standardMUXMLList" type="{https://ptb.de/si}standardMUXMLListType"/&gt;
 *         &lt;element name="expandedMUXMLList" type="{https://ptb.de/si}expandedMUXMLListType"/&gt;
 *         &lt;element name="coverageIntervalMUXMLList" type="{https://ptb.de/si}coverageIntervalMUXMLListType"/&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "measurementUncertaintyUnivariateXMLListType", namespace = "https://ptb.de/si", propOrder = {
    "standardMUXMLList",
    "expandedMUXMLList",
    "coverageIntervalMUXMLList"
})
public class MeasurementUncertaintyUnivariateXMLListType {

    protected StandardMUXMLListType standardMUXMLList;
    protected ExpandedMUXMLListType expandedMUXMLList;
    protected CoverageIntervalMUXMLListType coverageIntervalMUXMLList;

    /**
     * Ruft den Wert der standardMUXMLList-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link StandardMUXMLListType }
     *     
     */
    public StandardMUXMLListType getStandardMUXMLList() {
        return standardMUXMLList;
    }

    /**
     * Legt den Wert der standardMUXMLList-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link StandardMUXMLListType }
     *     
     */
    public void setStandardMUXMLList(StandardMUXMLListType value) {
        this.standardMUXMLList = value;
    }

    /**
     * Ruft den Wert der expandedMUXMLList-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ExpandedMUXMLListType }
     *     
     */
    public ExpandedMUXMLListType getExpandedMUXMLList() {
        return expandedMUXMLList;
    }

    /**
     * Legt den Wert der expandedMUXMLList-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ExpandedMUXMLListType }
     *     
     */
    public void setExpandedMUXMLList(ExpandedMUXMLListType value) {
        this.expandedMUXMLList = value;
    }

    /**
     * Ruft den Wert der coverageIntervalMUXMLList-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CoverageIntervalMUXMLListType }
     *     
     */
    public CoverageIntervalMUXMLListType getCoverageIntervalMUXMLList() {
        return coverageIntervalMUXMLList;
    }

    /**
     * Legt den Wert der coverageIntervalMUXMLList-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CoverageIntervalMUXMLListType }
     *     
     */
    public void setCoverageIntervalMUXMLList(CoverageIntervalMUXMLListType value) {
        this.coverageIntervalMUXMLList = value;
    }

}

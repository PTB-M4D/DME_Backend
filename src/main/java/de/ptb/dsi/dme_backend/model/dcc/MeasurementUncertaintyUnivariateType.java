//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2024.11.29 um 02:25:21 PM CET 
//


package de.ptb.dsi.dme_backend.model.dcc;


import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;


/**
 * <p>Java-Klasse für measurementUncertaintyUnivariateType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="measurementUncertaintyUnivariateType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice&gt;
 *         &lt;element name="standardMU" type="{https://ptb.de/si}standardMUType"/&gt;
 *         &lt;element name="expandedMU" type="{https://ptb.de/si}expandedMUType"/&gt;
 *         &lt;element name="coverageIntervalMU" type="{https://ptb.de/si}coverageIntervalMUType"/&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)

public class MeasurementUncertaintyUnivariateType {

    protected StandardMUType standardMU;
    protected ExpandedMUType expandedMU;
    protected CoverageIntervalMUType coverageIntervalMU;

    /**
     * Ruft den Wert der standardMU-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link StandardMUType }
     *     
     */
    public StandardMUType getStandardMU() {
        return standardMU;
    }

    /**
     * Legt den Wert der standardMU-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link StandardMUType }
     *     
     */
    public void setStandardMU(StandardMUType value) {
        this.standardMU = value;
    }

    /**
     * Ruft den Wert der expandedMU-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ExpandedMUType }
     *     
     */
    public ExpandedMUType getExpandedMU() {
        return expandedMU;
    }

    /**
     * Legt den Wert der expandedMU-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ExpandedMUType }
     *     
     */
    public void setExpandedMU(ExpandedMUType value) {
        this.expandedMU = value;
    }

    /**
     * Ruft den Wert der coverageIntervalMU-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CoverageIntervalMUType }
     *     
     */
    public CoverageIntervalMUType getCoverageIntervalMU() {
        return coverageIntervalMU;
    }

    /**
     * Legt den Wert der coverageIntervalMU-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CoverageIntervalMUType }
     *     
     */
    public void setCoverageIntervalMU(CoverageIntervalMUType value) {
        this.coverageIntervalMU = value;
    }

}

//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2024.12.02 um 09:37:57 AM CET 
//


package de.ptb.dsi.dme_backend.model.dcc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>Java-Klasse für listMeasurementUncertaintyUnivariateType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="listMeasurementUncertaintyUnivariateType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice&gt;
 *         &lt;element name="standardMU" type="{https://ptb.de/si}standardMUType"/&gt;
 *         &lt;element name="expandedMU" type="{https://ptb.de/si}expandedMUType"/&gt;
 *         &lt;element name="coverageIntervalMU" type="{https://ptb.de/si}coverageIntervalType"/&gt;
 *         &lt;element name="expandedUnc" type="{https://ptb.de/si}expandedUncType"/&gt;
 *         &lt;element name="coverageInterval" type="{https://ptb.de/si}coverageIntervalType"/&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "listMeasurementUncertaintyUnivariateType", namespace = "https://ptb.de/si", propOrder = {
    "standardMU",
    "expandedMU",
    "coverageIntervalMU",
    "expandedUnc",
    "coverageInterval"
})
public class ListMeasurementUncertaintyUnivariateType {

    protected StandardMUType standardMU;
    protected ExpandedMUType expandedMU;
    protected CoverageIntervalType coverageIntervalMU;
    protected ExpandedUncType expandedUnc;
    protected CoverageIntervalType coverageInterval;

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
     *     {@link CoverageIntervalType }
     *     
     */
    public CoverageIntervalType getCoverageIntervalMU() {
        return coverageIntervalMU;
    }

    /**
     * Legt den Wert der coverageIntervalMU-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CoverageIntervalType }
     *     
     */
    public void setCoverageIntervalMU(CoverageIntervalType value) {
        this.coverageIntervalMU = value;
    }

    /**
     * Ruft den Wert der expandedUnc-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ExpandedUncType }
     *     
     */
    public ExpandedUncType getExpandedUnc() {
        return expandedUnc;
    }

    /**
     * Legt den Wert der expandedUnc-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ExpandedUncType }
     *     
     */
    public void setExpandedUnc(ExpandedUncType value) {
        this.expandedUnc = value;
    }

    /**
     * Ruft den Wert der coverageInterval-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CoverageIntervalType }
     *     
     */
    public CoverageIntervalType getCoverageInterval() {
        return coverageInterval;
    }

    /**
     * Legt den Wert der coverageInterval-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CoverageIntervalType }
     *     
     */
    public void setCoverageInterval(CoverageIntervalType value) {
        this.coverageInterval = value;
    }

}

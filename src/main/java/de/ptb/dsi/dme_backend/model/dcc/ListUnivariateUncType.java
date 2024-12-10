//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2024.12.02 um 09:37:57 AM CET 
//


package de.ptb.dsi.dme_backend.model.dcc;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;


/**
 * [deprecated type] use listMeasurementUncertaintyUnivariateType instead
 * 
 * <p>Java-Klasse für listUnivariateUncType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="listUnivariateUncType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice&gt;
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

public class ListUnivariateUncType {

    protected ExpandedUncType expandedUnc;
    protected CoverageIntervalType coverageInterval;

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

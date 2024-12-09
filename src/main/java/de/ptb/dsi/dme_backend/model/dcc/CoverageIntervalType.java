//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2024.11.29 um 02:25:21 PM CET 
//


package de.ptb.dsi.dme_backend.model.dcc;

import lombok.Data;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * [deprecated element] use si:coverageIntervalMU
 * 
 * <p>Java-Klasse für coverageIntervalType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="coverageIntervalType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="standardUnc" type="{https://ptb.de/si}uncertaintyValueType"/&gt;
 *         &lt;element name="intervalMin" type="{https://ptb.de/si}decimalType"/&gt;
 *         &lt;element name="intervalMax" type="{https://ptb.de/si}decimalType"/&gt;
 *         &lt;element name="coverageProbability" type="{https://ptb.de/si}probabilityValueType"/&gt;
 *         &lt;element name="distribution" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "coverageIntervalType", namespace = "https://ptb.de/si", propOrder = {
    "standardUnc",
    "intervalMin",
    "intervalMax",
    "coverageProbability",
    "distribution"
})
@Data
public class CoverageIntervalType {

    protected double standardUnc;
    protected double intervalMin;
    protected double intervalMax;
    protected double coverageProbability;
    protected String distribution;

    /**
     * Ruft den Wert der standardUnc-Eigenschaft ab.
     * 
     */
    public double getStandardUnc() {
        return standardUnc;
    }

    /**
     * Legt den Wert der standardUnc-Eigenschaft fest.
     * 
     */
    public void setStandardUnc(double value) {
        this.standardUnc = value;
    }

    /**
     * Ruft den Wert der intervalMin-Eigenschaft ab.
     * 
     */
    public double getIntervalMin() {
        return intervalMin;
    }

    /**
     * Legt den Wert der intervalMin-Eigenschaft fest.
     * 
     */
    public void setIntervalMin(double value) {
        this.intervalMin = value;
    }

    /**
     * Ruft den Wert der intervalMax-Eigenschaft ab.
     * 
     */
    public double getIntervalMax() {
        return intervalMax;
    }

    /**
     * Legt den Wert der intervalMax-Eigenschaft fest.
     * 
     */
    public void setIntervalMax(double value) {
        this.intervalMax = value;
    }

    /**
     * Ruft den Wert der coverageProbability-Eigenschaft ab.
     * 
     */
    public double getCoverageProbability() {
        return coverageProbability;
    }

    /**
     * Legt den Wert der coverageProbability-Eigenschaft fest.
     * 
     */
    public void setCoverageProbability(double value) {
        this.coverageProbability = value;
    }

    /**
     * Ruft den Wert der distribution-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDistribution() {
        return distribution;
    }

    /**
     * Legt den Wert der distribution-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDistribution(String value) {
        this.distribution = value;
    }

}

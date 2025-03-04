//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2024.11.29 um 02:25:21 PM CET 
//


package de.ptb.dsi.dme_backend.model.dcc;

import lombok.Data;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;


/**
 * Definition of coverage interval measurement uncertainty data.
 * 
 * <p>Java-Klasse für coverageIntervalMUType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="coverageIntervalMUType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="valueStandardMU" type="{https://ptb.de/si}valueStandardMUType"/&gt;
 *         &lt;element name="intervalMin" type="{https://ptb.de/si}intervalMinType"/&gt;
 *         &lt;element name="intervalMax" type="{https://ptb.de/si}intervalMaxType"/&gt;
 *         &lt;element name="coverageProbability" type="{https://ptb.de/si}probabilityValueType"/&gt;
 *         &lt;element name="distribution" type="{https://ptb.de/si}distributionType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)

@Data
public class CoverageIntervalMUType {

    protected double valueStandardMU;
    protected double intervalMin;
    protected double intervalMax;
    protected double coverageProbability;
    protected String distribution;

    /**
     * Ruft den Wert der valueStandardMU-Eigenschaft ab.
     * 
     */
    public double getValueStandardMU() {
        return valueStandardMU;
    }

    /**
     * Legt den Wert der valueStandardMU-Eigenschaft fest.
     * 
     */
    public void setValueStandardMU(double value) {
        this.valueStandardMU = value;
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

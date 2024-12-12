//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2024.11.29 um 02:25:21 PM CET 
//


package de.ptb.dsi.dme_backend.model.dcc;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;


/**
 * [deprecated element] use si:expandedMU
 * 
 * <p>Java-Klasse für expandedUncType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="expandedUncType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="uncertainty" type="{https://ptb.de/si}uncertaintyValueType"/&gt;
 *         &lt;element name="coverageFactor" type="{https://ptb.de/si}kValueType"/&gt;
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

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExpandedUncType {

    protected double uncertainty;
    protected double coverageFactor;
    protected double coverageProbability;
    protected String distribution;

    /**
     * Ruft den Wert der uncertainty-Eigenschaft ab.
     * 
     */
    public double getUncertainty() {
        return uncertainty;
    }

    /**
     * Legt den Wert der uncertainty-Eigenschaft fest.
     * 
     */
    public void setUncertainty(double value) {
        this.uncertainty = value;
    }

    /**
     * Ruft den Wert der coverageFactor-Eigenschaft ab.
     * 
     */
    public double getCoverageFactor() {
        return coverageFactor;
    }

    /**
     * Legt den Wert der coverageFactor-Eigenschaft fest.
     * 
     */
    public void setCoverageFactor(double value) {
        this.coverageFactor = value;
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

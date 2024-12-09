//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2024.11.29 um 02:25:21 PM CET 
//


package de.ptb.dsi.dme_backend.model.dcc;


import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigInteger;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>Java-Klasse für realQuantityType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="realQuantityType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="label" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element ref="{https://ptb.de/si}quantityType" minOccurs="0"/&gt;
 *         &lt;element name="value" type="{https://ptb.de/si}decimalType"/&gt;
 *         &lt;element name="unit" type="{https://ptb.de/si}unitType"/&gt;
 *         &lt;element name="significantDigit" type="{https://ptb.de/si}significantDigitType" minOccurs="0"/&gt;
 *         &lt;element name="dateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;choice minOccurs="0"&gt;
 *           &lt;element name="measurementUncertaintyUnivariate" type="{https://ptb.de/si}measurementUncertaintyUnivariateType"/&gt;
 *           &lt;element name="expandedUnc" type="{https://ptb.de/si}expandedUncType"/&gt;
 *           &lt;element name="coverageInterval" type="{https://ptb.de/si}coverageIntervalType"/&gt;
 *         &lt;/choice&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "realQuantityType", namespace = "https://ptb.de/si", propOrder = {
    "label",
    "quantityType",
    "value",
    "unit",
    "significantDigit",
    "dateTime",
    "measurementUncertaintyUnivariate",
    "expandedUnc",
    "coverageInterval"
})
public class RealQuantityType {

    protected String label;
    @XmlElementRef(name = "quantityType", namespace = "https://ptb.de/si", type = JAXBElement.class, required = false)
    protected JAXBElement<String> quantityType;
    protected double value;
    @XmlElement(required = true)
    protected String unit;
    protected BigInteger significantDigit;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateTime;
    protected MeasurementUncertaintyUnivariateType measurementUncertaintyUnivariate;
    protected ExpandedUncType expandedUnc;
    protected CoverageIntervalType coverageInterval;

    /**
     * Ruft den Wert der label-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLabel() {
        return label;
    }

    /**
     * Legt den Wert der label-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLabel(String value) {
        this.label = value;
    }

    /**
     * Ruft den Wert der quantityType-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getQuantityType() {
        return quantityType;
    }

    /**
     * Legt den Wert der quantityType-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setQuantityType(JAXBElement<String> value) {
        this.quantityType = value;
    }

    /**
     * Ruft den Wert der value-Eigenschaft ab.
     * 
     */
    public double getValue() {
        return value;
    }

    /**
     * Legt den Wert der value-Eigenschaft fest.
     * 
     */
    public void setValue(double value) {
        this.value = value;
    }

    /**
     * Ruft den Wert der unit-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnit() {
        return unit;
    }

    /**
     * Legt den Wert der unit-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnit(String value) {
        this.unit = value;
    }

    /**
     * Ruft den Wert der significantDigit-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSignificantDigit() {
        return significantDigit;
    }

    /**
     * Legt den Wert der significantDigit-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSignificantDigit(BigInteger value) {
        this.significantDigit = value;
    }

    /**
     * Ruft den Wert der dateTime-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateTime() {
        return dateTime;
    }

    /**
     * Legt den Wert der dateTime-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateTime(XMLGregorianCalendar value) {
        this.dateTime = value;
    }

    /**
     * Ruft den Wert der measurementUncertaintyUnivariate-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MeasurementUncertaintyUnivariateType }
     *     
     */
    public MeasurementUncertaintyUnivariateType getMeasurementUncertaintyUnivariate() {
        return measurementUncertaintyUnivariate;
    }

    /**
     * Legt den Wert der measurementUncertaintyUnivariate-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MeasurementUncertaintyUnivariateType }
     *     
     */
    public void setMeasurementUncertaintyUnivariate(MeasurementUncertaintyUnivariateType value) {
        this.measurementUncertaintyUnivariate = value;
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

//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2024.11.29 um 02:25:21 PM CET 
//


package de.ptb.dsi.dme_backend.model.dcc;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>Java-Klasse für realListXMLListType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="realListXMLListType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="labelXMLList" type="{https://ptb.de/si}stringXMLListType" minOccurs="0"/&gt;
 *         &lt;element ref="{https://ptb.de/si}quantityTypeXMLList" minOccurs="0"/&gt;
 *         &lt;element name="valueXMLList" type="{https://ptb.de/si}decimalXMLListType"/&gt;
 *         &lt;element name="unitXMLList" type="{https://ptb.de/si}unitXMLListType"/&gt;
 *         &lt;element name="significantDigitXMLList" type="{https://ptb.de/si}significantDigitXMLListType" minOccurs="0"/&gt;
 *         &lt;element name="dateTimeXMLList" type="{https://ptb.de/si}dateTimeXMLListType" minOccurs="0"/&gt;
 *         &lt;choice minOccurs="0"&gt;
 *           &lt;element name="measurementUncertaintyUnivariateXMLList" type="{https://ptb.de/si}measurementUncertaintyUnivariateXMLListType"/&gt;
 *           &lt;element name="expandedUncXMLList" type="{https://ptb.de/si}expandedUncXMLListType"/&gt;
 *           &lt;element name="coverageIntervalXMLList" type="{https://ptb.de/si}coverageIntervalXMLListType"/&gt;
 *         &lt;/choice&gt;
 *         &lt;choice minOccurs="0"&gt;
 *           &lt;element name="measurementUncertaintyMultivariateXMLList" type="{https://ptb.de/si}measurementUncertaintyMultivariateXMLListType"/&gt;
 *           &lt;element name="ellipsoidalRegionXMLList" type="{https://ptb.de/si}ellipsoidalRegionType"/&gt;
 *           &lt;element name="rectangularRegionXMLList" type="{https://ptb.de/si}rectangularRegionType"/&gt;
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
@XmlType(name = "realListXMLListType", namespace = "https://ptb.de/si", propOrder = {
    "labelXMLList",
    "quantityTypeXMLList",
    "valueXMLList",
    "unitXMLList",
    "significantDigitXMLList",
    "dateTimeXMLList",
    "measurementUncertaintyUnivariateXMLList",
    "expandedUncXMLList",
    "coverageIntervalXMLList",
    "measurementUncertaintyMultivariateXMLList",
    "ellipsoidalRegionXMLList",
    "rectangularRegionXMLList"
})
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RealListXMLListType {

    @XmlList
    protected List<String> labelXMLList;
    @XmlElementRef(name = "quantityTypeXMLList", namespace = "https://ptb.de/si", type = JAXBElement.class, required = false)
    protected JAXBElement<String> quantityTypeXMLList;
    @XmlList
    @XmlElement(type = Double.class)
    protected List<Double> valueXMLList;
    @XmlList
    @XmlElement(required = true)
    protected List<String> unitXMLList;
    @XmlList
    protected List<BigInteger> significantDigitXMLList;
    @XmlList
    protected List<XMLGregorianCalendar> dateTimeXMLList;
    protected MeasurementUncertaintyUnivariateXMLListType measurementUncertaintyUnivariateXMLList;
    protected ExpandedUncXMLListType expandedUncXMLList;
    protected CoverageIntervalXMLListType coverageIntervalXMLList;
    protected MeasurementUncertaintyMultivariateXMLListType measurementUncertaintyMultivariateXMLList;
    protected EllipsoidalRegionType ellipsoidalRegionXMLList;
    protected RectangularRegionType rectangularRegionXMLList;

    /**
     * Gets the value of the labelXMLList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the labelXMLList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLabelXMLList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getLabelXMLList() {
        if (labelXMLList == null) {
            labelXMLList = new ArrayList<String>();
        }
        return this.labelXMLList;
    }

    /**
     * Ruft den Wert der quantityTypeXMLList-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getQuantityTypeXMLList() {
        return quantityTypeXMLList;
    }

    /**
     * Legt den Wert der quantityTypeXMLList-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setQuantityTypeXMLList(JAXBElement<String> value) {
        this.quantityTypeXMLList = value;
    }

    /**
     * Gets the value of the valueXMLList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the valueXMLList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getValueXMLList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Double }
     * 
     * 
     */
    public List<Double> getValueXMLList() {
        if (valueXMLList == null) {
            valueXMLList = new ArrayList<Double>();
        }
        return this.valueXMLList;
    }

    /**
     * Gets the value of the unitXMLList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the unitXMLList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUnitXMLList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getUnitXMLList() {
        if (unitXMLList == null) {
            unitXMLList = new ArrayList<String>();
        }
        return this.unitXMLList;
    }

    /**
     * Gets the value of the significantDigitXMLList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the significantDigitXMLList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSignificantDigitXMLList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BigInteger }
     * 
     * 
     */
    public List<BigInteger> getSignificantDigitXMLList() {
        if (significantDigitXMLList == null) {
            significantDigitXMLList = new ArrayList<BigInteger>();
        }
        return this.significantDigitXMLList;
    }

    /**
     * Gets the value of the dateTimeXMLList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dateTimeXMLList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDateTimeXMLList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link XMLGregorianCalendar }
     * 
     * 
     */
    public List<XMLGregorianCalendar> getDateTimeXMLList() {
        if (dateTimeXMLList == null) {
            dateTimeXMLList = new ArrayList<XMLGregorianCalendar>();
        }
        return this.dateTimeXMLList;
    }

    /**
     * Ruft den Wert der measurementUncertaintyUnivariateXMLList-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MeasurementUncertaintyUnivariateXMLListType }
     *     
     */
    public MeasurementUncertaintyUnivariateXMLListType getMeasurementUncertaintyUnivariateXMLList() {
        return measurementUncertaintyUnivariateXMLList;
    }

    /**
     * Legt den Wert der measurementUncertaintyUnivariateXMLList-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MeasurementUncertaintyUnivariateXMLListType }
     *     
     */
    public void setMeasurementUncertaintyUnivariateXMLList(MeasurementUncertaintyUnivariateXMLListType value) {
        this.measurementUncertaintyUnivariateXMLList = value;
    }

    /**
     * Ruft den Wert der expandedUncXMLList-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ExpandedUncXMLListType }
     *     
     */
    public ExpandedUncXMLListType getExpandedUncXMLList() {
        return expandedUncXMLList;
    }

    /**
     * Legt den Wert der expandedUncXMLList-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ExpandedUncXMLListType }
     *     
     */
    public void setExpandedUncXMLList(ExpandedUncXMLListType value) {
        this.expandedUncXMLList = value;
    }

    /**
     * Ruft den Wert der coverageIntervalXMLList-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CoverageIntervalXMLListType }
     *     
     */
    public CoverageIntervalXMLListType getCoverageIntervalXMLList() {
        return coverageIntervalXMLList;
    }

    /**
     * Legt den Wert der coverageIntervalXMLList-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CoverageIntervalXMLListType }
     *     
     */
    public void setCoverageIntervalXMLList(CoverageIntervalXMLListType value) {
        this.coverageIntervalXMLList = value;
    }

    /**
     * Ruft den Wert der measurementUncertaintyMultivariateXMLList-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MeasurementUncertaintyMultivariateXMLListType }
     *     
     */
    public MeasurementUncertaintyMultivariateXMLListType getMeasurementUncertaintyMultivariateXMLList() {
        return measurementUncertaintyMultivariateXMLList;
    }

    /**
     * Legt den Wert der measurementUncertaintyMultivariateXMLList-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MeasurementUncertaintyMultivariateXMLListType }
     *     
     */
    public void setMeasurementUncertaintyMultivariateXMLList(MeasurementUncertaintyMultivariateXMLListType value) {
        this.measurementUncertaintyMultivariateXMLList = value;
    }

    /**
     * Ruft den Wert der ellipsoidalRegionXMLList-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link EllipsoidalRegionType }
     *     
     */
    public EllipsoidalRegionType getEllipsoidalRegionXMLList() {
        return ellipsoidalRegionXMLList;
    }

    /**
     * Legt den Wert der ellipsoidalRegionXMLList-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link EllipsoidalRegionType }
     *     
     */
    public void setEllipsoidalRegionXMLList(EllipsoidalRegionType value) {
        this.ellipsoidalRegionXMLList = value;
    }

    /**
     * Ruft den Wert der rectangularRegionXMLList-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link RectangularRegionType }
     *     
     */
    public RectangularRegionType getRectangularRegionXMLList() {
        return rectangularRegionXMLList;
    }

    /**
     * Legt den Wert der rectangularRegionXMLList-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link RectangularRegionType }
     *     
     */
    public void setRectangularRegionXMLList(RectangularRegionType value) {
        this.rectangularRegionXMLList = value;
    }

}

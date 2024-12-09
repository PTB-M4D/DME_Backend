//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2024.11.29 um 02:25:21 PM CET 
//


package de.ptb.dsi.dme_backend.model.dcc;

import lombok.AllArgsConstructor;
import lombok.Builder;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlType;

/**
 * 
 *         A measurement results with the methods, software and equipments used for the calibration.
 *         Also contains influence conditions and a list of the actual results.
 *       
 * 
 * <p>Java-Klasse für measurementResultType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="measurementResultType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="name" type="{https://ptb.de/dcc}textType"/&gt;
 *         &lt;element name="description" type="{https://ptb.de/dcc}richContentType" minOccurs="0"/&gt;
 *         &lt;element name="usedMethods" type="{https://ptb.de/dcc}usedMethodListType" minOccurs="0"/&gt;
 *         &lt;element name="usedSoftware" type="{https://ptb.de/dcc}softwareListType" minOccurs="0"/&gt;
 *         &lt;element name="measuringEquipments" type="{https://ptb.de/dcc}measuringEquipmentListType" minOccurs="0"/&gt;
 *         &lt;element name="influenceConditions" type="{https://ptb.de/dcc}influenceConditionListType" minOccurs="0"/&gt;
 *         &lt;element name="results" type="{https://ptb.de/dcc}resultListType"/&gt;
 *         &lt;element name="measurementMetaData" type="{https://ptb.de/dcc}measurementMetaDataListType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}ID" /&gt;
 *       &lt;attribute name="refId" type="{http://www.w3.org/2001/XMLSchema}IDREFS" /&gt;
 *       &lt;attribute name="refType" type="{https://ptb.de/dcc}refTypesType" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "measurementResultType", propOrder = {
    "name",
    "description",
    "usedMethods",
    "usedSoftware",
    "measuringEquipments",
    "influenceConditions",
    "results",
    "measurementMetaData"
})
@Builder
@AllArgsConstructor
public class MeasurementResultType {

    @XmlElement(required = true)
    protected TextType name;
    protected RichContentType description;
    protected UsedMethodListType usedMethods;
    protected SoftwareListType usedSoftware;
    protected MeasuringEquipmentListType measuringEquipments;
    protected InfluenceConditionListType influenceConditions;
    @XmlElement(required = true)
    protected ResultListType results;
    protected MeasurementMetaDataListType measurementMetaData;
    @XmlAttribute(name = "id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;
    @XmlAttribute(name = "refId")
    @XmlIDREF
    @XmlSchemaType(name = "IDREFS")
    protected List<Object> refId;
    @XmlAttribute(name = "refType")
    protected List<String> refType;

    public MeasurementResultType() {

    }

    /**
     * Ruft den Wert der name-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getName() {
        return name;
    }

    /**
     * Legt den Wert der name-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setName(TextType value) {
        this.name = value;
    }

    /**
     * Ruft den Wert der description-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link RichContentType }
     *     
     */
    public RichContentType getDescription() {
        return description;
    }

    /**
     * Legt den Wert der description-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link RichContentType }
     *     
     */
    public void setDescription(RichContentType value) {
        this.description = value;
    }

    /**
     * Ruft den Wert der usedMethods-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link UsedMethodListType }
     *     
     */
    public UsedMethodListType getUsedMethods() {
        return usedMethods;
    }

    /**
     * Legt den Wert der usedMethods-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link UsedMethodListType }
     *     
     */
    public void setUsedMethods(UsedMethodListType value) {
        this.usedMethods = value;
    }

    /**
     * Ruft den Wert der usedSoftware-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SoftwareListType }
     *     
     */
    public SoftwareListType getUsedSoftware() {
        return usedSoftware;
    }

    /**
     * Legt den Wert der usedSoftware-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SoftwareListType }
     *     
     */
    public void setUsedSoftware(SoftwareListType value) {
        this.usedSoftware = value;
    }

    /**
     * Ruft den Wert der measuringEquipments-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MeasuringEquipmentListType }
     *     
     */
    public MeasuringEquipmentListType getMeasuringEquipments() {
        return measuringEquipments;
    }

    /**
     * Legt den Wert der measuringEquipments-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MeasuringEquipmentListType }
     *     
     */
    public void setMeasuringEquipments(MeasuringEquipmentListType value) {
        this.measuringEquipments = value;
    }

    /**
     * Ruft den Wert der influenceConditions-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link InfluenceConditionListType }
     *     
     */
    public InfluenceConditionListType getInfluenceConditions() {
        return influenceConditions;
    }

    /**
     * Legt den Wert der influenceConditions-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link InfluenceConditionListType }
     *     
     */
    public void setInfluenceConditions(InfluenceConditionListType value) {
        this.influenceConditions = value;
    }

    /**
     * Ruft den Wert der results-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ResultListType }
     *     
     */
    public ResultListType getResults() {
        return results;
    }

    /**
     * Legt den Wert der results-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ResultListType }
     *     
     */
    public void setResults(ResultListType value) {
        this.results = value;
    }

    /**
     * Ruft den Wert der measurementMetaData-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MeasurementMetaDataListType }
     *     
     */
    public MeasurementMetaDataListType getMeasurementMetaData() {
        return measurementMetaData;
    }

    /**
     * Legt den Wert der measurementMetaData-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MeasurementMetaDataListType }
     *     
     */
    public void setMeasurementMetaData(MeasurementMetaDataListType value) {
        this.measurementMetaData = value;
    }

    /**
     * Ruft den Wert der id-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Legt den Wert der id-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the refId property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the refId property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRefId().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getRefId() {
        if (refId == null) {
            refId = new ArrayList<Object>();
        }
        return this.refId;
    }

    /**
     * Gets the value of the refType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the refType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRefType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getRefType() {
        if (refType == null) {
            refType = new ArrayList<String>();
        }
        return this.refType;
    }

}

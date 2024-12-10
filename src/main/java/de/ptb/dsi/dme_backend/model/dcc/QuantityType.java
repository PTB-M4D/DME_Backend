//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2024.11.29 um 02:25:21 PM CET 
//


package de.ptb.dsi.dme_backend.model.dcc;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.ArrayList;
import java.util.List;


/**
 * 
 *         A single measurement quantity that can contain a D-SI element or text.
 *         Additionally used methods, used software, influence conditions that only affect this quantity can be
 *         added.
 *         Measurement metadata can also be added.
 *       
 * 
 * <p>Java-Klasse für quantityType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="quantityType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="name" type="{https://ptb.de/dcc}textType" minOccurs="0"/&gt;
 *         &lt;element name="description" type="{https://ptb.de/dcc}richContentType" minOccurs="0"/&gt;
 *         &lt;choice&gt;
 *           &lt;element name="noQuantity" type="{https://ptb.de/dcc}richContentType"/&gt;
 *           &lt;element ref="{https://ptb.de/si}real"/&gt;
 *           &lt;element ref="{https://ptb.de/si}list"/&gt;
 *           &lt;element ref="{https://ptb.de/si}hybrid"/&gt;
 *           &lt;element ref="{https://ptb.de/si}complex"/&gt;
 *           &lt;element ref="{https://ptb.de/si}constant"/&gt;
 *           &lt;element ref="{https://ptb.de/si}realListXMLList"/&gt;
 *         &lt;/choice&gt;
 *         &lt;element name="relativeUncertainty" type="{https://ptb.de/dcc}relativeUncertaintyType" minOccurs="0"/&gt;
 *         &lt;element name="usedMethods" type="{https://ptb.de/dcc}usedMethodListType" minOccurs="0"/&gt;
 *         &lt;element name="usedSoftware" type="{https://ptb.de/dcc}softwareListType" minOccurs="0"/&gt;
 *         &lt;element name="measuringEquipments" type="{https://ptb.de/dcc}measuringEquipmentListType" minOccurs="0"/&gt;
 *         &lt;element name="influenceConditions" type="{https://ptb.de/dcc}influenceConditionListType" minOccurs="0"/&gt;
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

public class QuantityType {

    protected TextType name;
    protected RichContentType description;
    protected RichContentType noQuantity;
    @XmlElement(namespace = "https://ptb.de/si")
    protected RealQuantityType real;
    @XmlElement(namespace = "https://ptb.de/si")
    protected ListType list;
    @XmlElement(namespace = "https://ptb.de/si")
    protected HybridType hybrid;
    @XmlElement(namespace = "https://ptb.de/si")
    protected ComplexQuantityType complex;
    @XmlElement(namespace = "https://ptb.de/si")
    protected ConstantQuantityType constant;
    @XmlElement(namespace = "https://ptb.de/si")
    protected RealListXMLListType realListXMLList;
    protected RelativeUncertaintyType relativeUncertainty;
    protected UsedMethodListType usedMethods;
    protected SoftwareListType usedSoftware;
    protected MeasuringEquipmentListType measuringEquipments;
    protected InfluenceConditionListType influenceConditions;
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
     * Ruft den Wert der noQuantity-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link RichContentType }
     *     
     */
    public RichContentType getNoQuantity() {
        return noQuantity;
    }

    /**
     * Legt den Wert der noQuantity-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link RichContentType }
     *     
     */
    public void setNoQuantity(RichContentType value) {
        this.noQuantity = value;
    }

    /**
     * Ruft den Wert der real-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link RealQuantityType }
     *     
     */
    public RealQuantityType getReal() {
        return real;
    }

    /**
     * Legt den Wert der real-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link RealQuantityType }
     *     
     */
    public void setReal(RealQuantityType value) {
        this.real = value;
    }

    /**
     * Ruft den Wert der list-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ListType }
     *     
     */
    public ListType getList() {
        return list;
    }

    /**
     * Legt den Wert der list-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ListType }
     *     
     */
    public void setList(ListType value) {
        this.list = value;
    }

    /**
     * Ruft den Wert der hybrid-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link HybridType }
     *     
     */
    public HybridType getHybrid() {
        return hybrid;
    }

    /**
     * Legt den Wert der hybrid-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link HybridType }
     *     
     */
    public void setHybrid(HybridType value) {
        this.hybrid = value;
    }

    /**
     * Ruft den Wert der complex-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ComplexQuantityType }
     *     
     */
    public ComplexQuantityType getComplex() {
        return complex;
    }

    /**
     * Legt den Wert der complex-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ComplexQuantityType }
     *     
     */
    public void setComplex(ComplexQuantityType value) {
        this.complex = value;
    }

    /**
     * Ruft den Wert der constant-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ConstantQuantityType }
     *     
     */
    public ConstantQuantityType getConstant() {
        return constant;
    }

    /**
     * Legt den Wert der constant-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ConstantQuantityType }
     *     
     */
    public void setConstant(ConstantQuantityType value) {
        this.constant = value;
    }

    /**
     * Ruft den Wert der realListXMLList-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link RealListXMLListType }
     *     
     */
    public RealListXMLListType getRealListXMLList() {
        return realListXMLList;
    }

    /**
     * Legt den Wert der realListXMLList-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link RealListXMLListType }
     *     
     */
    public void setRealListXMLList(RealListXMLListType value) {
        this.realListXMLList = value;
    }

    /**
     * Ruft den Wert der relativeUncertainty-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link RelativeUncertaintyType }
     *     
     */
    public RelativeUncertaintyType getRelativeUncertainty() {
        return relativeUncertainty;
    }

    /**
     * Legt den Wert der relativeUncertainty-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link RelativeUncertaintyType }
     *     
     */
    public void setRelativeUncertainty(RelativeUncertaintyType value) {
        this.relativeUncertainty = value;
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

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
 *         Value which describes the measuringEquipment
 *       
 * 
 * <p>Java-Klasse für measuringEquipmentQuantityType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="measuringEquipmentQuantityType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="name" type="{https://ptb.de/dcc}textType" minOccurs="0"/&gt;
 *         &lt;element name="description" type="{https://ptb.de/dcc}richContentType" minOccurs="0"/&gt;
 *         &lt;choice&gt;
 *           &lt;element name="noQuantity" type="{https://ptb.de/dcc}richContentType"/&gt;
 *           &lt;element ref="{https://ptb.de/si}real"/&gt;
 *           &lt;element ref="{https://ptb.de/si}hybrid"/&gt;
 *           &lt;element ref="{https://ptb.de/si}complex"/&gt;
 *           &lt;element ref="{https://ptb.de/si}constant"/&gt;
 *           &lt;element ref="{https://ptb.de/si}realListXMLList"/&gt;
 *         &lt;/choice&gt;
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

public class MeasuringEquipmentQuantityType {

    protected TextType name;
    protected RichContentType description;
    protected RichContentType noQuantity;
    @XmlElement(namespace = "https://ptb.de/si")
    protected RealQuantityType real;
    @XmlElement(namespace = "https://ptb.de/si")
    protected HybridType hybrid;
    @XmlElement(namespace = "https://ptb.de/si")
    protected ComplexQuantityType complex;
    @XmlElement(namespace = "https://ptb.de/si")
    protected ConstantQuantityType constant;
    @XmlElement(namespace = "https://ptb.de/si")
    protected RealListXMLListType realListXMLList;
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

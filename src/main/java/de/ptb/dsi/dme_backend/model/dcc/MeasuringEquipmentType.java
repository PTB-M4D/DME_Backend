//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2024.11.29 um 02:25:21 PM CET 
//


package de.ptb.dsi.dme_backend.model.dcc;


import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlType;

/**
 * 
 *         Information about a measuring equipment or instrument used in the calibration
 *       
 * 
 * <p>Java-Klasse für measuringEquipmentType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="measuringEquipmentType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="name" type="{https://ptb.de/dcc}textType"/&gt;
 *         &lt;element name="equipmentClass" type="{https://ptb.de/dcc}equipmentClassType" minOccurs="0"/&gt;
 *         &lt;element name="description" type="{https://ptb.de/dcc}richContentType" minOccurs="0"/&gt;
 *         &lt;element name="certificate" type="{https://ptb.de/dcc}hashType" minOccurs="0"/&gt;
 *         &lt;element name="manufacturer" type="{https://ptb.de/dcc}contactNotStrictType" minOccurs="0"/&gt;
 *         &lt;element name="model" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="identifications" type="{https://ptb.de/dcc}identificationListType" minOccurs="0"/&gt;
 *         &lt;element name="measuringEquipmentQuantities" type="{https://ptb.de/dcc}measuringEquipmentQuantityListType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}ID" /&gt;
 *       &lt;attribute name="refType" type="{https://ptb.de/dcc}refTypesType" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "measuringEquipmentType", propOrder = {
    "name",
    "equipmentClass",
    "description",
    "certificate",
    "manufacturer",
    "model",
    "identifications",
    "measuringEquipmentQuantities"
})
public class MeasuringEquipmentType {

    @XmlElement(required = true)
    protected TextType name;
    protected EquipmentClassType equipmentClass;
    protected RichContentType description;
    protected HashType certificate;
    protected ContactNotStrictType manufacturer;
    protected String model;
    protected IdentificationListType identifications;
    protected MeasuringEquipmentQuantityListType measuringEquipmentQuantities;
    @XmlAttribute(name = "id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;
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
     * Ruft den Wert der equipmentClass-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link EquipmentClassType }
     *     
     */
    public EquipmentClassType getEquipmentClass() {
        return equipmentClass;
    }

    /**
     * Legt den Wert der equipmentClass-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link EquipmentClassType }
     *     
     */
    public void setEquipmentClass(EquipmentClassType value) {
        this.equipmentClass = value;
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
     * Ruft den Wert der certificate-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link HashType }
     *     
     */
    public HashType getCertificate() {
        return certificate;
    }

    /**
     * Legt den Wert der certificate-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link HashType }
     *     
     */
    public void setCertificate(HashType value) {
        this.certificate = value;
    }

    /**
     * Ruft den Wert der manufacturer-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ContactNotStrictType }
     *     
     */
    public ContactNotStrictType getManufacturer() {
        return manufacturer;
    }

    /**
     * Legt den Wert der manufacturer-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ContactNotStrictType }
     *     
     */
    public void setManufacturer(ContactNotStrictType value) {
        this.manufacturer = value;
    }

    /**
     * Ruft den Wert der model-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModel() {
        return model;
    }

    /**
     * Legt den Wert der model-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModel(String value) {
        this.model = value;
    }

    /**
     * Ruft den Wert der identifications-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link IdentificationListType }
     *     
     */
    public IdentificationListType getIdentifications() {
        return identifications;
    }

    /**
     * Legt den Wert der identifications-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentificationListType }
     *     
     */
    public void setIdentifications(IdentificationListType value) {
        this.identifications = value;
    }

    /**
     * Ruft den Wert der measuringEquipmentQuantities-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MeasuringEquipmentQuantityListType }
     *     
     */
    public MeasuringEquipmentQuantityListType getMeasuringEquipmentQuantities() {
        return measuringEquipmentQuantities;
    }

    /**
     * Legt den Wert der measuringEquipmentQuantities-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MeasuringEquipmentQuantityListType }
     *     
     */
    public void setMeasuringEquipmentQuantities(MeasuringEquipmentQuantityListType value) {
        this.measuringEquipmentQuantities = value;
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

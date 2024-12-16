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
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 *         A item that is calibrated in this DCC.
 *       
 * 
 * <p>Java-Klasse für itemType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="itemType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="name" type="{https://ptb.de/dcc}textType"/&gt;
 *         &lt;element name="equipmentClass" type="{https://ptb.de/dcc}equipmentClassType" minOccurs="0"/&gt;
 *         &lt;element name="description" type="{https://ptb.de/dcc}richContentType" minOccurs="0"/&gt;
 *         &lt;element name="installedSoftwares" type="{https://ptb.de/dcc}softwareListType" minOccurs="0"/&gt;
 *         &lt;element name="manufacturer" type="{https://ptb.de/dcc}contactNotStrictType"/&gt;
 *         &lt;element name="model" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="identifications" type="{https://ptb.de/dcc}identificationListType"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}ID" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemType {

    @XmlElement(required = true)
    protected TextType name;
    protected EquipmentClassType equipmentClass;
    protected RichContentType description;
    protected SoftwareListType installedSoftwares;
    @XmlElement(required = true)
    protected ContactNotStrictType manufacturer;
    protected String model;
    @XmlElement(required = true)
    protected IdentificationListType identifications;
    @XmlElement(required = true)
    protected ItemQuantities itemQuantities;
    @XmlAttribute(name = "id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;

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
     * Ruft den Wert der installedSoftwares-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SoftwareListType }
     *     
     */
    public SoftwareListType getInstalledSoftwares() {
        return installedSoftwares;
    }

    /**
     * Legt den Wert der installedSoftwares-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SoftwareListType }
     *     
     */
    public void setInstalledSoftwares(SoftwareListType value) {
        this.installedSoftwares = value;
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

}

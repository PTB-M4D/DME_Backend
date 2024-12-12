//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2024.11.29 um 02:25:21 PM CET 
//


package de.ptb.dsi.dme_backend.model.dcc;


import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;


/**
 * 
 *         List of measuring equipment and instruments
 *       
 * 
 * <p>Java-Klasse für measuringEquipmentListType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="measuringEquipmentListType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="name" type="{https://ptb.de/dcc}textType" minOccurs="0"/&gt;
 *         &lt;element name="equipmentClass" type="{https://ptb.de/dcc}equipmentClassType" minOccurs="0"/&gt;
 *         &lt;element name="description" type="{https://ptb.de/dcc}richContentType" minOccurs="0"/&gt;
 *         &lt;element name="owner" type="{https://ptb.de/dcc}contactType" minOccurs="0"/&gt;
 *         &lt;element name="identifications" type="{https://ptb.de/dcc}identificationListType" minOccurs="0"/&gt;
 *         &lt;element name="measuringEquipment" type="{https://ptb.de/dcc}measuringEquipmentType" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)

public class MeasuringEquipmentListType {

    protected TextType name;
    protected EquipmentClassType equipmentClass;
    protected RichContentType description;
    protected ContactType owner;
    protected IdentificationListType identifications;
    @XmlElement(required = true)
    protected List<MeasuringEquipmentType> measuringEquipment;

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
     * Ruft den Wert der owner-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ContactType }
     *     
     */
    public ContactType getOwner() {
        return owner;
    }

    /**
     * Legt den Wert der owner-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ContactType }
     *     
     */
    public void setOwner(ContactType value) {
        this.owner = value;
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
     * Gets the value of the measuringEquipment property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the measuringEquipment property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMeasuringEquipment().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MeasuringEquipmentType }
     * 
     * 
     */
    public List<MeasuringEquipmentType> getMeasuringEquipment() {
        if (measuringEquipment == null) {
            measuringEquipment = new ArrayList<MeasuringEquipmentType>();
        }
        return this.measuringEquipment;
    }

}

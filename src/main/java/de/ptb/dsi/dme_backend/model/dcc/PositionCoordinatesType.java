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
 * <p>Java-Klasse für positionCoordinatesType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="positionCoordinatesType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="positionCoordinateSystem" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="reference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="declaration" type="{https://ptb.de/dcc}richContentType" minOccurs="0"/&gt;
 *         &lt;element name="positionCoordinate1" type="{https://ptb.de/si}realQuantityType"/&gt;
 *         &lt;element name="positionCoordinate2" type="{https://ptb.de/si}realQuantityType"/&gt;
 *         &lt;element name="positionCoordinate3" type="{https://ptb.de/si}realQuantityType" minOccurs="0"/&gt;
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
@XmlType(name = "positionCoordinatesType", propOrder = {
    "positionCoordinateSystem",
    "reference",
    "declaration",
    "positionCoordinate1",
    "positionCoordinate2",
    "positionCoordinate3"
})
public class PositionCoordinatesType {

    @XmlElement(required = true)
    protected String positionCoordinateSystem;
    protected String reference;
    protected RichContentType declaration;
    @XmlElement(required = true)
    protected RealQuantityType positionCoordinate1;
    @XmlElement(required = true)
    protected RealQuantityType positionCoordinate2;
    protected RealQuantityType positionCoordinate3;
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
     * Ruft den Wert der positionCoordinateSystem-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPositionCoordinateSystem() {
        return positionCoordinateSystem;
    }

    /**
     * Legt den Wert der positionCoordinateSystem-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPositionCoordinateSystem(String value) {
        this.positionCoordinateSystem = value;
    }

    /**
     * Ruft den Wert der reference-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReference() {
        return reference;
    }

    /**
     * Legt den Wert der reference-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReference(String value) {
        this.reference = value;
    }

    /**
     * Ruft den Wert der declaration-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link RichContentType }
     *     
     */
    public RichContentType getDeclaration() {
        return declaration;
    }

    /**
     * Legt den Wert der declaration-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link RichContentType }
     *     
     */
    public void setDeclaration(RichContentType value) {
        this.declaration = value;
    }

    /**
     * Ruft den Wert der positionCoordinate1-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link RealQuantityType }
     *     
     */
    public RealQuantityType getPositionCoordinate1() {
        return positionCoordinate1;
    }

    /**
     * Legt den Wert der positionCoordinate1-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link RealQuantityType }
     *     
     */
    public void setPositionCoordinate1(RealQuantityType value) {
        this.positionCoordinate1 = value;
    }

    /**
     * Ruft den Wert der positionCoordinate2-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link RealQuantityType }
     *     
     */
    public RealQuantityType getPositionCoordinate2() {
        return positionCoordinate2;
    }

    /**
     * Legt den Wert der positionCoordinate2-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link RealQuantityType }
     *     
     */
    public void setPositionCoordinate2(RealQuantityType value) {
        this.positionCoordinate2 = value;
    }

    /**
     * Ruft den Wert der positionCoordinate3-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link RealQuantityType }
     *     
     */
    public RealQuantityType getPositionCoordinate3() {
        return positionCoordinate3;
    }

    /**
     * Legt den Wert der positionCoordinate3-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link RealQuantityType }
     *     
     */
    public void setPositionCoordinate3(RealQuantityType value) {
        this.positionCoordinate3 = value;
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

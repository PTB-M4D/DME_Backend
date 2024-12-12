//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2024.11.29 um 02:25:21 PM CET 
//


package de.ptb.dsi.dme_backend.model.dcc;


import lombok.Data;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java-Klasse für complexListType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="complexListType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="label" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="dateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element ref="{https://ptb.de/si}listQuantityType" minOccurs="0"/&gt;
 *         &lt;element name="listUnit" type="{https://ptb.de/si}unitType" minOccurs="0"/&gt;
 *         &lt;element name="listUnitPhase" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="listBivariateUnc" type="{https://ptb.de/si}listBivariateUncType" minOccurs="0"/&gt;
 *         &lt;element name="complex" type="{https://ptb.de/si}complexInListType" maxOccurs="unbounded"/&gt;
 *         &lt;choice minOccurs="0"&gt;
 *           &lt;element name="ellipsoidalRegion" type="{https://ptb.de/si}ellipsoidalRegionType"/&gt;
 *           &lt;element name="rectangularRegion" type="{https://ptb.de/si}rectangularRegionType"/&gt;
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

@Data
public class ComplexListType {

    protected String label;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateTime;
    @XmlElementRef(name = "listQuantityType", namespace = "https://ptb.de/si", type = JAXBElement.class, required = false)
    protected JAXBElement<String> listQuantityType;
    protected String listUnit;
    protected String listUnitPhase;
    protected ListBivariateUncType listBivariateUnc;
    @XmlElement(required = true)
    protected List<ComplexInListType> complex;
    protected EllipsoidalRegionType ellipsoidalRegion;
    protected RectangularRegionType rectangularRegion;

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
     * Ruft den Wert der listQuantityType-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getListQuantityType() {
        return listQuantityType;
    }

    /**
     * Legt den Wert der listQuantityType-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setListQuantityType(JAXBElement<String> value) {
        this.listQuantityType = value;
    }

    /**
     * Ruft den Wert der listUnit-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getListUnit() {
        return listUnit;
    }

    /**
     * Legt den Wert der listUnit-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setListUnit(String value) {
        this.listUnit = value;
    }

    /**
     * Ruft den Wert der listUnitPhase-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getListUnitPhase() {
        return listUnitPhase;
    }

    /**
     * Legt den Wert der listUnitPhase-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setListUnitPhase(String value) {
        this.listUnitPhase = value;
    }

    /**
     * Ruft den Wert der listBivariateUnc-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ListBivariateUncType }
     *     
     */
    public ListBivariateUncType getListBivariateUnc() {
        return listBivariateUnc;
    }

    /**
     * Legt den Wert der listBivariateUnc-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ListBivariateUncType }
     *     
     */
    public void setListBivariateUnc(ListBivariateUncType value) {
        this.listBivariateUnc = value;
    }

    /**
     * Gets the value of the complex property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the complex property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getComplex().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ComplexInListType }
     * 
     * 
     */
    public List<ComplexInListType> getComplex() {
        if (complex == null) {
            complex = new ArrayList<ComplexInListType>();
        }
        return this.complex;
    }

    /**
     * Ruft den Wert der ellipsoidalRegion-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link EllipsoidalRegionType }
     *     
     */
    public EllipsoidalRegionType getEllipsoidalRegion() {
        return ellipsoidalRegion;
    }

    /**
     * Legt den Wert der ellipsoidalRegion-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link EllipsoidalRegionType }
     *     
     */
    public void setEllipsoidalRegion(EllipsoidalRegionType value) {
        this.ellipsoidalRegion = value;
    }

    /**
     * Ruft den Wert der rectangularRegion-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link RectangularRegionType }
     *     
     */
    public RectangularRegionType getRectangularRegion() {
        return rectangularRegion;
    }

    /**
     * Legt den Wert der rectangularRegion-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link RectangularRegionType }
     *     
     */
    public void setRectangularRegion(RectangularRegionType value) {
        this.rectangularRegion = value;
    }

}

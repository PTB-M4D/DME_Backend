//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2024.11.29 um 02:25:21 PM CET 
//


package de.ptb.dsi.dme_backend.model.dcc;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>Java-Klasse für listType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="listType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="label" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="dateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;choice maxOccurs="unbounded"&gt;
 *           &lt;element name="realList" type="{https://ptb.de/si}realListType"/&gt;
 *           &lt;element name="realListXMLList" type="{https://ptb.de/si}realListXMLListType"/&gt;
 *           &lt;element name="complexList" type="{https://ptb.de/si}complexListType"/&gt;
 *           &lt;element name="complexListXMLList" type="{https://ptb.de/si}complexListXMLListType"/&gt;
 *           &lt;element name="list" type="{https://ptb.de/si}listType"/&gt;
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
@XmlType(name = "listType", namespace = "https://ptb.de/si", propOrder = {
    "label",
    "dateTime",
    "realListOrRealListXMLListOrComplexList"
})
public class ListType {

    protected String label;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateTime;
    @XmlElements({
        @XmlElement(name = "realList", type = RealListType.class),
        @XmlElement(name = "realListXMLList", type = RealListXMLListType.class),
        @XmlElement(name = "complexList", type = ComplexListType.class),
        @XmlElement(name = "complexListXMLList", type = ComplexListXMLListType.class),
        @XmlElement(name = "list", type = ListType.class)
    })
    protected List<Object> realListOrRealListXMLListOrComplexList;

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
     * Gets the value of the realListOrRealListXMLListOrComplexList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the realListOrRealListXMLListOrComplexList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRealListOrRealListXMLListOrComplexList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RealListType }
     * {@link RealListXMLListType }
     * {@link ComplexListType }
     * {@link ComplexListXMLListType }
     * {@link ListType }
     * 
     * 
     */
    public List<Object> getRealListOrRealListXMLListOrComplexList() {
        if (realListOrRealListXMLListOrComplexList == null) {
            realListOrRealListXMLListOrComplexList = new ArrayList<Object>();
        }
        return this.realListOrRealListXMLListOrComplexList;
    }

}

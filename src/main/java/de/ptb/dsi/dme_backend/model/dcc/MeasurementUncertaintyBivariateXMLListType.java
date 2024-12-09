//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2024.11.29 um 02:25:21 PM CET 
//


package de.ptb.dsi.dme_backend.model.dcc;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>Java-Klasse für measurementUncertaintyBivariateXMLListType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="measurementUncertaintyBivariateXMLListType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice minOccurs="0"&gt;
 *         &lt;element name="ellipsoidalRegionMUXMLList" type="{https://ptb.de/si}ellipsoidalRegionMUXMLListType"/&gt;
 *         &lt;element name="rectangularRegionMUXMLList" type="{https://ptb.de/si}rectangularRegionMUXMLListType"/&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "measurementUncertaintyBivariateXMLListType", namespace = "https://ptb.de/si", propOrder = {
    "ellipsoidalRegionMUXMLList",
    "rectangularRegionMUXMLList"
})
public class MeasurementUncertaintyBivariateXMLListType {

    protected EllipsoidalRegionMUXMLListType ellipsoidalRegionMUXMLList;
    protected RectangularRegionMUXMLListType rectangularRegionMUXMLList;

    /**
     * Ruft den Wert der ellipsoidalRegionMUXMLList-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link EllipsoidalRegionMUXMLListType }
     *     
     */
    public EllipsoidalRegionMUXMLListType getEllipsoidalRegionMUXMLList() {
        return ellipsoidalRegionMUXMLList;
    }

    /**
     * Legt den Wert der ellipsoidalRegionMUXMLList-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link EllipsoidalRegionMUXMLListType }
     *     
     */
    public void setEllipsoidalRegionMUXMLList(EllipsoidalRegionMUXMLListType value) {
        this.ellipsoidalRegionMUXMLList = value;
    }

    /**
     * Ruft den Wert der rectangularRegionMUXMLList-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link RectangularRegionMUXMLListType }
     *     
     */
    public RectangularRegionMUXMLListType getRectangularRegionMUXMLList() {
        return rectangularRegionMUXMLList;
    }

    /**
     * Legt den Wert der rectangularRegionMUXMLList-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link RectangularRegionMUXMLListType }
     *     
     */
    public void setRectangularRegionMUXMLList(RectangularRegionMUXMLListType value) {
        this.rectangularRegionMUXMLList = value;
    }

}

//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2024.11.29 um 02:25:21 PM CET 
//


package de.ptb.dsi.dme_backend.model.dcc;


import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;


/**
 * <p>Java-Klasse für listBivariateUncType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="listBivariateUncType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice minOccurs="0"&gt;
 *         &lt;element name="ellipsoidalRegion" type="{https://ptb.de/si}ellipsoidalRegionType"/&gt;
 *         &lt;element name="rectangularRegion" type="{https://ptb.de/si}rectangularRegionType"/&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)

public class ListBivariateUncType {

    protected EllipsoidalRegionType ellipsoidalRegion;
    protected RectangularRegionType rectangularRegion;

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

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
 * <p>Java-Klasse für relativeUncertaintyType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="relativeUncertaintyType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice&gt;
 *         &lt;element name="relativeUncertaintyXmlList" type="{https://ptb.de/si}realListXMLListType"/&gt;
 *         &lt;element name="relativeUncertaintySingle" type="{https://ptb.de/si}realQuantityType"/&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "relativeUncertaintyType", propOrder = {
    "relativeUncertaintyXmlList",
    "relativeUncertaintySingle"
})
public class RelativeUncertaintyType {

    protected RealListXMLListType relativeUncertaintyXmlList;
    protected RealQuantityType relativeUncertaintySingle;

    /**
     * Ruft den Wert der relativeUncertaintyXmlList-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link RealListXMLListType }
     *     
     */
    public RealListXMLListType getRelativeUncertaintyXmlList() {
        return relativeUncertaintyXmlList;
    }

    /**
     * Legt den Wert der relativeUncertaintyXmlList-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link RealListXMLListType }
     *     
     */
    public void setRelativeUncertaintyXmlList(RealListXMLListType value) {
        this.relativeUncertaintyXmlList = value;
    }

    /**
     * Ruft den Wert der relativeUncertaintySingle-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link RealQuantityType }
     *     
     */
    public RealQuantityType getRelativeUncertaintySingle() {
        return relativeUncertaintySingle;
    }

    /**
     * Legt den Wert der relativeUncertaintySingle-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link RealQuantityType }
     *     
     */
    public void setRelativeUncertaintySingle(RealQuantityType value) {
        this.relativeUncertaintySingle = value;
    }

}

//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2024.11.29 um 02:25:21 PM CET 
//


package de.ptb.dsi.dme_backend.model.dcc;

import lombok.Data;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für complexInListType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="complexInListType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="label" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element ref="{https://ptb.de/si}quantityType" minOccurs="0"/&gt;
 *         &lt;choice&gt;
 *           &lt;sequence&gt;
 *             &lt;element name="valueReal" type="{https://ptb.de/si}decimalType"/&gt;
 *             &lt;element name="valueImag" type="{https://ptb.de/si}decimalType"/&gt;
 *             &lt;element name="unit" type="{https://ptb.de/si}unitType" minOccurs="0"/&gt;
 *           &lt;/sequence&gt;
 *           &lt;sequence&gt;
 *             &lt;element name="valueMagnitude" type="{https://ptb.de/si}decimalType"/&gt;
 *             &lt;element name="valuePhase" type="{https://ptb.de/si}decimalType"/&gt;
 *             &lt;element name="unit" type="{https://ptb.de/si}unitType" minOccurs="0"/&gt;
 *             &lt;element name="unitPhase" type="{https://ptb.de/si}unitPhaseType" minOccurs="0"/&gt;
 *           &lt;/sequence&gt;
 *         &lt;/choice&gt;
 *         &lt;element name="dateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
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
@XmlType(name = "complexInListType", namespace = "https://ptb.de/si", propOrder = {
    "content"
})
@Data
public class ComplexInListType {

    @XmlElementRefs({
        @XmlElementRef(name = "label", namespace = "https://ptb.de/si", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "quantityType", namespace = "https://ptb.de/si", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "valueReal", namespace = "https://ptb.de/si", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "valueImag", namespace = "https://ptb.de/si", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "unit", namespace = "https://ptb.de/si", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "valueMagnitude", namespace = "https://ptb.de/si", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "valuePhase", namespace = "https://ptb.de/si", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "unitPhase", namespace = "https://ptb.de/si", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "dateTime", namespace = "https://ptb.de/si", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ellipsoidalRegion", namespace = "https://ptb.de/si", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "rectangularRegion", namespace = "https://ptb.de/si", type = JAXBElement.class, required = false)
    })
    protected List<JAXBElement<?>> content;

    /**
     * Ruft das restliche Contentmodell ab. 
     * 
     * <p>
     * Sie rufen diese "catch-all"-Eigenschaft aus folgendem Grund ab: 
     * Der Feldname "Unit" wird von zwei verschiedenen Teilen eines Schemas verwendet. Siehe: 
     * Zeile 869 von file:/C:/Users/eljaoua01/Downloads/xcd/src/main/xsd/SI_Format.xsd
     * Zeile 862 von file:/C:/Users/eljaoua01/Downloads/xcd/src/main/xsd/SI_Format.xsd
     * <p>
     * Um diese Eigenschaft zu entfernen, wenden Sie eine Eigenschaftenanpassung für eine
     * der beiden folgenden Deklarationen an, um deren Namen zu ändern: 
     * Gets the value of the content property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the content property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Double }{@code >}
     * {@link JAXBElement }{@code <}{@link Double }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Double }{@code >}
     * {@link JAXBElement }{@code <}{@link Double }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     * {@link JAXBElement }{@code <}{@link EllipsoidalRegionType }{@code >}
     * {@link JAXBElement }{@code <}{@link RectangularRegionType }{@code >}
     * 
     * 
     */
    public List<JAXBElement<?>> getContent() {
        if (content == null) {
            content = new ArrayList<JAXBElement<?>>();
        }
        return this.content;
    }

}

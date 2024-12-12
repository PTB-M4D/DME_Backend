//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2024.11.29 um 02:25:21 PM CET 
//


package de.ptb.dsi.dme_backend.model.dcc;


import lombok.Data;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlElementRefs;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java-Klasse für complexListXMLListType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="complexListXMLListType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="labelXMLList" type="{https://ptb.de/si}stringXMLListType" minOccurs="0"/&gt;
 *         &lt;element ref="{https://ptb.de/si}quantityTypeXMLList" minOccurs="0"/&gt;
 *         &lt;choice&gt;
 *           &lt;sequence&gt;
 *             &lt;element name="valueRealXMLList" type="{https://ptb.de/si}decimalXMLListType"/&gt;
 *             &lt;element name="valueImagXMLList" type="{https://ptb.de/si}decimalXMLListType"/&gt;
 *             &lt;element name="unitXMLList" type="{https://ptb.de/si}unitXMLListType"/&gt;
 *           &lt;/sequence&gt;
 *           &lt;sequence&gt;
 *             &lt;element name="valueMagnitudeXMLList" type="{https://ptb.de/si}decimalXMLListType"/&gt;
 *             &lt;element name="valuePhaseXMLList" type="{https://ptb.de/si}decimalXMLListType"/&gt;
 *             &lt;element name="unitXMLList" type="{https://ptb.de/si}unitXMLListType"/&gt;
 *             &lt;element name="unitPhaseXMLList" type="{https://ptb.de/si}unitPhaseXMLListType"/&gt;
 *           &lt;/sequence&gt;
 *         &lt;/choice&gt;
 *         &lt;element name="dateTimeXMLList" type="{https://ptb.de/si}dateTimeXMLListType" minOccurs="0"/&gt;
 *         &lt;element name="measurementUncertaintyBivariateXMLList" type="{https://ptb.de/si}measurementUncertaintyBivariateXMLListType" minOccurs="0"/&gt;
 *         &lt;element name="measurementUncertaintyMultivariateXMLList" type="{https://ptb.de/si}measurementUncertaintyMultivariateXMLListType" minOccurs="0"/&gt;
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
public class ComplexListXMLListType {

    @XmlElementRefs({
        @XmlElementRef(name = "labelXMLList", namespace = "https://ptb.de/si", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "quantityTypeXMLList", namespace = "https://ptb.de/si", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "valueRealXMLList", namespace = "https://ptb.de/si", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "valueImagXMLList", namespace = "https://ptb.de/si", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "unitXMLList", namespace = "https://ptb.de/si", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "valueMagnitudeXMLList", namespace = "https://ptb.de/si", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "valuePhaseXMLList", namespace = "https://ptb.de/si", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "unitPhaseXMLList", namespace = "https://ptb.de/si", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "dateTimeXMLList", namespace = "https://ptb.de/si", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "measurementUncertaintyBivariateXMLList", namespace = "https://ptb.de/si", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "measurementUncertaintyMultivariateXMLList", namespace = "https://ptb.de/si", type = JAXBElement.class, required = false)
    })
    protected List<JAXBElement<?>> content;

    /**
     * Ruft das restliche Contentmodell ab. 
     * 
     * <p>
     * Sie rufen diese "catch-all"-Eigenschaft aus folgendem Grund ab: 
     * Der Feldname "UnitXMLList" wird von zwei verschiedenen Teilen eines Schemas verwendet. Siehe: 
     * Zeile 942 von file:/C:/Users/eljaoua01/Downloads/xcd/src/main/xsd/SI_Format.xsd
     * Zeile 936 von file:/C:/Users/eljaoua01/Downloads/xcd/src/main/xsd/SI_Format.xsd
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
     * {@link JAXBElement }{@code <}{@link List }{@code <}{@link String }{@code >}{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link List }{@code <}{@link Double }{@code >}{@code >}
     * {@link JAXBElement }{@code <}{@link List }{@code <}{@link Double }{@code >}{@code >}
     * {@link JAXBElement }{@code <}{@link List }{@code <}{@link String }{@code >}{@code >}
     * {@link JAXBElement }{@code <}{@link List }{@code <}{@link Double }{@code >}{@code >}
     * {@link JAXBElement }{@code <}{@link List }{@code <}{@link Double }{@code >}{@code >}
     * {@link JAXBElement }{@code <}{@link List }{@code <}{@link String }{@code >}{@code >}
     * {@link JAXBElement }{@code <}{@link List }{@code <}{@link XMLGregorianCalendar }{@code >}{@code >}
     * {@link JAXBElement }{@code <}{@link MeasurementUncertaintyBivariateXMLListType }{@code >}
     * {@link JAXBElement }{@code <}{@link MeasurementUncertaintyMultivariateXMLListType }{@code >}
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

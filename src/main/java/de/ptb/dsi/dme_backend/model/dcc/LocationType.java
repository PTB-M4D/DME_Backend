//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2024.11.29 um 02:25:21 PM CET 
//


package de.ptb.dsi.dme_backend.model.dcc;


import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlElementRefs;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java-Klasse für locationType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="locationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice maxOccurs="unbounded"&gt;
 *         &lt;element name="city" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="countryCode" type="{https://ptb.de/dcc}stringISO3166Type"/&gt;
 *         &lt;element name="postCode" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="postOfficeBox" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="state" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="street" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="streetNo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="further" type="{https://ptb.de/dcc}richContentType"/&gt;
 *         &lt;element name="positionCoordinates" type="{https://ptb.de/dcc}positionCoordinatesType"/&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)

public class LocationType {

    @XmlElementRefs({
        @XmlElementRef(name = "city", namespace = "https://ptb.de/dcc", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "countryCode", namespace = "https://ptb.de/dcc", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "postCode", namespace = "https://ptb.de/dcc", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "postOfficeBox", namespace = "https://ptb.de/dcc", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "state", namespace = "https://ptb.de/dcc", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "street", namespace = "https://ptb.de/dcc", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "streetNo", namespace = "https://ptb.de/dcc", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "further", namespace = "https://ptb.de/dcc", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "positionCoordinates", namespace = "https://ptb.de/dcc", type = JAXBElement.class, required = false)
    })
    protected List<JAXBElement<?>> cityOrCountryCodeOrPostCode;

    /**
     * Gets the value of the cityOrCountryCodeOrPostCode property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cityOrCountryCodeOrPostCode property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCityOrCountryCodeOrPostCode().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link RichContentType }{@code >}
     * {@link JAXBElement }{@code <}{@link PositionCoordinatesType }{@code >}
     * 
     * 
     */
    public List<JAXBElement<?>> getCityOrCountryCodeOrPostCode() {
        if (cityOrCountryCodeOrPostCode == null) {
            cityOrCountryCodeOrPostCode = new ArrayList<JAXBElement<?>>();
        }
        return this.cityOrCountryCodeOrPostCode;
    }

}

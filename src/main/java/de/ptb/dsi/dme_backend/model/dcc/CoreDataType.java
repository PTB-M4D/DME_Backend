//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2024.11.29 um 02:25:21 PM CET 
//


package de.ptb.dsi.dme_backend.model.dcc;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.ArrayList;
import java.util.List;


/**
 * 
 *         Important metadata for the DCC containing the global unique identifier and other identifications.
 *       
 * 
 * <p>Java-Klasse für coreDataType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="coreDataType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="countryCodeISO3166_1" type="{https://ptb.de/dcc}stringISO3166Type"/&gt;
 *         &lt;element name="usedLangCodeISO639_1" type="{https://ptb.de/dcc}stringISO639Type" maxOccurs="unbounded"/&gt;
 *         &lt;element name="mandatoryLangCodeISO639_1" type="{https://ptb.de/dcc}stringISO639Type" maxOccurs="unbounded"/&gt;
 *         &lt;element name="uniqueIdentifier" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="identifications" type="{https://ptb.de/dcc}identificationListType" minOccurs="0"/&gt;
 *         &lt;element name="receiptDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *         &lt;element name="beginPerformanceDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="endPerformanceDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="performanceLocation" type="{https://ptb.de/dcc}performanceLocationType"/&gt;
 *         &lt;element name="previousReport" type="{https://ptb.de/dcc}hashType" minOccurs="0"/&gt;
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
@Builder
@AllArgsConstructor
public class CoreDataType {

    @XmlElement(name = "countryCodeISO3166_1", required = true)
    protected String countryCodeISO31661;
    @XmlElement(name = "usedLangCodeISO639_1", required = true)
    protected List<String> usedLangCodeISO6391;
    @XmlElement(name = "mandatoryLangCodeISO639_1", required = true)
    protected List<String> mandatoryLangCodeISO6391;
    @XmlElement(required = true)
    protected String uniqueIdentifier;
    protected IdentificationListType identifications;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar receiptDate;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar beginPerformanceDate;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar endPerformanceDate;
    @XmlElement(required = true)
    protected PerformanceLocationType performanceLocation;
    protected HashType previousReport;

    public CoreDataType() {

    }

    /**
     * Ruft den Wert der countryCodeISO31661-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountryCodeISO31661() {
        return countryCodeISO31661;
    }

    /**
     * Legt den Wert der countryCodeISO31661-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountryCodeISO31661(String value) {
        this.countryCodeISO31661 = value;
    }

    /**
     * Gets the value of the usedLangCodeISO6391 property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the usedLangCodeISO6391 property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUsedLangCodeISO6391().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getUsedLangCodeISO6391() {
        if (usedLangCodeISO6391 == null) {
            usedLangCodeISO6391 = new ArrayList<String>();
        }
        return this.usedLangCodeISO6391;
    }

    /**
     * Gets the value of the mandatoryLangCodeISO6391 property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the mandatoryLangCodeISO6391 property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMandatoryLangCodeISO6391().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getMandatoryLangCodeISO6391() {
        if (mandatoryLangCodeISO6391 == null) {
            mandatoryLangCodeISO6391 = new ArrayList<String>();
        }
        return this.mandatoryLangCodeISO6391;
    }

    /**
     * Ruft den Wert der uniqueIdentifier-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUniqueIdentifier() {
        return uniqueIdentifier;
    }

    /**
     * Legt den Wert der uniqueIdentifier-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUniqueIdentifier(String value) {
        this.uniqueIdentifier = value;
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
     * Ruft den Wert der receiptDate-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getReceiptDate() {
        return receiptDate;
    }

    /**
     * Legt den Wert der receiptDate-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setReceiptDate(XMLGregorianCalendar value) {
        this.receiptDate = value;
    }

    /**
     * Ruft den Wert der beginPerformanceDate-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getBeginPerformanceDate() {
        return beginPerformanceDate;
    }

    /**
     * Legt den Wert der beginPerformanceDate-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setBeginPerformanceDate(XMLGregorianCalendar value) {
        this.beginPerformanceDate = value;
    }

    /**
     * Ruft den Wert der endPerformanceDate-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEndPerformanceDate() {
        return endPerformanceDate;
    }

    /**
     * Legt den Wert der endPerformanceDate-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEndPerformanceDate(XMLGregorianCalendar value) {
        this.endPerformanceDate = value;
    }

    /**
     * Ruft den Wert der performanceLocation-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PerformanceLocationType }
     *     
     */
    public PerformanceLocationType getPerformanceLocation() {
        return performanceLocation;
    }

    /**
     * Legt den Wert der performanceLocation-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PerformanceLocationType }
     *     
     */
    public void setPerformanceLocation(PerformanceLocationType value) {
        this.performanceLocation = value;
    }

    /**
     * Ruft den Wert der previousReport-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link HashType }
     *     
     */
    public HashType getPreviousReport() {
        return previousReport;
    }

    /**
     * Legt den Wert der previousReport-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link HashType }
     *     
     */
    public void setPreviousReport(HashType value) {
        this.previousReport = value;
    }

}

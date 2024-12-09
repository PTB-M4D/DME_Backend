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
import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>Java-Klasse für statementMetaDataType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="statementMetaDataType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="countryCodeISO3166_1" type="{https://ptb.de/dcc}stringISO3166Type" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="convention" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="traceable" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="norm" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="reference" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="declaration" type="{https://ptb.de/dcc}richContentType" minOccurs="0"/&gt;
 *         &lt;element name="valid" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="date" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *         &lt;element name="period" type="{http://www.w3.org/2001/XMLSchema}duration" minOccurs="0"/&gt;
 *         &lt;element name="respAuthority" type="{https://ptb.de/dcc}contactType" minOccurs="0"/&gt;
 *         &lt;choice minOccurs="0"&gt;
 *           &lt;element name="conformity" type="{https://ptb.de/dcc}stringConformityStatementStatusType"/&gt;
 *           &lt;element name="conformityXMLList" type="{https://ptb.de/dcc}stringConformityStatementStatusXMLListType"/&gt;
 *         &lt;/choice&gt;
 *         &lt;element name="data" type="{https://ptb.de/dcc}dataType" minOccurs="0"/&gt;
 *         &lt;element name="nonSIDefinition" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="nonSIUnit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="location" type="{https://ptb.de/dcc}locationType" minOccurs="0"/&gt;
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
@XmlType(name = "statementMetaDataType", propOrder = {
    "countryCodeISO31661",
    "convention",
    "traceable",
    "norm",
    "reference",
    "declaration",
    "valid",
    "date",
    "period",
    "respAuthority",
    "conformity",
    "conformityXMLList",
    "data",
    "nonSIDefinition",
    "nonSIUnit",
    "location"
})
public class StatementMetaDataType {

    @XmlElement(name = "countryCodeISO3166_1")
    protected List<String> countryCodeISO31661;
    protected String convention;
    protected Boolean traceable;
    protected List<String> norm;
    protected List<String> reference;
    protected RichContentType declaration;
    protected Boolean valid;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar date;
    protected Duration period;
    protected ContactType respAuthority;
    @XmlSchemaType(name = "string")
    protected StringConformityStatementStatusType conformity;
    @XmlList
    protected List<StringConformityStatementStatusType> conformityXMLList;
    protected DataType data;
    protected String nonSIDefinition;
    protected String nonSIUnit;
    protected LocationType location;
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
     * Gets the value of the countryCodeISO31661 property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the countryCodeISO31661 property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCountryCodeISO31661().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getCountryCodeISO31661() {
        if (countryCodeISO31661 == null) {
            countryCodeISO31661 = new ArrayList<String>();
        }
        return this.countryCodeISO31661;
    }

    /**
     * Ruft den Wert der convention-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConvention() {
        return convention;
    }

    /**
     * Legt den Wert der convention-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConvention(String value) {
        this.convention = value;
    }

    /**
     * Ruft den Wert der traceable-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isTraceable() {
        return traceable;
    }

    /**
     * Legt den Wert der traceable-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setTraceable(Boolean value) {
        this.traceable = value;
    }

    /**
     * Gets the value of the norm property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the norm property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNorm().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getNorm() {
        if (norm == null) {
            norm = new ArrayList<String>();
        }
        return this.norm;
    }

    /**
     * Gets the value of the reference property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the reference property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReference().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getReference() {
        if (reference == null) {
            reference = new ArrayList<String>();
        }
        return this.reference;
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
     * Ruft den Wert der valid-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isValid() {
        return valid;
    }

    /**
     * Legt den Wert der valid-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setValid(Boolean value) {
        this.valid = value;
    }

    /**
     * Ruft den Wert der date-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDate() {
        return date;
    }

    /**
     * Legt den Wert der date-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDate(XMLGregorianCalendar value) {
        this.date = value;
    }

    /**
     * Ruft den Wert der period-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Duration }
     *     
     */
    public Duration getPeriod() {
        return period;
    }

    /**
     * Legt den Wert der period-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Duration }
     *     
     */
    public void setPeriod(Duration value) {
        this.period = value;
    }

    /**
     * Ruft den Wert der respAuthority-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ContactType }
     *     
     */
    public ContactType getRespAuthority() {
        return respAuthority;
    }

    /**
     * Legt den Wert der respAuthority-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ContactType }
     *     
     */
    public void setRespAuthority(ContactType value) {
        this.respAuthority = value;
    }

    /**
     * Ruft den Wert der conformity-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link StringConformityStatementStatusType }
     *     
     */
    public StringConformityStatementStatusType getConformity() {
        return conformity;
    }

    /**
     * Legt den Wert der conformity-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link StringConformityStatementStatusType }
     *     
     */
    public void setConformity(StringConformityStatementStatusType value) {
        this.conformity = value;
    }

    /**
     * Gets the value of the conformityXMLList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the conformityXMLList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConformityXMLList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StringConformityStatementStatusType }
     * 
     * 
     */
    public List<StringConformityStatementStatusType> getConformityXMLList() {
        if (conformityXMLList == null) {
            conformityXMLList = new ArrayList<StringConformityStatementStatusType>();
        }
        return this.conformityXMLList;
    }

    /**
     * Ruft den Wert der data-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DataType }
     *     
     */
    public DataType getData() {
        return data;
    }

    /**
     * Legt den Wert der data-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DataType }
     *     
     */
    public void setData(DataType value) {
        this.data = value;
    }

    /**
     * Ruft den Wert der nonSIDefinition-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNonSIDefinition() {
        return nonSIDefinition;
    }

    /**
     * Legt den Wert der nonSIDefinition-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNonSIDefinition(String value) {
        this.nonSIDefinition = value;
    }

    /**
     * Ruft den Wert der nonSIUnit-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNonSIUnit() {
        return nonSIUnit;
    }

    /**
     * Legt den Wert der nonSIUnit-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNonSIUnit(String value) {
        this.nonSIUnit = value;
    }

    /**
     * Ruft den Wert der location-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link LocationType }
     *     
     */
    public LocationType getLocation() {
        return location;
    }

    /**
     * Legt den Wert der location-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link LocationType }
     *     
     */
    public void setLocation(LocationType value) {
        this.location = value;
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

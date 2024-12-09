//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2024.11.29 um 02:25:21 PM CET 
//


package de.ptb.dsi.dme_backend.model.dcc;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>Java-Klasse für hashType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="hashType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="referral" type="{https://ptb.de/dcc}textType"/&gt;
 *         &lt;element name="referralID" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="procedure" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="linkedReport" type="{https://ptb.de/dcc}hashType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}ID" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "hashType", propOrder = {
    "referral",
    "referralID",
    "procedure",
    "value",
    "linkedReport"
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HashType {

    @XmlElement(required = true)
    protected TextType referral;
    @XmlElement(required = true)
    protected String referralID;
    @XmlElement(required = true)
    protected String procedure;
    @XmlElement(required = true)
    protected String value;
    protected HashType linkedReport;
    @XmlAttribute(name = "id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;

    /**
     * Ruft den Wert der referral-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getReferral() {
        return referral;
    }

    /**
     * Legt den Wert der referral-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setReferral(TextType value) {
        this.referral = value;
    }

    /**
     * Ruft den Wert der referralID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReferralID() {
        return referralID;
    }

    /**
     * Legt den Wert der referralID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReferralID(String value) {
        this.referralID = value;
    }

    /**
     * Ruft den Wert der procedure-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProcedure() {
        return procedure;
    }

    /**
     * Legt den Wert der procedure-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProcedure(String value) {
        this.procedure = value;
    }

    /**
     * Ruft den Wert der value-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Legt den Wert der value-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Ruft den Wert der linkedReport-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link HashType }
     *     
     */
    public HashType getLinkedReport() {
        return linkedReport;
    }

    /**
     * Legt den Wert der linkedReport-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link HashType }
     *     
     */
    public void setLinkedReport(HashType value) {
        this.linkedReport = value;
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

}

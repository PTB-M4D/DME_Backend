//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2024.11.29 um 02:25:21 PM CET 
//


package de.ptb.dsi.dme_backend.model.dcc;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlType;

/**
 * 
 *         The root element that contains the four rings of the DCC.
 *       
 * 
 * <p>Java-Klasse für digitalCalibrationCertificateType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="digitalCalibrationCertificateType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="administrativeData" type="{https://ptb.de/dcc}administrativeDataType"/&gt;
 *         &lt;element name="measurementResults" type="{https://ptb.de/dcc}measurementResultListType"/&gt;
 *         &lt;element name="comment" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;any maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="document" type="{https://ptb.de/dcc}byteDataType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="schemaVersion" use="required"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;pattern value="3\.1\.2"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "digitalCalibrationCertificateType", propOrder = {
    "administrativeData",
    "measurementResults",
    "comment",
    "document"
})
@XmlRootElement(name = "DigitalCalibrationCertificate", namespace = "https://ptb.de/dcc"
       )
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DigitalCalibrationCertificateType {

    @XmlElement(required = true , namespace = "https://ptb.de/si")

    protected AdministrativeDataType administrativeData;
    @XmlElement(required = true)
    protected MeasurementResultListType measurementResults;
    protected Comment comment;
    protected ByteDataType document;
    @XmlAttribute(name = "schemaVersion")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String schemaVersion;

    /**
     * Ruft den Wert der administrativeData-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link AdministrativeDataType }
     *     
     */
    public AdministrativeDataType getAdministrativeData() {
        return administrativeData;
    }

    /**
     * Legt den Wert der administrativeData-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link AdministrativeDataType }
     *     
     */
    public void setAdministrativeData(AdministrativeDataType value) {
        this.administrativeData = value;
    }

    /**
     * Ruft den Wert der measurementResults-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MeasurementResultListType }
     *     
     */
    public MeasurementResultListType getMeasurementResults() {
        return measurementResults;
    }

    /**
     * Legt den Wert der measurementResults-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MeasurementResultListType }
     *     
     */
    public void setMeasurementResults(MeasurementResultListType value) {
        this.measurementResults = value;
    }

    /**
     * Ruft den Wert der comment-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Comment }
     *     
     */
    public Comment getComment() {
        return comment;
    }

    /**
     * Legt den Wert der comment-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Comment }
     *     
     */
    public void setComment(Comment value) {
        this.comment = value;
    }

    /**
     * Ruft den Wert der document-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ByteDataType }
     *     
     */
    public ByteDataType getDocument() {
        return document;
    }

    /**
     * Legt den Wert der document-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ByteDataType }
     *     
     */
    public void setDocument(ByteDataType value) {
        this.document = value;
    }

    /**
     * Ruft den Wert der schemaVersion-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */


    public String getSchemaVersion() {
        return schemaVersion;
    }

    /**
     * Legt den Wert der schemaVersion-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */

    public void setSchemaVersion(String value) {
        this.schemaVersion = value;
    }


    /**
     * <p>Java-Klasse für anonymous complex type.
     * 
     * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;any maxOccurs="unbounded" minOccurs="0"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "any"
    })
    public static class Comment {

        @XmlAnyElement(lax = true)
        protected List<Object> any;

        /**
         * Gets the value of the any property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the any property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAny().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Object }
         * 
         * 
         */
        public List<Object> getAny() {
            if (any == null) {
                any = new ArrayList<Object>();
            }
            return this.any;
        }

    }


}

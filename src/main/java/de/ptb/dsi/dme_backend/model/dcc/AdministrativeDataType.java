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
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.xml.bind.annotation.XmlElement;


/**
 * 
 *         The element administrativeData contains all essential administrative information about the calibration.
 *         The entries in this area are basically the same and regulated in all DCCs.
 *       
 * 
 * <p>Java-Klasse für administrativeDataType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="administrativeDataType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="dccSoftware" type="{https://ptb.de/dcc}softwareListType"/&gt;
 *         &lt;element name="coreData" type="{https://ptb.de/dcc}coreDataType"/&gt;
 *         &lt;element name="items" type="{https://ptb.de/dcc}itemListType"/&gt;
 *         &lt;element name="calibrationLaboratory" type="{https://ptb.de/dcc}calibrationLaboratoryType"/&gt;
 *         &lt;element name="respPersons" type="{https://ptb.de/dcc}respPersonListType"/&gt;
 *         &lt;element name="customer" type="{https://ptb.de/dcc}contactType"/&gt;
 *         &lt;element name="statements" type="{https://ptb.de/dcc}statementListType" minOccurs="0"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlRootElement
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdministrativeDataType {

    @XmlElement(required = true)
    protected SoftwareListType dccSoftware;
    @XmlElement(required = true)
    protected CoreDataType coreData;
    @XmlElement(required = true)
    protected ItemListType items;
    @XmlElement(required = true)
    protected CalibrationLaboratory calibrationLaboratory;
    @XmlElement(required = true)
    protected RespPersonListType respPersons;
    @XmlElement(required = true)
    protected ContactType customer;
    protected StatementListType statements;

    /**
     * Ruft den Wert der dccSoftware-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SoftwareListType }
     *     
     */
    public SoftwareListType getDccSoftware() {
        return dccSoftware;
    }

    /**
     * Legt den Wert der dccSoftware-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SoftwareListType }
     *     
     */
    public void setDccSoftware(SoftwareListType value) {
        this.dccSoftware = value;
    }

    /**
     * Ruft den Wert der coreData-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CoreDataType }
     *     
     */
    public CoreDataType getCoreData() {
        return coreData;
    }

    /**
     * Legt den Wert der coreData-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CoreDataType }
     *     
     */
    public void setCoreData(CoreDataType value) {
        this.coreData = value;
    }

    /**
     * Ruft den Wert der items-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ItemListType }
     *     
     */
    public ItemListType getItems() {
        return items;
    }

    /**
     * Legt den Wert der items-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ItemListType }
     *     
     */
    public void setItems(ItemListType value) {
        this.items = value;
    }

    /**
     * Ruft den Wert der calibrationLaboratory-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CalibrationLaboratory }
     *     
     */
    public CalibrationLaboratory getCalibrationLaboratory() {
        return calibrationLaboratory;
    }

    /**
     * Legt den Wert der calibrationLaboratory-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CalibrationLaboratory }
     *     
     */
    public void setCalibrationLaboratory(CalibrationLaboratory value) {
        this.calibrationLaboratory = value;
    }

    /**
     * Ruft den Wert der respPersons-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link RespPersonListType }
     *     
     */
    public RespPersonListType getRespPersons() {
        return respPersons;
    }

    /**
     * Legt den Wert der respPersons-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link RespPersonListType }
     *     
     */
    public void setRespPersons(RespPersonListType value) {
        this.respPersons = value;
    }

    /**
     * Ruft den Wert der customer-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ContactType }
     *     
     */
    public ContactType getCustomer() {
        return customer;
    }

    /**
     * Legt den Wert der customer-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ContactType }
     *     
     */
    public void setCustomer(ContactType value) {
        this.customer = value;
    }

    /**
     * Ruft den Wert der statements-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link StatementListType }
     *     
     */
    public StatementListType getStatements() {
        return statements;
    }

    /**
     * Legt den Wert der statements-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link StatementListType }
     *     
     */
    public void setStatements(StatementListType value) {
        this.statements = value;
    }

}

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

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.ArrayList;
import java.util.List;


/**
 * 
 *         This data block is used to add formulas and equations to the measurement result section of the DCC.
 *       
 * 
 * <p>Java-Klasse für formulaType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="formulaType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice&gt;
 *         &lt;element name="latex" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="mathml" type="{https://ptb.de/dcc}xmlType"/&gt;
 *       &lt;/choice&gt;
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

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FormulaType {

    protected String latex;
    protected XmlType mathml;
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
     * Ruft den Wert der latex-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLatex() {
        return latex;
    }

    /**
     * Legt den Wert der latex-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLatex(String value) {
        this.latex = value;
    }

    /**
     * Ruft den Wert der mathml-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link XmlType }
     *     
     */
    public XmlType getMathml() {
        return mathml;
    }

    /**
     * Legt den Wert der mathml-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link XmlType }
     *     
     */
    public void setMathml(XmlType value) {
        this.mathml = value;
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

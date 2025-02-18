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

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java-Klasse für hybridType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="hybridType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;choice&gt;
 *           &lt;element name="real" type="{https://ptb.de/si}realQuantityType" maxOccurs="unbounded"/&gt;
 *           &lt;element name="complex" type="{https://ptb.de/si}complexQuantityType" maxOccurs="unbounded"/&gt;
 *           &lt;element name="list" type="{https://ptb.de/si}listType" maxOccurs="unbounded"/&gt;
 *           &lt;element name="realList" type="{https://ptb.de/si}realListType" maxOccurs="unbounded"/&gt;
 *           &lt;element name="realListXMLList" type="{https://ptb.de/si}realListXMLListType" maxOccurs="unbounded"/&gt;
 *           &lt;element name="complexList" type="{https://ptb.de/si}complexListType" maxOccurs="unbounded"/&gt;
 *           &lt;element name="complexListXMLList" type="{https://ptb.de/si}complexListXMLListType" maxOccurs="unbounded"/&gt;
 *           &lt;element name="constant" type="{https://ptb.de/si}constantQuantityType" maxOccurs="unbounded"/&gt;
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

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HybridType {

    protected List<RealQuantityType> real;
    protected List<ComplexQuantityType> complex;
    protected List<ListType> list;
    protected List<RealListType> realList;
    protected List<RealListXMLListType> realListXMLList;
    protected List<ComplexListType> complexList;
    protected List<ComplexListXMLListType> complexListXMLList;
    protected List<ConstantQuantityType> constant;

    /**
     * Gets the value of the real property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the real property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReal().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RealQuantityType }
     * 
     * 
     */
    public List<RealQuantityType> getReal() {
        if (real == null) {
            real = new ArrayList<RealQuantityType>();
        }
        return this.real;
    }

    /**
     * Gets the value of the complex property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the complex property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getComplex().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ComplexQuantityType }
     * 
     * 
     */
    public List<ComplexQuantityType> getComplex() {
        if (complex == null) {
            complex = new ArrayList<ComplexQuantityType>();
        }
        return this.complex;
    }

    /**
     * Gets the value of the list property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the list property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ListType }
     * 
     * 
     */
    public List<ListType> getList() {
        if (list == null) {
            list = new ArrayList<ListType>();
        }
        return this.list;
    }

    /**
     * Gets the value of the realList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the realList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRealList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RealListType }
     * 
     * 
     */
    public List<RealListType> getRealList() {
        if (realList == null) {
            realList = new ArrayList<RealListType>();
        }
        return this.realList;
    }

    /**
     * Gets the value of the realListXMLList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the realListXMLList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRealListXMLList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RealListXMLListType }
     * 
     * 
     */
    public List<RealListXMLListType> getRealListXMLList() {
        if (realListXMLList == null) {
            realListXMLList = new ArrayList<RealListXMLListType>();
        }
        return this.realListXMLList;
    }

    /**
     * Gets the value of the complexList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the complexList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getComplexList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ComplexListType }
     * 
     * 
     */
    public List<ComplexListType> getComplexList() {
        if (complexList == null) {
            complexList = new ArrayList<ComplexListType>();
        }
        return this.complexList;
    }

    /**
     * Gets the value of the complexListXMLList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the complexListXMLList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getComplexListXMLList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ComplexListXMLListType }
     * 
     * 
     */
    public List<ComplexListXMLListType> getComplexListXMLList() {
        if (complexListXMLList == null) {
            complexListXMLList = new ArrayList<ComplexListXMLListType>();
        }
        return this.complexListXMLList;
    }

    /**
     * Gets the value of the constant property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the constant property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConstant().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ConstantQuantityType }
     * 
     * 
     */
    public List<ConstantQuantityType> getConstant() {
        if (constant == null) {
            constant = new ArrayList<ConstantQuantityType>();
        }
        return this.constant;
    }

}

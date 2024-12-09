//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2024.11.29 um 02:25:21 PM CET 
//


package de.ptb.dsi.dme_backend.model.dcc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlList;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlType;

/**
 * Definition of standard measurement uncertainty data.
 * 
 * <p>Java-Klasse für standardMUXMLListType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="standardMUXMLListType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="valueStandardMUXMLList" type="{https://ptb.de/si}valueStandardMUXMLListType"/&gt;
 *         &lt;element name="distributionXMLList" type="{https://ptb.de/si}distributionXMLListType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "standardMUXMLListType", namespace = "https://ptb.de/si", propOrder = {
    "valueStandardMUXMLList",
    "distributionXMLList"
})
public class StandardMUXMLListType {

    @XmlList
    @XmlElement(type = Double.class)
    protected List<Double> valueStandardMUXMLList;
    @XmlList
    protected List<String> distributionXMLList;

    /**
     * Gets the value of the valueStandardMUXMLList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the valueStandardMUXMLList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getValueStandardMUXMLList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Double }
     * 
     * 
     */
    public List<Double> getValueStandardMUXMLList() {
        if (valueStandardMUXMLList == null) {
            valueStandardMUXMLList = new ArrayList<Double>();
        }
        return this.valueStandardMUXMLList;
    }

    /**
     * Gets the value of the distributionXMLList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the distributionXMLList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDistributionXMLList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getDistributionXMLList() {
        if (distributionXMLList == null) {
            distributionXMLList = new ArrayList<String>();
        }
        return this.distributionXMLList;
    }

}

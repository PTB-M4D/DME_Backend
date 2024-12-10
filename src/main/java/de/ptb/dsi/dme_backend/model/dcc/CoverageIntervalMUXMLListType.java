//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2024.11.29 um 02:25:21 PM CET 
//


package de.ptb.dsi.dme_backend.model.dcc;

import lombok.Data;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlList;
import java.util.ArrayList;
import java.util.List;



/**
 * Definition of coverage interval measurement uncertainty data.
 * 
 * <p>Java-Klasse für coverageIntervalMUXMLListType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="coverageIntervalMUXMLListType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="valueStandardMUXMLList" type="{https://ptb.de/si}valueStandardMUXMLListType"/&gt;
 *         &lt;element name="intervalMinXMLList" type="{https://ptb.de/si}intervalMinXMLListType"/&gt;
 *         &lt;element name="intervalMaxXMLList" type="{https://ptb.de/si}intervalMaxXMLListType"/&gt;
 *         &lt;element name="coverageProbabilityXMLList" type="{https://ptb.de/si}probabilityValueXMLListType"/&gt;
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

@Data
public class CoverageIntervalMUXMLListType {

    @XmlList
    @XmlElement(type = Double.class)
    protected List<Double> valueStandardMUXMLList;
    @XmlList
    @XmlElement(type = Double.class)
    protected List<Double> intervalMinXMLList;
    @XmlList
    @XmlElement(type = Double.class)
    protected List<Double> intervalMaxXMLList;
    @XmlList
    @XmlElement(type = Double.class)
    protected List<Double> coverageProbabilityXMLList;
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
     * Gets the value of the intervalMinXMLList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the intervalMinXMLList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIntervalMinXMLList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Double }
     * 
     * 
     */
    public List<Double> getIntervalMinXMLList() {
        if (intervalMinXMLList == null) {
            intervalMinXMLList = new ArrayList<Double>();
        }
        return this.intervalMinXMLList;
    }

    /**
     * Gets the value of the intervalMaxXMLList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the intervalMaxXMLList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIntervalMaxXMLList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Double }
     * 
     * 
     */
    public List<Double> getIntervalMaxXMLList() {
        if (intervalMaxXMLList == null) {
            intervalMaxXMLList = new ArrayList<Double>();
        }
        return this.intervalMaxXMLList;
    }

    /**
     * Gets the value of the coverageProbabilityXMLList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the coverageProbabilityXMLList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCoverageProbabilityXMLList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Double }
     * 
     * 
     */
    public List<Double> getCoverageProbabilityXMLList() {
        if (coverageProbabilityXMLList == null) {
            coverageProbabilityXMLList = new ArrayList<Double>();
        }
        return this.coverageProbabilityXMLList;
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

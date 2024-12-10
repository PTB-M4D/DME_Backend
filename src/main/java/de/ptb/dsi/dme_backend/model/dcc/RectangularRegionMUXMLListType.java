//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2024.11.29 um 02:25:21 PM CET 
//


package de.ptb.dsi.dme_backend.model.dcc;


import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlList;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java-Klasse für rectangularRegionMUXMLListType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="rectangularRegionMUXMLListType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="covarianceMatrixXMLList" type="{https://ptb.de/si}covarianceMatrixXMLListType"/&gt;
 *         &lt;element name="coverageFactorXMLList" type="{https://ptb.de/si}kValueXMLListType"/&gt;
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

public class RectangularRegionMUXMLListType {

    @XmlElement(required = true)
    protected CovarianceMatrixXMLListType covarianceMatrixXMLList;
    @XmlList
    @XmlElement(type = Double.class)
    protected List<Double> coverageFactorXMLList;
    @XmlList
    @XmlElement(type = Double.class)
    protected List<Double> coverageProbabilityXMLList;
    @XmlList
    protected List<String> distributionXMLList;

    /**
     * Ruft den Wert der covarianceMatrixXMLList-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CovarianceMatrixXMLListType }
     *     
     */
    public CovarianceMatrixXMLListType getCovarianceMatrixXMLList() {
        return covarianceMatrixXMLList;
    }

    /**
     * Legt den Wert der covarianceMatrixXMLList-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CovarianceMatrixXMLListType }
     *     
     */
    public void setCovarianceMatrixXMLList(CovarianceMatrixXMLListType value) {
        this.covarianceMatrixXMLList = value;
    }

    /**
     * Gets the value of the coverageFactorXMLList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the coverageFactorXMLList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCoverageFactorXMLList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Double }
     * 
     * 
     */
    public List<Double> getCoverageFactorXMLList() {
        if (coverageFactorXMLList == null) {
            coverageFactorXMLList = new ArrayList<Double>();
        }
        return this.coverageFactorXMLList;
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

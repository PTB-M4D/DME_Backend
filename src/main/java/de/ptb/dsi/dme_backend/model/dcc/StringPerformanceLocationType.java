//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2024.11.29 um 02:25:21 PM CET 
//


package de.ptb.dsi.dme_backend.model.dcc;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;


/**
 * <p>Java-Klasse für stringPerformanceLocationType.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="stringPerformanceLocationType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="laboratory"/&gt;
 *     &lt;enumeration value="customer"/&gt;
 *     &lt;enumeration value="laboratoryBranch"/&gt;
 *     &lt;enumeration value="customerBranch"/&gt;
 *     &lt;enumeration value="other"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */

@XmlEnum
public enum StringPerformanceLocationType {

    @XmlEnumValue("laboratory")
    LABORATORY("laboratory"),
    @XmlEnumValue("customer")
    CUSTOMER("customer"),
    @XmlEnumValue("laboratoryBranch")
    LABORATORY_BRANCH("laboratoryBranch"),
    @XmlEnumValue("customerBranch")
    CUSTOMER_BRANCH("customerBranch"),
    @XmlEnumValue("other")
    OTHER("other");
    private final String value;

    StringPerformanceLocationType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static StringPerformanceLocationType fromValue(String v) {
        for (StringPerformanceLocationType c: StringPerformanceLocationType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}

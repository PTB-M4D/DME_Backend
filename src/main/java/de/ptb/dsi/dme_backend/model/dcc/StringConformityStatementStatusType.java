//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2024.11.29 um 02:25:21 PM CET 
//


package de.ptb.dsi.dme_backend.model.dcc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;


/**
 * <p>Java-Klasse für stringConformityStatementStatusType.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="stringConformityStatementStatusType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="pass"/&gt;
 *     &lt;enumeration value="fail"/&gt;
 *     &lt;enumeration value="conditionalPass"/&gt;
 *     &lt;enumeration value="conditionalFail"/&gt;
 *     &lt;enumeration value="noPass"/&gt;
 *     &lt;enumeration value="noFail"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */

@XmlEnum
public enum StringConformityStatementStatusType {

    @XmlEnumValue("pass")
    PASS("pass"),
    @XmlEnumValue("fail")
    FAIL("fail"),
    @XmlEnumValue("conditionalPass")
    CONDITIONAL_PASS("conditionalPass"),
    @XmlEnumValue("conditionalFail")
    CONDITIONAL_FAIL("conditionalFail"),
    @XmlEnumValue("noPass")
    NO_PASS("noPass"),
    @XmlEnumValue("noFail")
    NO_FAIL("noFail");
    private final String value;

    StringConformityStatementStatusType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static StringConformityStatementStatusType fromValue(String v) {
        for (StringConformityStatementStatusType c: StringConformityStatementStatusType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}

package de.ptb.dsi.dme_backend.model.dsi;



import jakarta.xml.bind.annotation.*;

import lombok.*;



@Data@AllArgsConstructor@NoArgsConstructor
@XmlRootElement(name = "dcc")
@XmlAccessorType(XmlAccessType.FIELD)
public class Test {

    @XmlAttribute(name = "bb")
    private String schemaVersion;

    @XmlElement(name = "cc", required = true)
    protected String model;

}

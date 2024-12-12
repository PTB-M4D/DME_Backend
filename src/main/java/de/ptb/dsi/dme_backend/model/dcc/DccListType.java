package de.ptb.dsi.dme_backend.model.dcc;

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

//<xs:complexType name="listType">
//        <xs:annotation>
//            <xs:documentation>
//The 'list' element allows to define a collection of measurement results
//which are subject to structures with integrity. Basic structures are
//vector quantities. A recursive usage of 'list' allows the creation of
//matrix and tensor structures as well as structures of higher dimension. The 'list'
//may also be used to give measurement results in combination with some
//ambient conditions at the measurement.
//            </xs:documentation>
//        </xs:annotation>
//        <xs:sequence>
//            <xs:element name="name" type="dcc:textType" minOccurs="0"/>
//            <xs:element name="description" type="dcc:richContentType" minOccurs="0"/>
//            <xs:choice>
//                <xs:element name="dateTime" type="xs:dateTime" minOccurs="0"/>
//                <xs:element name="dateTimeXMLList" type="dcc:dateTimeXMLListType" minOccurs="0"/>
//            </xs:choice>
//            <xs:choice maxOccurs="unbounded">
//                <xs:element name="list" type="dcc:listType"/>
//                <xs:element name="quantity" type="dcc:quantityType"/>
//            </xs:choice>
//            <xs:element name="usedMethods" type="dcc:usedMethodListType" minOccurs="0"/>
//            <xs:element name="usedSoftware" type="dcc:softwareListType" minOccurs="0"/>
//            <xs:element name="measuringEquipments" type="dcc:measuringEquipmentListType" minOccurs="0"/>
//            <xs:element name="influenceConditions" type="dcc:influenceConditionListType" minOccurs="0"/>
//            <xs:element name="measurementMetaData" type="dcc:measurementMetaDataListType" minOccurs="0"/>
//        </xs:sequence>
//        <xs:attribute name="id" type="xs:ID" use="optional"/>
//        <xs:attribute name="refId" type="xs:IDREFS" use="optional"/>
//        <xs:attribute name="refType" type="dcc:refTypesType" use="optional"/>
//    </xs:complexType>


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "quantityType", propOrder = {
        "name",
        "description",
//        "dateTime",
//        "dateTimeXMLList",
        "list",
        "quantity",
        "usedMethods",
        "usedSoftware",
        "measuringEquipments",
        "influenceConditions",
        "measurementMetaData"
})
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class DccListType {
    protected TextType name;
    protected RichContentType description;

    @XmlElement(namespace = "https://ptb.de/dcc")
    protected List<DccListType> list;

    @XmlElement(namespace = "https://ptb.de/dcc")
    protected List<QuantityType> quantitiy;

    protected RelativeUncertaintyType relativeUncertainty;
    protected UsedMethodListType usedMethods;
    protected SoftwareListType usedSoftware;
    protected MeasuringEquipmentListType measuringEquipments;
    protected InfluenceConditionListType influenceConditions;
    protected MeasurementMetaDataListType measurementMetaData;
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

    public TextType getName() {
        return name;
    }
    public void setName(TextType value) {
        this.name = value;
    }


    public RichContentType getDescription() {
        return description;
    }
    public void setDescription(RichContentType value) {
        this.description = value;
    }

    public List<DccListType> getList() {
        if (list == null) {
            list = new ArrayList<DccListType>();
        }
        return this.list;
    }

    public List<QuantityType> getQuantity() {
        if (quantitiy == null) {
            quantitiy = new ArrayList<QuantityType>();
        }
        return this.quantitiy;
    }

//    public DccListType getList() {
//        return list;
//    }
//    public void setList(DccListType value) {
//        this.list = value;
//    }

}

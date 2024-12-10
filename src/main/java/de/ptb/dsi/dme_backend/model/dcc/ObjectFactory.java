//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2024.11.29 um 02:25:21 PM CET 
//


package de.ptb.dsi.dme_backend.model.dcc;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import java.util.List;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the de.ptb.xcd package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Real_QNAME = new QName("https://ptb.de/si", "real");
    private final static QName _Constant_QNAME = new QName("https://ptb.de/si", "constant");
    private final static QName _Complex_QNAME = new QName("https://ptb.de/si", "complex");
    private final static QName _RealList_QNAME = new QName("https://ptb.de/si", "realList");
    private final static QName _RealListXMLList_QNAME = new QName("https://ptb.de/si", "realListXMLList");
    private final static QName _ComplexList_QNAME = new QName("https://ptb.de/si", "complexList");
    private final static QName _ComplexListXMLList_QNAME = new QName("https://ptb.de/si", "complexListXMLList");
    private final static QName _List_QNAME = new QName("https://ptb.de/si", "list");
    private final static QName _Hybrid_QNAME = new QName("https://ptb.de/si", "hybrid");
    private final static QName _QuantityType_QNAME = new QName("https://ptb.de/si", "quantityType");
    private final static QName _QuantityTypeQUDT_QNAME = new QName("https://ptb.de/si", "quantityTypeQUDT");
    private final static QName _ListQuantityType_QNAME = new QName("https://ptb.de/si", "listQuantityType");
    private final static QName _ListQuantityTypeQUDT_QNAME = new QName("https://ptb.de/si", "listQuantityTypeQUDT");
    private final static QName _QuantityTypeXMLList_QNAME = new QName("https://ptb.de/si", "quantityTypeXMLList");
    private final static QName _QuantityTypeQUDTXMLList_QNAME = new QName("https://ptb.de/si", "quantityTypeQUDTXMLList");
    private final static QName _ExpandedUnc_QNAME = new QName("https://ptb.de/si", "expandedUnc");
    private final static QName _CoverageInterval_QNAME = new QName("https://ptb.de/si", "coverageInterval");
    private final static QName _CovarianceMatrix_QNAME = new QName("https://ptb.de/si", "covarianceMatrix");
    private final static QName _EllipsoidalRegion_QNAME = new QName("https://ptb.de/si", "ellipsoidalRegion");
    private final static QName _RectangularRegion_QNAME = new QName("https://ptb.de/si", "rectangularRegion");
    private final static QName _DigitalCalibrationCertificate_QNAME = new QName("https://ptb.de/dcc", "digitalCalibrationCertificate");
    private final static QName _LocationTypeCity_QNAME = new QName("https://ptb.de/dcc", "city");
    private final static QName _LocationTypeCountryCode_QNAME = new QName("https://ptb.de/dcc", "countryCode");
    private final static QName _LocationTypePostCode_QNAME = new QName("https://ptb.de/dcc", "postCode");
    private final static QName _LocationTypePostOfficeBox_QNAME = new QName("https://ptb.de/dcc", "postOfficeBox");
    private final static QName _LocationTypeState_QNAME = new QName("https://ptb.de/dcc", "state");
    private final static QName _LocationTypeStreet_QNAME = new QName("https://ptb.de/dcc", "street");
    private final static QName _LocationTypeStreetNo_QNAME = new QName("https://ptb.de/dcc", "streetNo");
    private final static QName _LocationTypeFurther_QNAME = new QName("https://ptb.de/dcc", "further");
    private final static QName _LocationTypePositionCoordinates_QNAME = new QName("https://ptb.de/dcc", "positionCoordinates");
    private final static QName _ComplexInListTypeLabel_QNAME = new QName("https://ptb.de/si", "label");
    private final static QName _ComplexInListTypeValueReal_QNAME = new QName("https://ptb.de/si", "valueReal");
    private final static QName _ComplexInListTypeValueImag_QNAME = new QName("https://ptb.de/si", "valueImag");
    private final static QName _ComplexInListTypeUnit_QNAME = new QName("https://ptb.de/si", "unit");
    private final static QName _ComplexInListTypeValueMagnitude_QNAME = new QName("https://ptb.de/si", "valueMagnitude");
    private final static QName _ComplexInListTypeValuePhase_QNAME = new QName("https://ptb.de/si", "valuePhase");
    private final static QName _ComplexInListTypeUnitPhase_QNAME = new QName("https://ptb.de/si", "unitPhase");
    private final static QName _ComplexInListTypeDateTime_QNAME = new QName("https://ptb.de/si", "dateTime");
    private final static QName _ComplexListXMLListTypeLabelXMLList_QNAME = new QName("https://ptb.de/si", "labelXMLList");
    private final static QName _ComplexListXMLListTypeValueRealXMLList_QNAME = new QName("https://ptb.de/si", "valueRealXMLList");
    private final static QName _ComplexListXMLListTypeValueImagXMLList_QNAME = new QName("https://ptb.de/si", "valueImagXMLList");
    private final static QName _ComplexListXMLListTypeUnitXMLList_QNAME = new QName("https://ptb.de/si", "unitXMLList");
    private final static QName _ComplexListXMLListTypeValueMagnitudeXMLList_QNAME = new QName("https://ptb.de/si", "valueMagnitudeXMLList");
    private final static QName _ComplexListXMLListTypeValuePhaseXMLList_QNAME = new QName("https://ptb.de/si", "valuePhaseXMLList");
    private final static QName _ComplexListXMLListTypeUnitPhaseXMLList_QNAME = new QName("https://ptb.de/si", "unitPhaseXMLList");
    private final static QName _ComplexListXMLListTypeDateTimeXMLList_QNAME = new QName("https://ptb.de/si", "dateTimeXMLList");
    private final static QName _ComplexListXMLListTypeMeasurementUncertaintyBivariateXMLList_QNAME = new QName("https://ptb.de/si", "measurementUncertaintyBivariateXMLList");
    private final static QName _ComplexListXMLListTypeMeasurementUncertaintyMultivariateXMLList_QNAME = new QName("https://ptb.de/si", "measurementUncertaintyMultivariateXMLList");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: de.ptb.xcd
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DigitalCalibrationCertificateType }
     * 
     */
    public DigitalCalibrationCertificateType createDigitalCalibrationCertificateType() {
        return new DigitalCalibrationCertificateType();
    }

    /**
     * Create an instance of {@link CovarianceMatrixXMLListType }
     * 
     */
    public CovarianceMatrixXMLListType createCovarianceMatrixXMLListType() {
        return new CovarianceMatrixXMLListType();
    }

    /**
     * Create an instance of {@link CovarianceMatrixType }
     * 
     */
    public CovarianceMatrixType createCovarianceMatrixType() {
        return new CovarianceMatrixType();
    }

    /**
     * Create an instance of {@link CovarianceMatrixType.Column }
     * 
     */
    public CovarianceMatrixType.Column createCovarianceMatrixTypeColumn() {
        return new CovarianceMatrixType.Column();
    }

    /**
     * Create an instance of {@link RealQuantityType }
     * 
     */
    public RealQuantityType createRealQuantityType() {
        return new RealQuantityType();
    }

    /**
     * Create an instance of {@link ConstantQuantityType }
     * 
     */
    public ConstantQuantityType createConstantQuantityType() {
        return new ConstantQuantityType();
    }

    /**
     * Create an instance of {@link ComplexQuantityType }
     * 
     */
    public ComplexQuantityType createComplexQuantityType() {
        return new ComplexQuantityType();
    }

    /**
     * Create an instance of {@link RealListType }
     * 
     */
    public RealListType createRealListType() {
        return new RealListType();
    }

    /**
     * Create an instance of {@link RealListXMLListType }
     * 
     */
    public RealListXMLListType createRealListXMLListType() {
        return new RealListXMLListType();
    }

    /**
     * Create an instance of {@link ComplexListType }
     * 
     */
    public ComplexListType createComplexListType() {
        return new ComplexListType();
    }

    /**
     * Create an instance of {@link ComplexListXMLListType }
     * 
     */
    public ComplexListXMLListType createComplexListXMLListType() {
        return new ComplexListXMLListType();
    }

    /**
     * Create an instance of {@link ListType }
     * 
     */
    public ListType createListType() {
        return new ListType();
    }

    /**
     * Create an instance of {@link HybridType }
     * 
     */
    public HybridType createHybridType() {
        return new HybridType();
    }

    /**
     * Create an instance of {@link ExpandedUncType }
     * 
     */
    public ExpandedUncType createExpandedUncType() {
        return new ExpandedUncType();
    }

    /**
     * Create an instance of {@link CoverageIntervalType }
     * 
     */
    public CoverageIntervalType createCoverageIntervalType() {
        return new CoverageIntervalType();
    }

    /**
     * Create an instance of {@link EllipsoidalRegionType }
     * 
     */
    public EllipsoidalRegionType createEllipsoidalRegionType() {
        return new EllipsoidalRegionType();
    }

    /**
     * Create an instance of {@link RectangularRegionType }
     * 
     */
    public RectangularRegionType createRectangularRegionType() {
        return new RectangularRegionType();
    }

    /**
     * Create an instance of {@link MeasurementUncertaintyUnivariateType }
     * 
     */
    public MeasurementUncertaintyUnivariateType createMeasurementUncertaintyUnivariateType() {
        return new MeasurementUncertaintyUnivariateType();
    }

    /**
     * Create an instance of {@link StandardMUType }
     * 
     */
    public StandardMUType createStandardMUType() {
        return new StandardMUType();
    }

    /**
     * Create an instance of {@link ExpandedMUType }
     * 
     */
    public ExpandedMUType createExpandedMUType() {
        return new ExpandedMUType();
    }

    /**
     * Create an instance of {@link CoverageIntervalMUType }
     * 
     */
    public CoverageIntervalMUType createCoverageIntervalMUType() {
        return new CoverageIntervalMUType();
    }

    /**
     * Create an instance of {@link RealInListType }
     * 
     */
    public RealInListType createRealInListType() {
        return new RealInListType();
    }

    /**
     * Create an instance of {@link ListMeasurementUncertaintyUnivariateType }
     * 
     */
    public ListMeasurementUncertaintyUnivariateType createListMeasurementUncertaintyUnivariateType() {
        return new ListMeasurementUncertaintyUnivariateType();
    }

    /**
     * Create an instance of {@link ListUnivariateUncType }
     * 
     */
    public ListUnivariateUncType createListUnivariateUncType() {
        return new ListUnivariateUncType();
    }

    /**
     * Create an instance of {@link MeasurementUncertaintyUnivariateXMLListType }
     * 
     */
    public MeasurementUncertaintyUnivariateXMLListType createMeasurementUncertaintyUnivariateXMLListType() {
        return new MeasurementUncertaintyUnivariateXMLListType();
    }

    /**
     * Create an instance of {@link StandardMUXMLListType }
     * 
     */
    public StandardMUXMLListType createStandardMUXMLListType() {
        return new StandardMUXMLListType();
    }

    /**
     * Create an instance of {@link ExpandedMUXMLListType }
     * 
     */
    public ExpandedMUXMLListType createExpandedMUXMLListType() {
        return new ExpandedMUXMLListType();
    }

    /**
     * Create an instance of {@link CoverageIntervalMUXMLListType }
     * 
     */
    public CoverageIntervalMUXMLListType createCoverageIntervalMUXMLListType() {
        return new CoverageIntervalMUXMLListType();
    }

    /**
     * Create an instance of {@link ExpandedUncXMLListType }
     * 
     */
    public ExpandedUncXMLListType createExpandedUncXMLListType() {
        return new ExpandedUncXMLListType();
    }

    /**
     * Create an instance of {@link CoverageIntervalXMLListType }
     * 
     */
    public CoverageIntervalXMLListType createCoverageIntervalXMLListType() {
        return new CoverageIntervalXMLListType();
    }

    /**
     * Create an instance of {@link MeasurementUncertaintyMultivariateXMLListType }
     * 
     */
    public MeasurementUncertaintyMultivariateXMLListType createMeasurementUncertaintyMultivariateXMLListType() {
        return new MeasurementUncertaintyMultivariateXMLListType();
    }

    /**
     * Create an instance of {@link EllipsoidalRegionMUXMLListType }
     * 
     */
    public EllipsoidalRegionMUXMLListType createEllipsoidalRegionMUXMLListType() {
        return new EllipsoidalRegionMUXMLListType();
    }

    /**
     * Create an instance of {@link RectangularRegionMUXMLListType }
     * 
     */
    public RectangularRegionMUXMLListType createRectangularRegionMUXMLListType() {
        return new RectangularRegionMUXMLListType();
    }

    /**
     * Create an instance of {@link CovarianceXMLListType }
     * 
     */
    public CovarianceXMLListType createCovarianceXMLListType() {
        return new CovarianceXMLListType();
    }

    /**
     * Create an instance of {@link ComplexInListType }
     * 
     */
    public ComplexInListType createComplexInListType() {
        return new ComplexInListType();
    }

    /**
     * Create an instance of {@link ListBivariateUncType }
     * 
     */
    public ListBivariateUncType createListBivariateUncType() {
        return new ListBivariateUncType();
    }

    /**
     * Create an instance of {@link MeasurementUncertaintyBivariateXMLListType }
     * 
     */
    public MeasurementUncertaintyBivariateXMLListType createMeasurementUncertaintyBivariateXMLListType() {
        return new MeasurementUncertaintyBivariateXMLListType();
    }

    /**
     * Create an instance of {@link AdministrativeDataType }
     * 
     */
    public AdministrativeDataType createAdministrativeDataType() {
        return new AdministrativeDataType();
    }

    /**
     * Create an instance of {@link SoftwareListType }
     * 
     */
    public SoftwareListType createSoftwareListType() {
        return new SoftwareListType();
    }

    /**
     * Create an instance of {@link SoftwareType }
     *
     */
    public SoftwareType createSoftwareType() {
        return new SoftwareType();
    }

    /**
     * Create an instance of {@link MeasuringEquipmentListType }
     * 
     */
    public MeasuringEquipmentListType createMeasuringEquipmentListType() {
        return new MeasuringEquipmentListType();
    }

    /**
     * Create an instance of {@link MeasuringEquipmentType }
     * 
     */
    public MeasuringEquipmentType createMeasuringEquipmentType() {
        return new MeasuringEquipmentType();
    }

    /**
     * Create an instance of {@link MeasuringEquipmentQuantityListType }
     * 
     */
    public MeasuringEquipmentQuantityListType createMeasuringEquipmentQuantityListType() {
        return new MeasuringEquipmentQuantityListType();
    }

    /**
     * Create an instance of {@link MeasuringEquipmentQuantityType }
     * 
     */
    public MeasuringEquipmentQuantityType createMeasuringEquipmentQuantityType() {
        return new MeasuringEquipmentQuantityType();
    }

    /**
     * Create an instance of {@link CoreDataType }
     * 
     */
    public CoreDataType createCoreDataType() {
        return new CoreDataType();
    }

    /**
     * Create an instance of {@link EquipmentClassType }
     * 
     */
    public EquipmentClassType createEquipmentClassType() {
        return new EquipmentClassType();
    }

    /**
     * Create an instance of {@link ItemListType }
     * 
     */
    public ItemListType createItemListType() {
        return new ItemListType();
    }

    /**
     * Create an instance of {@link ItemType }
     * 
     */
    public ItemType createItemType() {
        return new ItemType();
    }

    /**
     * Create an instance of {@link IdentificationListType }
     * 
     */
    public IdentificationListType createIdentificationListType() {
        return new IdentificationListType();
    }

    /**
     * Create an instance of {@link IdentificationType }
     * 
     */
    public IdentificationType createIdentificationType() {
        return new IdentificationType();
    }

    /**
     * Create an instance of {@link PerformanceLocationType }
     * 
     */
    public PerformanceLocationType createPerformanceLocationType() {
        return new PerformanceLocationType();
    }

    /**
     * Create an instance of {@link CalibrationLaboratory }
     * 
     */
    public CalibrationLaboratory createCalibrationLaboratoryType() {
        return new CalibrationLaboratory();
    }

    /**
     * Create an instance of {@link RespPersonListType }
     * 
     */
    public RespPersonListType createRespPersonListType() {
        return new RespPersonListType();
    }

    /**
     * Create an instance of {@link RespPersonType }
     * 
     */
    public RespPersonType createRespPersonType() {
        return new RespPersonType();
    }

    /**
     * Create an instance of {@link StatementListType }
     * 
     */
    public StatementListType createStatementListType() {
        return new StatementListType();
    }

    /**
     * Create an instance of {@link MeasurementResultType }
     * 
     */
    public MeasurementResultType createMeasurementResultType() {
        return new MeasurementResultType();
    }

    /**
     * Create an instance of {@link UsedMethodListType }
     * 
     */
    public UsedMethodListType createUsedMethodListType() {
        return new UsedMethodListType();
    }

    /**
     * Create an instance of {@link UsedMethodType }
     * 
     */
    public UsedMethodType createUsedMethodType() {
        return new UsedMethodType();
    }

    /**
     * Create an instance of {@link InfluenceConditionListType }
     * 
     */
    public InfluenceConditionListType createInfluenceConditionListType() {
        return new InfluenceConditionListType();
    }

    /**
     * Create an instance of {@link ConditionType }
     * 
     */
    public ConditionType createConditionType() {
        return new ConditionType();
    }

    /**
     * Create an instance of {@link ResultListType }
     * 
     */
    public ResultListType createResultListType() {
        return new ResultListType();
    }

    /**
     * Create an instance of {@link ResultType }
     * 
     */
    public ResultType createResultType() {
        return new ResultType();
    }

    /**
     * Create an instance of {@link DataType }
     * 
     */
    public DataType createDataType() {
        return new DataType();
    }

    /**
     * Create an instance of {@link QuantityType }
     * 
     */
    public QuantityType createQuantityType() {
        return new QuantityType();
    }

    /**
     * Create an instance of {@link RelativeUncertaintyType }
     * 
     */
    public RelativeUncertaintyType createRelativeUncertaintyType() {
        return new RelativeUncertaintyType();
    }

    /**
     * Create an instance of {@link MeasurementMetaDataListType }
     * 
     */
    public MeasurementMetaDataListType createMeasurementMetaDataListType() {
        return new MeasurementMetaDataListType();
    }

    /**
     * Create an instance of {@link StatementMetaDataType }
     * 
     */
    public StatementMetaDataType createStatementMetaDataType() {
        return new StatementMetaDataType();
    }

    /**
     * Create an instance of {@link StringWithLangType }
     * 
     */
    public StringWithLangType createStringWithLangType() {
        return new StringWithLangType();
    }

    /**
     * Create an instance of {@link LocationType }
     * 
     */
    public LocationType createLocationType() {
        return new LocationType();
    }

    /**
     * Create an instance of {@link PositionCoordinatesType }
     * 
     */
    public PositionCoordinatesType createPositionCoordinatesType() {
        return new PositionCoordinatesType();
    }

    /**
     * Create an instance of {@link ContactType }
     * 
     */
    public ContactType createContactType() {
        return new ContactType();
    }

    /**
     * Create an instance of {@link ContactNotStrictType }
     * 
     */
    public ContactNotStrictType createContactNotStrictType() {
        return new ContactNotStrictType();
    }

    /**
     * Create an instance of {@link HashType }
     * 
     */
    public HashType createHashType() {
        return new HashType();
    }

    /**
     * Create an instance of {@link TextType }
     * 
     */
    public TextType createTextType() {
        return new TextType();
    }

    /**
     * Create an instance of {@link RichContentType }
     * 
     */
    public RichContentType createRichContentType() {
        return new RichContentType();
    }

    /**
     * Create an instance of {@link ByteDataType }
     * 
     */
    public ByteDataType createByteDataType() {
        return new ByteDataType();
    }

    /**
     * Create an instance of {@link FormulaType }
     * 
     */
    public FormulaType createFormulaType() {
        return new FormulaType();
    }

    /**
     * Create an instance of {@link XmlType }
     * 
     */
    public XmlType createXmlType() {
        return new XmlType();
    }

    /**
     * Create an instance of {@link DigitalCalibrationCertificateType.Comment }
     * 
     */
    public DigitalCalibrationCertificateType.Comment createDigitalCalibrationCertificateTypeComment() {
        return new DigitalCalibrationCertificateType.Comment();
    }

    /**
     * Create an instance of {@link CovarianceMatrixXMLListType.ColumnXMLList }
     * 
     */
    public CovarianceMatrixXMLListType.ColumnXMLList createCovarianceMatrixXMLListTypeColumnXMLList() {
        return new CovarianceMatrixXMLListType.ColumnXMLList();
    }

    /**
     * Create an instance of {@link CovarianceMatrixType.Column.Covariance }
     * 
     */
    public CovarianceMatrixType.Column.Covariance createCovarianceMatrixTypeColumnCovariance() {
        return new CovarianceMatrixType.Column.Covariance();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RealQuantityType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RealQuantityType }{@code >}
     */
    @XmlElementDecl(namespace = "https://ptb.de/si", name = "real")
    public JAXBElement<RealQuantityType> createReal(RealQuantityType value) {
        return new JAXBElement<RealQuantityType>(_Real_QNAME, RealQuantityType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConstantQuantityType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ConstantQuantityType }{@code >}
     */
    @XmlElementDecl(namespace = "https://ptb.de/si", name = "constant")
    public JAXBElement<ConstantQuantityType> createConstant(ConstantQuantityType value) {
        return new JAXBElement<ConstantQuantityType>(_Constant_QNAME, ConstantQuantityType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ComplexQuantityType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ComplexQuantityType }{@code >}
     */
    @XmlElementDecl(namespace = "https://ptb.de/si", name = "complex")
    public JAXBElement<ComplexQuantityType> createComplex(ComplexQuantityType value) {
        return new JAXBElement<ComplexQuantityType>(_Complex_QNAME, ComplexQuantityType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RealListType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RealListType }{@code >}
     */
    @XmlElementDecl(namespace = "https://ptb.de/si", name = "realList")
    public JAXBElement<RealListType> createRealList(RealListType value) {
        return new JAXBElement<RealListType>(_RealList_QNAME, RealListType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RealListXMLListType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RealListXMLListType }{@code >}
     */
    @XmlElementDecl(namespace = "https://ptb.de/si", name = "realListXMLList")
    public JAXBElement<RealListXMLListType> createRealListXMLList(RealListXMLListType value) {
        return new JAXBElement<RealListXMLListType>(_RealListXMLList_QNAME, RealListXMLListType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ComplexListType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ComplexListType }{@code >}
     */
    @XmlElementDecl(namespace = "https://ptb.de/si", name = "complexList")
    public JAXBElement<ComplexListType> createComplexList(ComplexListType value) {
        return new JAXBElement<ComplexListType>(_ComplexList_QNAME, ComplexListType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ComplexListXMLListType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ComplexListXMLListType }{@code >}
     */
    @XmlElementDecl(namespace = "https://ptb.de/si", name = "complexListXMLList")
    public JAXBElement<ComplexListXMLListType> createComplexListXMLList(ComplexListXMLListType value) {
        return new JAXBElement<ComplexListXMLListType>(_ComplexListXMLList_QNAME, ComplexListXMLListType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ListType }{@code >}
     */
    @XmlElementDecl(namespace = "https://ptb.de/si", name = "list")
    public JAXBElement<ListType> createList(ListType value) {
        return new JAXBElement<ListType>(_List_QNAME, ListType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HybridType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link HybridType }{@code >}
     */
    @XmlElementDecl(namespace = "https://ptb.de/si", name = "hybrid")
    public JAXBElement<HybridType> createHybrid(HybridType value) {
        return new JAXBElement<HybridType>(_Hybrid_QNAME, HybridType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "https://ptb.de/si", name = "quantityType")
    public JAXBElement<String> createQuantityType(String value) {
        return new JAXBElement<String>(_QuantityType_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "https://ptb.de/si", name = "quantityTypeQUDT", substitutionHeadNamespace = "https://ptb.de/si", substitutionHeadName = "quantityType")
    public JAXBElement<String> createQuantityTypeQUDT(String value) {
        return new JAXBElement<String>(_QuantityTypeQUDT_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "https://ptb.de/si", name = "listQuantityType")
    public JAXBElement<String> createListQuantityType(String value) {
        return new JAXBElement<String>(_ListQuantityType_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "https://ptb.de/si", name = "listQuantityTypeQUDT", substitutionHeadNamespace = "https://ptb.de/si", substitutionHeadName = "listQuantityType")
    public JAXBElement<String> createListQuantityTypeQUDT(String value) {
        return new JAXBElement<String>(_ListQuantityTypeQUDT_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "https://ptb.de/si", name = "quantityTypeXMLList")
    public JAXBElement<String> createQuantityTypeXMLList(String value) {
        return new JAXBElement<String>(_QuantityTypeXMLList_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "https://ptb.de/si", name = "quantityTypeQUDTXMLList", substitutionHeadNamespace = "https://ptb.de/si", substitutionHeadName = "quantityTypeXMLList")
    public JAXBElement<String> createQuantityTypeQUDTXMLList(String value) {
        return new JAXBElement<String>(_QuantityTypeQUDTXMLList_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExpandedUncType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ExpandedUncType }{@code >}
     */
    @XmlElementDecl(namespace = "https://ptb.de/si", name = "expandedUnc")
    public JAXBElement<ExpandedUncType> createExpandedUnc(ExpandedUncType value) {
        return new JAXBElement<ExpandedUncType>(_ExpandedUnc_QNAME, ExpandedUncType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CoverageIntervalType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CoverageIntervalType }{@code >}
     */
    @XmlElementDecl(namespace = "https://ptb.de/si", name = "coverageInterval")
    public JAXBElement<CoverageIntervalType> createCoverageInterval(CoverageIntervalType value) {
        return new JAXBElement<CoverageIntervalType>(_CoverageInterval_QNAME, CoverageIntervalType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CovarianceMatrixType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CovarianceMatrixType }{@code >}
     */
    @XmlElementDecl(namespace = "https://ptb.de/si", name = "covarianceMatrix")
    public JAXBElement<CovarianceMatrixType> createCovarianceMatrix(CovarianceMatrixType value) {
        return new JAXBElement<CovarianceMatrixType>(_CovarianceMatrix_QNAME, CovarianceMatrixType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EllipsoidalRegionType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EllipsoidalRegionType }{@code >}
     */
    @XmlElementDecl(namespace = "https://ptb.de/si", name = "ellipsoidalRegion")
    public JAXBElement<EllipsoidalRegionType> createEllipsoidalRegion(EllipsoidalRegionType value) {
        return new JAXBElement<EllipsoidalRegionType>(_EllipsoidalRegion_QNAME, EllipsoidalRegionType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RectangularRegionType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RectangularRegionType }{@code >}
     */
    @XmlElementDecl(namespace = "https://ptb.de/si", name = "rectangularRegion")
    public JAXBElement<RectangularRegionType> createRectangularRegion(RectangularRegionType value) {
        return new JAXBElement<RectangularRegionType>(_RectangularRegion_QNAME, RectangularRegionType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DigitalCalibrationCertificateType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DigitalCalibrationCertificateType }{@code >}
     */
    @XmlElementDecl(namespace = "https://ptb.de/dcc", name = "digitalCalibrationCertificate")
    public JAXBElement<DigitalCalibrationCertificateType> createDigitalCalibrationCertificate(DigitalCalibrationCertificateType value) {
        return new JAXBElement<DigitalCalibrationCertificateType>(_DigitalCalibrationCertificate_QNAME, DigitalCalibrationCertificateType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "https://ptb.de/dcc", name = "city", scope = LocationType.class)
    public JAXBElement<String> createLocationTypeCity(String value) {
        return new JAXBElement<String>(_LocationTypeCity_QNAME, String.class, LocationType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "https://ptb.de/dcc", name = "countryCode", scope = LocationType.class)
    public JAXBElement<String> createLocationTypeCountryCode(String value) {
        return new JAXBElement<String>(_LocationTypeCountryCode_QNAME, String.class, LocationType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "https://ptb.de/dcc", name = "postCode", scope = LocationType.class)
    public JAXBElement<String> createLocationTypePostCode(String value) {
        return new JAXBElement<String>(_LocationTypePostCode_QNAME, String.class, LocationType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "https://ptb.de/dcc", name = "postOfficeBox", scope = LocationType.class)
    public JAXBElement<String> createLocationTypePostOfficeBox(String value) {
        return new JAXBElement<String>(_LocationTypePostOfficeBox_QNAME, String.class, LocationType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "https://ptb.de/dcc", name = "state", scope = LocationType.class)
    public JAXBElement<String> createLocationTypeState(String value) {
        return new JAXBElement<String>(_LocationTypeState_QNAME, String.class, LocationType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "https://ptb.de/dcc", name = "street", scope = LocationType.class)
    public JAXBElement<String> createLocationTypeStreet(String value) {
        return new JAXBElement<String>(_LocationTypeStreet_QNAME, String.class, LocationType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "https://ptb.de/dcc", name = "streetNo", scope = LocationType.class)
    public JAXBElement<String> createLocationTypeStreetNo(String value) {
        return new JAXBElement<String>(_LocationTypeStreetNo_QNAME, String.class, LocationType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RichContentType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RichContentType }{@code >}
     */
    @XmlElementDecl(namespace = "https://ptb.de/dcc", name = "further", scope = LocationType.class)
    public JAXBElement<RichContentType> createLocationTypeFurther(RichContentType value) {
        return new JAXBElement<RichContentType>(_LocationTypeFurther_QNAME, RichContentType.class, LocationType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PositionCoordinatesType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PositionCoordinatesType }{@code >}
     */
    @XmlElementDecl(namespace = "https://ptb.de/dcc", name = "positionCoordinates", scope = LocationType.class)
    public JAXBElement<PositionCoordinatesType> createLocationTypePositionCoordinates(PositionCoordinatesType value) {
        return new JAXBElement<PositionCoordinatesType>(_LocationTypePositionCoordinates_QNAME, PositionCoordinatesType.class, LocationType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "https://ptb.de/si", name = "label", scope = ComplexInListType.class)
    public JAXBElement<String> createComplexInListTypeLabel(String value) {
        return new JAXBElement<String>(_ComplexInListTypeLabel_QNAME, String.class, ComplexInListType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Double }{@code >}
     */
    @XmlElementDecl(namespace = "https://ptb.de/si", name = "valueReal", scope = ComplexInListType.class)
    public JAXBElement<Double> createComplexInListTypeValueReal(Double value) {
        return new JAXBElement<Double>(_ComplexInListTypeValueReal_QNAME, Double.class, ComplexInListType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Double }{@code >}
     */
    @XmlElementDecl(namespace = "https://ptb.de/si", name = "valueImag", scope = ComplexInListType.class)
    public JAXBElement<Double> createComplexInListTypeValueImag(Double value) {
        return new JAXBElement<Double>(_ComplexInListTypeValueImag_QNAME, Double.class, ComplexInListType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "https://ptb.de/si", name = "unit", scope = ComplexInListType.class)
    public JAXBElement<String> createComplexInListTypeUnit(String value) {
        return new JAXBElement<String>(_ComplexInListTypeUnit_QNAME, String.class, ComplexInListType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Double }{@code >}
     */
    @XmlElementDecl(namespace = "https://ptb.de/si", name = "valueMagnitude", scope = ComplexInListType.class)
    public JAXBElement<Double> createComplexInListTypeValueMagnitude(Double value) {
        return new JAXBElement<Double>(_ComplexInListTypeValueMagnitude_QNAME, Double.class, ComplexInListType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Double }{@code >}
     */
    @XmlElementDecl(namespace = "https://ptb.de/si", name = "valuePhase", scope = ComplexInListType.class)
    public JAXBElement<Double> createComplexInListTypeValuePhase(Double value) {
        return new JAXBElement<Double>(_ComplexInListTypeValuePhase_QNAME, Double.class, ComplexInListType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "https://ptb.de/si", name = "unitPhase", scope = ComplexInListType.class)
    public JAXBElement<String> createComplexInListTypeUnitPhase(String value) {
        return new JAXBElement<String>(_ComplexInListTypeUnitPhase_QNAME, String.class, ComplexInListType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     */
    @XmlElementDecl(namespace = "https://ptb.de/si", name = "dateTime", scope = ComplexInListType.class)
    public JAXBElement<XMLGregorianCalendar> createComplexInListTypeDateTime(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_ComplexInListTypeDateTime_QNAME, XMLGregorianCalendar.class, ComplexInListType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EllipsoidalRegionType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EllipsoidalRegionType }{@code >}
     */
    @XmlElementDecl(namespace = "https://ptb.de/si", name = "ellipsoidalRegion", scope = ComplexInListType.class)
    public JAXBElement<EllipsoidalRegionType> createComplexInListTypeEllipsoidalRegion(EllipsoidalRegionType value) {
        return new JAXBElement<EllipsoidalRegionType>(_EllipsoidalRegion_QNAME, EllipsoidalRegionType.class, ComplexInListType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RectangularRegionType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RectangularRegionType }{@code >}
     */
    @XmlElementDecl(namespace = "https://ptb.de/si", name = "rectangularRegion", scope = ComplexInListType.class)
    public JAXBElement<RectangularRegionType> createComplexInListTypeRectangularRegion(RectangularRegionType value) {
        return new JAXBElement<RectangularRegionType>(_RectangularRegion_QNAME, RectangularRegionType.class, ComplexInListType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link List }{@code <}{@link String }{@code >}{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link List }{@code <}{@link String }{@code >}{@code >}
     */
    @XmlElementDecl(namespace = "https://ptb.de/si", name = "labelXMLList", scope = ComplexListXMLListType.class)
    public JAXBElement<List<String>> createComplexListXMLListTypeLabelXMLList(List<String> value) {
        return new JAXBElement<List<String>>(_ComplexListXMLListTypeLabelXMLList_QNAME, ((Class) List.class), ComplexListXMLListType.class, ((List<String> ) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link List }{@code <}{@link Double }{@code >}{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link List }{@code <}{@link Double }{@code >}{@code >}
     */
    @XmlElementDecl(namespace = "https://ptb.de/si", name = "valueRealXMLList", scope = ComplexListXMLListType.class)
    public JAXBElement<List<Double>> createComplexListXMLListTypeValueRealXMLList(List<Double> value) {
        return new JAXBElement<List<Double>>(_ComplexListXMLListTypeValueRealXMLList_QNAME, ((Class) List.class), ComplexListXMLListType.class, ((List<Double> ) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link List }{@code <}{@link Double }{@code >}{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link List }{@code <}{@link Double }{@code >}{@code >}
     */
    @XmlElementDecl(namespace = "https://ptb.de/si", name = "valueImagXMLList", scope = ComplexListXMLListType.class)
    public JAXBElement<List<Double>> createComplexListXMLListTypeValueImagXMLList(List<Double> value) {
        return new JAXBElement<List<Double>>(_ComplexListXMLListTypeValueImagXMLList_QNAME, ((Class) List.class), ComplexListXMLListType.class, ((List<Double> ) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link List }{@code <}{@link String }{@code >}{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link List }{@code <}{@link String }{@code >}{@code >}
     */
    @XmlElementDecl(namespace = "https://ptb.de/si", name = "unitXMLList", scope = ComplexListXMLListType.class)
    public JAXBElement<List<String>> createComplexListXMLListTypeUnitXMLList(List<String> value) {
        return new JAXBElement<List<String>>(_ComplexListXMLListTypeUnitXMLList_QNAME, ((Class) List.class), ComplexListXMLListType.class, ((List<String> ) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link List }{@code <}{@link Double }{@code >}{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link List }{@code <}{@link Double }{@code >}{@code >}
     */
    @XmlElementDecl(namespace = "https://ptb.de/si", name = "valueMagnitudeXMLList", scope = ComplexListXMLListType.class)
    public JAXBElement<List<Double>> createComplexListXMLListTypeValueMagnitudeXMLList(List<Double> value) {
        return new JAXBElement<List<Double>>(_ComplexListXMLListTypeValueMagnitudeXMLList_QNAME, ((Class) List.class), ComplexListXMLListType.class, ((List<Double> ) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link List }{@code <}{@link Double }{@code >}{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link List }{@code <}{@link Double }{@code >}{@code >}
     */
    @XmlElementDecl(namespace = "https://ptb.de/si", name = "valuePhaseXMLList", scope = ComplexListXMLListType.class)
    public JAXBElement<List<Double>> createComplexListXMLListTypeValuePhaseXMLList(List<Double> value) {
        return new JAXBElement<List<Double>>(_ComplexListXMLListTypeValuePhaseXMLList_QNAME, ((Class) List.class), ComplexListXMLListType.class, ((List<Double> ) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link List }{@code <}{@link String }{@code >}{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link List }{@code <}{@link String }{@code >}{@code >}
     */
    @XmlElementDecl(namespace = "https://ptb.de/si", name = "unitPhaseXMLList", scope = ComplexListXMLListType.class)
    public JAXBElement<List<String>> createComplexListXMLListTypeUnitPhaseXMLList(List<String> value) {
        return new JAXBElement<List<String>>(_ComplexListXMLListTypeUnitPhaseXMLList_QNAME, ((Class) List.class), ComplexListXMLListType.class, ((List<String> ) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link List }{@code <}{@link XMLGregorianCalendar }{@code >}{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link List }{@code <}{@link XMLGregorianCalendar }{@code >}{@code >}
     */
    @XmlElementDecl(namespace = "https://ptb.de/si", name = "dateTimeXMLList", scope = ComplexListXMLListType.class)
    public JAXBElement<List<XMLGregorianCalendar>> createComplexListXMLListTypeDateTimeXMLList(List<XMLGregorianCalendar> value) {
        return new JAXBElement<List<XMLGregorianCalendar>>(_ComplexListXMLListTypeDateTimeXMLList_QNAME, ((Class) List.class), ComplexListXMLListType.class, ((List<XMLGregorianCalendar> ) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MeasurementUncertaintyBivariateXMLListType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MeasurementUncertaintyBivariateXMLListType }{@code >}
     */
    @XmlElementDecl(namespace = "https://ptb.de/si", name = "measurementUncertaintyBivariateXMLList", scope = ComplexListXMLListType.class)
    public JAXBElement<MeasurementUncertaintyBivariateXMLListType> createComplexListXMLListTypeMeasurementUncertaintyBivariateXMLList(MeasurementUncertaintyBivariateXMLListType value) {
        return new JAXBElement<MeasurementUncertaintyBivariateXMLListType>(_ComplexListXMLListTypeMeasurementUncertaintyBivariateXMLList_QNAME, MeasurementUncertaintyBivariateXMLListType.class, ComplexListXMLListType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MeasurementUncertaintyMultivariateXMLListType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MeasurementUncertaintyMultivariateXMLListType }{@code >}
     */
    @XmlElementDecl(namespace = "https://ptb.de/si", name = "measurementUncertaintyMultivariateXMLList", scope = ComplexListXMLListType.class)
    public JAXBElement<MeasurementUncertaintyMultivariateXMLListType> createComplexListXMLListTypeMeasurementUncertaintyMultivariateXMLList(MeasurementUncertaintyMultivariateXMLListType value) {
        return new JAXBElement<MeasurementUncertaintyMultivariateXMLListType>(_ComplexListXMLListTypeMeasurementUncertaintyMultivariateXMLList_QNAME, MeasurementUncertaintyMultivariateXMLListType.class, ComplexListXMLListType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "https://ptb.de/si", name = "label", scope = ComplexQuantityType.class)
    public JAXBElement<String> createComplexQuantityTypeLabel(String value) {
        return new JAXBElement<String>(_ComplexInListTypeLabel_QNAME, String.class, ComplexQuantityType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Double }{@code >}
     */
    @XmlElementDecl(namespace = "https://ptb.de/si", name = "valueReal", scope = ComplexQuantityType.class)
    public JAXBElement<Double> createComplexQuantityTypeValueReal(Double value) {
        return new JAXBElement<Double>(_ComplexInListTypeValueReal_QNAME, Double.class, ComplexQuantityType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Double }{@code >}
     */
    @XmlElementDecl(namespace = "https://ptb.de/si", name = "valueImag", scope = ComplexQuantityType.class)
    public JAXBElement<Double> createComplexQuantityTypeValueImag(Double value) {
        return new JAXBElement<Double>(_ComplexInListTypeValueImag_QNAME, Double.class, ComplexQuantityType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "https://ptb.de/si", name = "unit", scope = ComplexQuantityType.class)
    public JAXBElement<String> createComplexQuantityTypeUnit(String value) {
        return new JAXBElement<String>(_ComplexInListTypeUnit_QNAME, String.class, ComplexQuantityType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Double }{@code >}
     */
    @XmlElementDecl(namespace = "https://ptb.de/si", name = "valueMagnitude", scope = ComplexQuantityType.class)
    public JAXBElement<Double> createComplexQuantityTypeValueMagnitude(Double value) {
        return new JAXBElement<Double>(_ComplexInListTypeValueMagnitude_QNAME, Double.class, ComplexQuantityType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Double }{@code >}
     */
    @XmlElementDecl(namespace = "https://ptb.de/si", name = "valuePhase", scope = ComplexQuantityType.class)
    public JAXBElement<Double> createComplexQuantityTypeValuePhase(Double value) {
        return new JAXBElement<Double>(_ComplexInListTypeValuePhase_QNAME, Double.class, ComplexQuantityType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "https://ptb.de/si", name = "unitPhase", scope = ComplexQuantityType.class)
    public JAXBElement<String> createComplexQuantityTypeUnitPhase(String value) {
        return new JAXBElement<String>(_ComplexInListTypeUnitPhase_QNAME, String.class, ComplexQuantityType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     */
    @XmlElementDecl(namespace = "https://ptb.de/si", name = "dateTime", scope = ComplexQuantityType.class)
    public JAXBElement<XMLGregorianCalendar> createComplexQuantityTypeDateTime(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_ComplexInListTypeDateTime_QNAME, XMLGregorianCalendar.class, ComplexQuantityType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EllipsoidalRegionType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EllipsoidalRegionType }{@code >}
     */
    @XmlElementDecl(namespace = "https://ptb.de/si", name = "ellipsoidalRegion", scope = ComplexQuantityType.class)
    public JAXBElement<EllipsoidalRegionType> createComplexQuantityTypeEllipsoidalRegion(EllipsoidalRegionType value) {
        return new JAXBElement<EllipsoidalRegionType>(_EllipsoidalRegion_QNAME, EllipsoidalRegionType.class, ComplexQuantityType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RectangularRegionType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RectangularRegionType }{@code >}
     */
    @XmlElementDecl(namespace = "https://ptb.de/si", name = "rectangularRegion", scope = ComplexQuantityType.class)
    public JAXBElement<RectangularRegionType> createComplexQuantityTypeRectangularRegion(RectangularRegionType value) {
        return new JAXBElement<RectangularRegionType>(_RectangularRegion_QNAME, RectangularRegionType.class, ComplexQuantityType.class, value);
    }

}

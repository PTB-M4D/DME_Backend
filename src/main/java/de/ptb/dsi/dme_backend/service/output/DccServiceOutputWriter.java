package de.ptb.dsi.dme_backend.service.output;


import de.ptb.dsi.dme_backend.model.*;
import de.ptb.dsi.dme_backend.model.dcc.*;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.stereotype.Service;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

@Service
@AllArgsConstructor
public class DccServiceOutputWriter {

    public String createOutputReport(ComparisonDataModel comparisonDataModel) throws JAXBException, DatatypeConfigurationException {

        // ADMINISTRATIVE DATA
        AdministrativeDataType administrativeData;
        if (Objects.equals(comparisonDataModel.getSmartStandard(), "massIntercomparison")){
            administrativeData = createAdministrativeDataMass();
        } else if (Objects.equals(comparisonDataModel.getSmartStandard(), "radiationTempComparison")) {
            administrativeData = createAdministrativeDataTemp();
        } else {
            administrativeData = new AdministrativeDataType();
        }
        // TODO else -> throw exception

        // MEASUREMENT RESULTS
        // loop over each EntityUnderComparison. Every Entity as its own dcc:measurementResult
        List<MeasurementResultType> measurementResults = new ArrayList<>();
        for (EntityUnderComparison entityUnderComparison : comparisonDataModel.getEntities().values()) {
            MeasurementResultType measurementResult = createMeasurementResultEntity(comparisonDataModel, entityUnderComparison);
            measurementResults.add(measurementResult);
        }

        // build measurementResults and create dcc:calibrationCertificate
        MeasurementResultListType measurementResultList = MeasurementResultListType.builder()
                .measurementResult(measurementResults)
                .build();

        DigitalCalibrationCertificateType certificate = DigitalCalibrationCertificateType.builder()
                .schemaVersion("3.2.1")
                .administrativeData(administrativeData)
                .measurementResults(measurementResultList)
                .build();

        // build Output file
        JAXBContext context = JAXBContext.newInstance(DigitalCalibrationCertificateType.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "https://ptb.de/dcc https://ptb.de/dcc/v3.2.1/dcc.xsd");
        StringWriter writer = new StringWriter();
        marshaller.marshal(certificate, writer);

        String base64 = Base64.getEncoder().encodeToString(writer.toString().getBytes());
        return base64;
    }


    private static AdministrativeDataType createAdministrativeDataTemp() throws DatatypeConfigurationException {

        // Software
        TextType softwareName = TextType.builder()
                .content(Collections.singletonList("D-Comparison Temperature"))
                .build();
        SoftwareType software = SoftwareType.builder()
                .name(softwareName)
                .release("v0.3")
                .build();
        SoftwareListType softwareList = SoftwareListType.builder()
                .software(Arrays.asList(software))
                .build();

        // Core Data
        IdentificationType identificationCore = IdentificationType.builder()
                .issuer("calibrationLaboratory")
                .value("20096653")
                .build();
        IdentificationListType identificationCoreList = IdentificationListType.builder()
                .identification(Arrays.asList(identificationCore)).build();
        Date date = new Date();

        CoreDataType coreData = CoreDataType.builder()
                .countryCodeISO31661("DE")
                .usedLangCodeISO6391(Collections.singletonList("en"))
                .mandatoryLangCodeISO6391(Collections.singletonList("en"))
                .uniqueIdentifier("Temp")
                .identifications(identificationCoreList)
                .beginPerformanceDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(new SimpleDateFormat(LocalDate.now().toString()).format(date)))
                .endPerformanceDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(new SimpleDateFormat(LocalDate.now().toString()).format(date)))
                .performanceLocation(PerformanceLocationType.builder().value(StringPerformanceLocationType.LABORATORY).build())
                .build();

        // Items
        TextType identificationName = TextType.builder()
                .content(Collections.singletonList("serialNo"))
                .build();
        IdentificationType identificationItem = IdentificationType.builder()
                .issuer("manufacturer")
                .value("20096653")
                .name(identificationName)
                .build();
        IdentificationListType identificationItemList = IdentificationListType.builder()
                .identification(Arrays.asList(identificationItem)).build();
        ContactType contact = ContactType.builder()
                .name(TextType.builder().content(Collections.singletonList("Serial No.")).build())
                .eMail("info@ptb.de")
                .build();

        TextType itemName1 = TextType.builder()
                .content(Collections.singletonList("blackbody transfer standard: cavity 1"))
//                .lang("en")
                .build();
        TextType identificationName1 = TextType.builder()
                .content(Collections.singletonList("Shape of transfer standard"))
                .build();
        IdentificationType identificationItem1 = IdentificationType.builder()
                .issuer("manufacturer")
                .value("cavity")
                .refType(Collections.singletonList("temperature_blackbodyCavity temperature_blackbodyCavity_tympanic"))
                .name(identificationName1)
                .build();
        IdentificationListType identificationItemList1 = IdentificationListType.builder()
                .identification(Arrays.asList(identificationItem1)).build();
        TextType quantityName = TextType.builder()
                .content(Collections.singletonList("Nominal diameter"))
                .build();
        RealQuantityType siReal1 = RealQuantityType.builder()
                .value(0.04)
                .unit("\\metre")
                .build();
        QuantityType quantity= QuantityType.builder()
                .name(quantityName)
                .real(siReal1)
                .refType(Collections.singletonList("basic_nominalValue"))
                .build();
        ItemQuantities itemQuantities= ItemQuantities.builder()
                .itemQuantity(Arrays.asList( quantity)).build();
        //TODO "lang=en"
        ItemType item1= ItemType.builder()
                .name(itemName1)
                .id("blackbody01")
                .identifications(identificationItemList1)
                .itemQuantities(itemQuantities)
                .build();
        TextType itemName2 = TextType.builder()
                .content(Collections.singletonList("blackbody transfer standard: cavity 2"))
                .build();

        TextType identificationName2 = TextType.builder()
                .content(Collections.singletonList("Shape of transfer standard"))
                .build();
        IdentificationType identificationItem2 = IdentificationType.builder()
                .issuer("manufacturer")
                .value("cavity")
                .refType(Collections.singletonList("temperature_blackbodyCavity temperature_blackbodyCavity_forehead"))
                .name(identificationName2)
                .build();
        IdentificationListType identificationItemList2 = IdentificationListType.builder()
                .identification(Arrays.asList(identificationItem2)).build();
        TextType quantityName2 = TextType.builder()
                .content(Collections.singletonList("Nominal diameter"))
                .build();
        RealQuantityType siReal2 = RealQuantityType.builder()
                .value(0.04)
                .unit("\\metre")
                .build();
        QuantityType quantity2= QuantityType.builder()
                .name(quantityName2)
                .real(siReal2)
                .refType(Collections.singletonList("basic_nominalValue"))
                .build();
        ItemQuantities itemQuantities2= ItemQuantities.builder()
                .itemQuantity(Arrays.asList( quantity2)).build();

        ItemType item2= ItemType.builder()
                .name(itemName2)
                .id("blackbody02")
                .identifications(identificationItemList2)
                .itemQuantities(itemQuantities2)
                .build();

        ItemListType items = ItemListType.builder()
                .identifications(identificationItemList2)
                .item(Arrays.asList(item1,item2))
                .build();
        //TODO //<dcc:itemQuantities>    //</dcc:itemQuantities>

        // Calibration Laboratory
        CalibrationLaboratory calibrationLaboratory = CalibrationLaboratory.builder()
                .contact(contact)
                .build();
        LocationType location= new LocationType();

        // Customer
        TextType customerName = TextType.builder()
                .content(Collections.singletonList("EURAMET Pilot CCT K11 Consultative Committee for Temperature PTB Berlin"))
                .build();
        ContactType customer=ContactType.builder()
                .name(customerName)
                .location(location)
                .build();

        // Responsible Person
        TextType respPersonName = TextType.builder()
                .content(Collections.singletonList("Ingmar Mueller"))
                .build();
        RespPersonType respPerson = RespPersonType.builder()
                .person(ContactNotStrictType.builder()
                        .name(respPersonName).build())
                .build();
        RespPersonListType respPersons = RespPersonListType.builder()
                .respPerson(Arrays.asList(respPerson))
                .build();

        // build Administrative Data
        AdministrativeDataType administrativeData = AdministrativeDataType.builder()
                .dccSoftware(softwareList)
                .coreData(coreData)
                .items(items)
                .calibrationLaboratory(calibrationLaboratory)
                .customer(customer)
                .respPersons(respPersons)
                .build();
        return administrativeData;
    }

    private AdministrativeDataType createAdministrativeDataMass() throws DatatypeConfigurationException {

        // Software
        TextType softwareName = TextType.builder()
                .content(Collections.singletonList("GEMIMEG Tool"))
                .build();
        SoftwareType software = SoftwareType.builder()
                .name(softwareName)
                .release("v1.2.0")
                .build();
        SoftwareListType softwareList = SoftwareListType.builder()
                .software(Arrays.asList(software))
                .build();

        //Core data
        IdentificationType identification = IdentificationType.builder()
                .issuer("calibrationLaboratory")
                .value("NMIJ")
                .build();
        IdentificationListType identificationList = IdentificationListType.builder()
                .identification(Arrays.asList(identification)).build();

        Date date = new Date();

        CoreDataType coreData = CoreDataType.builder()
                .countryCodeISO31661("JP")
                .usedLangCodeISO6391(Collections.singletonList("en"))
                .mandatoryLangCodeISO6391(Collections.singletonList("en"))
                .uniqueIdentifier("mass")
                .identifications(identificationList)
                .beginPerformanceDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(new SimpleDateFormat(LocalDate.now().toString()).format(date)))
                .endPerformanceDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(new SimpleDateFormat(LocalDate.now().toString()).format(date)))
                .performanceLocation(PerformanceLocationType.builder().value(StringPerformanceLocationType.LABORATORY).build())
                .build();


        // Items
        TextType itemName1 = TextType.builder()
                .content(Collections.singletonList("1kg Silicon Sphere"))
//                .lang("en")
                .build();
        IdentificationType identificationItem1 = IdentificationType.builder()
                .issuer("calibrationLaboratory")
                .value("An Identification")
                .build();
        IdentificationListType identificationItemList1 = IdentificationListType.builder()
                .identification(Arrays.asList(identificationItem1)).build();
        TextType manufacturerName = TextType.builder()
                .content(Collections.singletonList("NMIJ"))
                .build();
//TODO "lang=en"
        ContactNotStrictType manufacturer= ContactNotStrictType.builder()
                .name(manufacturerName)
                .build();
        ItemType item1= ItemType.builder()
                .name(itemName1)
                .manufacturer(manufacturer)
                .identifications(identificationItemList1)
                .build();
        ItemListType items = ItemListType.builder()
                .name(itemName1)
                .item(Arrays.asList(item1))
                .build();

        // Calibration Laboratory
        ContactType contact = ContactType.builder()
                .name(TextType.builder().content(Collections.singletonList("Pilot Laboratory")).build())
                .eMail("info@nmij.jp")
                .location(LocationType.builder().city("Tokyo").build())
                .build();
        CalibrationLaboratory calibrationLaboratory = CalibrationLaboratory.builder()
                .contact(contact)
                .build();

        // Customer
        TextType customerName = TextType.builder()
                .content(Collections.singletonList("Kenichi Fuji"))
                .build();
        ContactType customer = ContactType.builder()
                .name(customerName)
                .eMail("k.f@NMILJ.jp")
                .location(LocationType.builder().city("Tokyo").build())
                .build();

        // Presonsible Person
        TextType respPersonName = TextType.builder()
                .content(Collections.singletonList("A Person"))
                .build();
        RespPersonType respPerson = RespPersonType.builder()
                .person(ContactNotStrictType.builder()
                        .name(respPersonName).build())
                .build();
        RespPersonListType respPersons= RespPersonListType.builder()
                .respPerson(Arrays.asList(respPerson))
                .build();

        // build Administrative Data
        AdministrativeDataType administrativeData = AdministrativeDataType.builder()
                .dccSoftware(softwareList)
                .coreData(coreData)
                .items(items)
                .calibrationLaboratory(calibrationLaboratory)
                .customer(customer)
                .respPersons(respPersons)
                .build();

        return administrativeData;
    }


    private ResultType createResultReferenceValueEnCiterion(AnalysisOutput analysisOutput){
        RealQuantityType referenceValue = realQuantityTypeFromSiReal(analysisOutput.getRefValue().getSiReal());

        // quantity for reference Value
        QuantityType quantityReferenceValue = QuantityType.builder()
                .name(TextType.builder()
                        .content(Collections.singletonList("Comparison Reference Value (En Criterion)"))
                        .build())
                .real(referenceValue)
                .refType(Collections.singletonList("comparison_referenceValueEnCriterion"))
                .build();

        ResultType resultReferenceValue = ResultType.builder()
//                    .name(TextType.builder()
//                            .content(Collections.singletonList("Temperature reference value at nominal temperature of 34.5 °C")) //Todo was soll hier rein?
//                            .build())
                .data(DataType.builder()
                        .quantity(quantityReferenceValue)
                        .build())
//                    .refType(Collections.singletonList("temperature_radianceTemperature")) //Todo überarbeiten
                .id("comparison_referenceValues")
                .build();
        return resultReferenceValue;
    }

    private ResultType createResultEnValues(ComparisonDataModel comparisonDataModel, EntityUnderComparison entityUnderComparison, AnalysisOutput analysisOutput) {
        //-------------- loop over all enValues in analysisoutput. EnValues get seperate dcc:result
        DccListType listEn = DccListType.builder().build();
        for (String enKey : analysisOutput.getEnValues().keySet()) {
            SiReal enValue = analysisOutput.getEnValues().get(enKey).getEnValueRaw();
            RealQuantityType siReal = realQuantityTypeFromEnValue(enValue);

            List<String> contentsEn = new ArrayList<>();
            contentsEn.add("Contribution from " + enKey);
            contentsEn.add("used method: " + analysisOutput.getEnValues().get(enKey).getMethod());
            contentsEn.add("En criterion value for: " + entityUnderComparison.getDataIdentifiers().get(analysisOutput.getDataIdentifierId()).getSiLabel());
            QuantityType quantity = QuantityType.builder()
                    .name(TextType.builder()
                            .content(contentsEn)
                            .build())
                    .real(siReal)
//                    .refType(Collections.singletonList("comparison_equivalenceValueEnCriterion"))
                    .id(comparisonDataModel.getContributions().get(enKey).getContributionId())
                    .build();
            listEn.getQuantity().add(quantity);
        }
        ResultType resultEn = ResultType.builder()
                .name(TextType.builder()
                        .content(Collections.singletonList("Equivalence values"))
                        .build())
                .data(DataType.builder()
                        .list(listEn)
                        .build())
                .refType(Collections.singletonList("comparison_equivalenceValue"))
                .build();
        return resultEn;
    }

    private static ResultType createResultBilateralEn(ComparisonDataModel comparisonDataModel, AnalysisOutput analysisOutput) {
        //-------------- Bilateral EnValues: list of quantities for each row in the matrix
        DccListType bilateralEnList = DccListType.builder().build();

        HashMap<String, HashMap<String, BilateralEnValue>> bilateralEnValues = analysisOutput.getBilateralEnValues();
        for (String bilateralEnKey : bilateralEnValues.keySet()) {
            HashMap<String, BilateralEnValue> bilateralEnValueRow = bilateralEnValues.get(bilateralEnKey);
            RealListXMLListType realListRow = RealListXMLListType.builder().build();
            realListRow.getUnitXMLList().add("\\one");
            for (BilateralEnValue bilateralEnValue : bilateralEnValueRow.values()) {
                realListRow.getValueXMLList().add(bilateralEnValue.getEnValue().getEnValueRaw().getValue());
                realListRow.getLabelXMLList().add(bilateralEnValue.getContributionB());
            }

            String contributionId = bilateralEnValueRow.get("0").getContributionA();
            QuantityType quantity3 = QuantityType.builder()
                    .name(TextType.builder()
                            .content(Collections.singletonList("Bilateral en Matrix row " + bilateralEnKey
                                    + ": " + contributionId))
                            .build())
                    .realListXMLList(realListRow)
                    .refType(Collections.singletonList("comparison_equivalenceValueEnCriterion"))
                    .id(comparisonDataModel.getContributions().get(contributionId).getContributionId())
                    .build();
            bilateralEnList.getQuantity().add(quantity3);
        }
        ResultType resultBilateralEn = ResultType.builder()
                .name(TextType.builder()
                        .content(Collections.singletonList("Bilateral equivalence values"))
                        .build())
                .data(DataType.builder()
                        .list(bilateralEnList)
                        .build())
                .build();
        return resultBilateralEn;
    }

    private ResultType createResultContributionEntityData(ComparisonDataModel comparisonDataModel, EntityUnderComparison entityUnderComparison, String entityKey) {
        DataIdentifier dataIdentifier = entityUnderComparison.getDataIdentifiers().get(entityKey);
        ContributionEntityData entityData = entityUnderComparison.getEntityData().get(entityKey);

        // all contributions are gathered as SiReals in quantity in dcc:list
        DccListType listContrib = DccListType.builder().build();
        for (String contributionKey : entityData.getContributionData().keySet()) {
            SiReal data = entityData.getContributionData().get(contributionKey);
            RealQuantityType siReal = realQuantityTypeFromSiReal(data);

            QuantityType quantity = QuantityType.builder()
                    .name(TextType.builder()
                            .content(Collections.singletonList("Contribution from " + contributionKey))
                            .build())
                    .real(siReal)
                    .refType(Collections.singletonList(dataIdentifier.getRefType()))
                    .id(comparisonDataModel.getContributions().get(contributionKey).getContributionId())
                    .build();
            listContrib.getQuantity().add(quantity);
        }

        ResultType result = ResultType.builder()
                .name(TextType.builder()
                        .content(Collections.singletonList(dataIdentifier.getSiLabel()))
                        .build())
                .data(DataType.builder()
                        .list(listContrib)
                        .build())
                .build();
        return result;
    }

    private MeasurementResultType createMeasurementResultEntity(ComparisonDataModel comparisonDataModel, EntityUnderComparison entityUnderComparison) {
        // ReferenceValue and each entityData get its own dcc:result
        List<ResultType> results = new ArrayList<>();

        AnalysisOutput analysisOutput = entityUnderComparison.getAnalysisOutputs().get(entityUnderComparison.getAnalysisOutputs().size() - 1);

        //---------------- XML Classes for reference Value
        ResultType resultReferenceValue = createResultReferenceValueEnCiterion(analysisOutput);
        results.add(resultReferenceValue);

        // En Values
        ResultType resultEn = createResultEnValues(comparisonDataModel, entityUnderComparison, analysisOutput);
        results.add(resultEn);


        ResultType resultBilateralEn = createResultBilateralEn(comparisonDataModel, analysisOutput);
        results.add(resultBilateralEn);


        //-------------- loop over all entityData and add Quantities to list in dcc:result
        Set<String> entityKeys = entityUnderComparison.getDataIdentifiers().keySet();
        for (String entityKey : entityKeys) {
            ResultType result = createResultContributionEntityData(comparisonDataModel, entityUnderComparison, entityKey);
            results.add(result);
        }


        // build dcc:results
        ResultListType resultList = ResultListType.builder()
                .result(results)
                .build();

        // build dcc:measurementResult
        MeasurementResultType measurementResult = MeasurementResultType.builder()
                .name(TextType.builder()
                        .content(Collections.singletonList("Results for the evaluation of the Comparison"))
                        .build()
                )
                .results(resultList)
                .build();
        return measurementResult;
    }

    public RealQuantityType realQuantityTypeFromSiReal(SiReal siReal) {
        return RealQuantityType.builder()
                .label(siReal.getLabel())
                .value(siReal.getValue())
                .unit(siReal.getUnit())
                .expandedUnc(ExpandedUncType.builder()
                        .uncertainty(siReal.getExpandedMU().getValueExpandedMU())
                        .coverageFactor(siReal.getExpandedMU().getCoverageFactor())
//                        .coverageProbability(siReal.getExpandedMU().getCoverageProbability())
                        .distribution(siReal.getExpandedMU().getDistribution())
                        .build())
                .build();
    }

    public RealQuantityType realQuantityTypeFromEnValue(SiReal siReal) {
        return RealQuantityType.builder()
                .label(siReal.getLabel())
                .value(siReal.getValue())
                .build();
    }

//    private SoftwareListType createSoftwareList(String softwarename, String softwareVersion){
//        TextType softwareName = TextType.builder()
//                .content(Collections.singletonList(softwarename))
//                .build();
//        SoftwareType software = SoftwareType.builder()
//                .name(softwareName)
//                .release(softwareVersion)
//                .build();
//        SoftwareListType softwareList = SoftwareListType.builder()
//                .software(Arrays.asList(software))
//                .build();
//
//        return softwareList;
//    }

//    private CoreDataType createCoreData(String identificationIssuer, String identificaionValue,
//                                        String coreDataCountryCode, String coreDataUniqueIdentifier) throws DatatypeConfigurationException {
//        IdentificationType identification = IdentificationType.builder()
//                .issuer(identificationIssuer)
//                .value(identificaionValue)
//                .build();
//        IdentificationListType identificationList = IdentificationListType.builder()
//                .identification(Arrays.asList(identification)).build();
//
//        Date date = new Date();
//
//        CoreDataType coreData = CoreDataType.builder()
//                .countryCodeISO31661(coreDataCountryCode)
//                .usedLangCodeISO6391(Collections.singletonList("en"))
//                .mandatoryLangCodeISO6391(Collections.singletonList("en"))
//                .uniqueIdentifier(coreDataUniqueIdentifier)
//                .identifications(identificationList)
//                .beginPerformanceDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(new SimpleDateFormat(LocalDate.now().toString()).format(date)))
//                .endPerformanceDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(new SimpleDateFormat(LocalDate.now().toString()).format(date)))
//                .performanceLocation(PerformanceLocationType.builder().value(StringPerformanceLocationType.LABORATORY).build())
//                .build();
//        return coreData;
//    }

//    private ItemListType createItemListMass(){
//        TextType itemName1 = TextType.builder()
//                .content(Collections.singletonList("1kg Silicon Sphere"))
////                .lang("en")
//                .build();
//        IdentificationType identificationItem1 = IdentificationType.builder()
//                .issuer("calibrationLaboratory")
//                .value("An Identification")
//                .build();
//        IdentificationListType identificationItemList1 = IdentificationListType.builder()
//                .identification(Arrays.asList(identificationItem1)).build();
//        TextType manufacturerName = TextType.builder()
//                .content(Collections.singletonList("NMIJ"))
//                .build();
////TODO "lang=en"
//        ContactNotStrictType manufacturer= ContactNotStrictType.builder()
//                .name(manufacturerName)
//                .build();
//        ItemType item1= ItemType.builder()
//                .name(itemName1)
//                .manufacturer(manufacturer)
//                .identifications(identificationItemList1)
//                .build();
//        ItemListType items = ItemListType.builder()
//                .name(itemName1)
//                .item(Arrays.asList(item1))
//                .build();
//
//        return items;
//    }

//    private CalibrationLaboratory createCalibrationLaboratoryMass(){
//        ContactType contact = ContactType.builder()
//                .name(TextType.builder().content(Collections.singletonList("Pilot Laboratory")).build())
//                .eMail("info@nmij.jp")
//                .location(LocationType.builder().city("Tokyo").build())
//                .build();
//        CalibrationLaboratory calibrationLaboratory = CalibrationLaboratory.builder()
//                .contact(contact)
//                .build();
//        return calibrationLaboratory;
//    }
//
//    private ContactType createCustomerMass(){
//        TextType customerName = TextType.builder()
//                .content(Collections.singletonList("Kenichi Fuji"))
//                .build();
//        ContactType customer = ContactType.builder()
//                .name(customerName)
//                .eMail("k.f@NMILJ.jp")
//                .location(LocationType.builder().city("Tokyo").build())
//                .build();
//        return customer;
//    }
//
//    private RespPersonListType createRespPersonListMass(){
//        TextType respPersonName = TextType.builder()
//                .content(Collections.singletonList("A Person"))
//                .build();
//        RespPersonType respPerson = RespPersonType.builder()
//                .person(ContactNotStrictType.builder()
//                        .name(respPersonName).build())
//                .build();
//        RespPersonListType respPersons= RespPersonListType.builder()
//                .respPerson(Arrays.asList(respPerson))
//                .build();
//        return respPersons;
//    }
}

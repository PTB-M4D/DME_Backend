package de.ptb.dsi.dme_backend.service.output;


import de.ptb.dsi.dme_backend.model.*;
import de.ptb.dsi.dme_backend.model.dcc.*;
import de.ptb.dsi.dme_backend.model.dsi.Test;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.*;


@Service
@AllArgsConstructor
public class DccServiceOutputWriter {

    public RealQuantityType realQuantityTypeFromSiReal(SiReal siReal){
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

    public RealQuantityType realQuantityTypeFromEnValue(SiReal siReal){
        return RealQuantityType.builder()
                .label(siReal.getLabel())
                .value(siReal.getValue())
                .build();
    }

    public String createMeasurementResults(ComparisonDataModel comparisonDataModel) throws JAXBException {

        // loop over each EntityUnderComparison. Every Entity as it's own dcc:measurementResult
        List<MeasurementResultType> measurementResults = new ArrayList<>();
        for (EntityUnderComparison entityUnderComparison : comparisonDataModel.getEntities().values()){

            // ReferenceValue and each entityData get it's own dcc:result
            List<ResultType> results = new ArrayList<>();

            AnalysisOutput analysisOutput = entityUnderComparison.getAnalysisOutputs().get(entityUnderComparison.getAnalysisOutputs().size()-1);

            //---------------- XML Classes for reference Value
            RealQuantityType referenceValue = realQuantityTypeFromSiReal(analysisOutput.getRefValue().getSiReal());

            // quantity for reference Value
            QuantityType quantityReferenceValue = QuantityType.builder()
                    .name(TextType.builder()
                            .content(Collections.singletonList("Comparison Reference Value (En Criterion)"))
                            .build())
                    .real(referenceValue)
                    .refType(Collections.singletonList("basic_referencevalue"))
                    .build();

            ResultType resultReferenceValue = ResultType.builder()
                    .name(TextType.builder()
                            .content(Collections.singletonList("Temperature reference value at nominal temperature of 34.5 °C"))
                            .build())
                    .data(DataType.builder()
                            .quantity(quantityReferenceValue)
                            .build())
                    .build();
            results.add(resultReferenceValue);

            //-------------- loop over all enValues in analysisoutput. EnValues get seperate dcc:result
            DccListType listEn = DccListType.builder().build();
            for (String enKey : analysisOutput.getEnValues().keySet()){
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
                        .refType(Collections.singletonList("comparison_equivalenceValue"))
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
                    .build();
            results.add(resultEn);


            //-------------- Bilateral EnValues: list of quantities for each row in the matrix
            DccListType bilateralEnList = DccListType.builder().build();

            HashMap<String, HashMap<String, BilateralEnValue>> bilateralEnValues = analysisOutput.getBilateralEnValues();
            for (String bilateralEnKey: bilateralEnValues.keySet()){
                HashMap<String, BilateralEnValue> bilateralEnValueRow = bilateralEnValues.get(bilateralEnKey);
                RealListXMLListType realListRow = RealListXMLListType.builder().build();
                realListRow.getUnitXMLList().add("\\one");
                for (BilateralEnValue bilateralEnValue : bilateralEnValueRow.values()){
                    realListRow.getValueXMLList().add(bilateralEnValue.getEnValue().getEnValueRaw().getValue());
                    realListRow.getLabelXMLList().add(bilateralEnValue.getContributionB());
                }
                QuantityType quantity = QuantityType.builder()
                        .name(TextType.builder()
                                .content(Collections.singletonList("Bilateral en Matrix row " + bilateralEnKey
                                        + ": " + bilateralEnValueRow.get("0").getContributionA()))
                                .build())
                        .realListXMLList(realListRow)
                        .refType(Collections.singletonList("comparison_equivalenceValueEnCriterion"))
                        .build();
                bilateralEnList.getQuantity().add(quantity);
            }
            ResultType resultBilateralEn = ResultType.builder()
                    .name(TextType.builder()
                            .content(Collections.singletonList("Bilateral equivalence values"))
                            .build())
                    .data(DataType.builder()
                            .list(bilateralEnList)
                            .build())
                    .build();
            results.add(resultBilateralEn);





            //-------------- loop over all entityData and add Quantities to list in dcc:result
            Set<String> entityKeys = entityUnderComparison.getDataIdentifiers().keySet();
            for (String entityKey : entityKeys){
                DataIdentifier dataIdentifier = entityUnderComparison.getDataIdentifiers().get(entityKey);
                ContributionEntityData entityData = entityUnderComparison.getEntityData().get(entityKey);

                // all contributions are gathered as SiReals in quantity in dcc:list
                DccListType listContrib = DccListType.builder().build();
                for (String contributionKey : entityData.getContributionData().keySet()){
                    SiReal data = entityData.getContributionData().get(contributionKey);
                    RealQuantityType siReal = realQuantityTypeFromSiReal(data);

                    QuantityType quantity = QuantityType.builder()
                            .name(TextType.builder()
                                    .content(Collections.singletonList("Contribution from " + contributionKey))
                                    .build())
                            .real(siReal)
                            .refType(Collections.singletonList(dataIdentifier.getRefType()))
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
            measurementResults.add(measurementResult);
        }

        // build measurementResults and create dcc:calibrationCertificate
        MeasurementResultListType measurementResultList = MeasurementResultListType.builder()
                .measurementResult(measurementResults)
                .build();

        DigitalCalibrationCertificateType certificate = DigitalCalibrationCertificateType.builder()
                .schemaVersion("3.2.1")
                .measurementResults(measurementResultList)
                .build();

        JAXBContext context = JAXBContext.newInstance(DigitalCalibrationCertificateType.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "https://ptb.de/dcc https://ptb.de/dcc/v3.2.1/dcc.xsd");
        StringWriter writer = new StringWriter();
        marshaller.marshal(certificate, writer);
        return writer.toString();
    }

    public String getOutputReport() throws JAXBException, DatatypeConfigurationException {
//        DataType dataType = DataType.builder()
//                .id("blackbody01").build();
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
        IdentificationType identificationCore = IdentificationType.builder()
                .issuer("calibrationLaboratory")
                .value("20096653")
                .build();
        IdentificationListType identificationCoreList = IdentificationListType.builder()
                .identification(Arrays.asList(identificationCore)).build();
        Date date = new Date();
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++CoreData+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        CoreDataType coreData = CoreDataType.builder()
                .countryCodeISO31661("DE")
                .usedLangCodeISO6391(Collections.singletonList("en"))
                .mandatoryLangCodeISO6391(Collections.singletonList("en"))
                .uniqueIdentifier("Temp")
                .identifications(identificationCoreList)
                .beginPerformanceDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(new SimpleDateFormat(LocalDate.now().toString()).format(date)))
                .endPerformanceDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(new SimpleDateFormat(LocalDate.now().toString()).format(date)))
//                .performanceLocation(PerformanceLocationType.builder().value(StringPerformanceLocationType.LABORATORY))
                .build();
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
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++AdministrativeData-ITEMS+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        TextType itemName1 = TextType.builder()
                .id("blackbody01")
                .content(Collections.singletonList("blackbody transfer standard: cavity 1"))
                .build();
        TextType itemName2 = TextType.builder()
                .content(Collections.singletonList("blackbody transfer standard: cavity 2"))
                .build();
        ItemType item1= ItemType.builder()
                .name(itemName1)
                .id("blackbody01")
                .identifications(identificationItemList)
                .build();
        ItemType item2= ItemType.builder()
                .name(itemName2)
                .id("blackbody02")
                .identifications(identificationItemList)
                .build();
        ItemListType items = ItemListType.builder()
                .identifications(identificationItemList)
                .item(Arrays.asList(item1,item2))
                .build();

        CalibrationLaboratory calibrationLaboratory = CalibrationLaboratory.builder()
                .contact(contact)
                .build();
        LocationType location= new LocationType();

        TextType customerName = TextType.builder()
                .content(Collections.singletonList("EURAMET Pilot CCT K11 Consultative Committee for Temperature PTB Berlin"))
                .build();
        ContactType customer=ContactType.builder()
                .name(customerName)
                .location(location)
                .build();
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++AdministrativeData_RespPersonList+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

        TextType respPersonName = TextType.builder()
                .content(Collections.singletonList("Ingmar Mueller"))
                .build();
        RespPersonType respPerson = RespPersonType.builder()
                .person(ContactNotStrictType.builder()
                        .name(respPersonName).build())
                .build();
        RespPersonListType respPersons= RespPersonListType.builder()
                .respPerson(Arrays.asList(respPerson))
                .build();
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++AdministrativeDataType++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        AdministrativeDataType administrativeData = AdministrativeDataType.builder()
                .dccSoftware(softwareList)
                .coreData(coreData)
                .items(items)
                .calibrationLaboratory(calibrationLaboratory)
                .customer(customer)
                .respPersons(respPersons)
                .build();

//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++MeasurementResults-----------------------------------------------
        MeasurementResultType result1 = MeasurementResultType.builder()
                .id("Temp_Comparison_PTB_1")
                .name(TextType.builder().content(Collections.singletonList("Comparison data of participant laboratory")).build())
                .build();
        MeasurementResultListType measurementResults = MeasurementResultListType.builder()
                .measurementResult(Arrays.asList(result1))
                .build();
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++DigitalCalibrationCertificate+++++++++++++++++++++++++++++++++++++++++++++++++++

        DigitalCalibrationCertificateType certificate = DigitalCalibrationCertificateType.builder()
                .schemaVersion("3.2.1")
                .administrativeData(administrativeData)
                .measurementResults(measurementResults)
                .build();
        System.out.println("dcc" + certificate);
//        Test test = new Test();
//        test.setSchemaVersion("123");
//        test.setModel("model");
////        Test.builder().schemaVersion("1.2.3").build();
//        JAXBContext context1 = JAXBContext.newInstance(Test.class);
//        Marshaller marshaller1 = context1.createMarshaller();
//        marshaller1.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//        marshaller1.setProperty(Marshaller.JAXB_FRAGMENT, true);
//      //  marshaller1.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "https://ptb.de/si");
//        marshaller1.marshal(test, System.out);

        JAXBContext context = JAXBContext.newInstance(DigitalCalibrationCertificateType.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "https://ptb.de/dcc https://ptb.de/dcc/v3.2.1/dcc.xsd");
        StringWriter writer = new StringWriter();
        marshaller.marshal(certificate, writer);
        return writer.toString();
    }
}

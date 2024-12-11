package de.ptb.dsi.dme_backend.service.output;


import de.ptb.dsi.dme_backend.model.*;
import de.ptb.dsi.dme_backend.model.dcc.*;
import jakarta.xml.bind.JAXBContext;
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

    public String createMeasurementResults(ComparisonDataModel comparisonDataModel) throws JAXBException {
        // loop over each EntityUnderComparison

        QuantityType quantity = QuantityType.builder().build();
        for (EntityUnderComparison entityUnderComparison : comparisonDataModel.getEntities().values()){

            // XML Classes for refValue and EnValues
            AnalysisOutput analysisOutput = entityUnderComparison.getAnalysisOutputs().get(entityUnderComparison.getAnalysisOutputs().size()-1);

            // reference Value
            RealQuantityType referenceValue = realQuantityTypeFromSiReal(analysisOutput.getRefValue().getSiReal());

            // quantity for reference Value
            QuantityType quantityReferenceValue = QuantityType.builder()
                    .name(TextType.builder()
                            .content(Collections.singletonList("Comparison Reference Value (En Criterion)"))
                            .build())
                    .real(referenceValue)
                    .refType(Collections.singletonList("basic_referencevalue"))
                    .build();

            quantity = quantityReferenceValue;
        }

//        QuantityType quantity = QuantityType.builder().build();
        ResultType result = ResultType.builder()
                .name(TextType.builder()
                        .content(Collections.singletonList("Temperature reference value at nominal temperature of 34.5 °C"))
                        .build())
                .data(DataType.builder()
                        .quantity(quantity)
                        .build())
                .build();

        ResultListType results = ResultListType.builder()
                .result(Collections.singletonList(result))
                .build();


        MeasurementResultType measurementResult = MeasurementResultType.builder()
                .name(TextType.builder()
                        .content(Collections.singletonList("Comparison reference values for each nominal temperature"))
                        .build()
                )
                .results(results)
                .build();

        MeasurementResultListType measurementResults = MeasurementResultListType.builder()
                .measurementResult(Collections.singletonList(measurementResult))
                .build();

        DigitalCalibrationCertificateType certificate = DigitalCalibrationCertificateType.builder()
                .schemaVersion("3.2.1")
                .measurementResults(measurementResults)
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
        DataType dataType = DataType.builder()
                .id("123").build();
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
//                .performanceLocation(PerformanceLocationType.builder().value(StringPerformanceLocationType.LABORATORY)
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
                .content(Collections.singletonList("blackbody transfer standard: cavity 1"))
                .build();
        TextType itemName2 = TextType.builder()
                .content(Collections.singletonList("blackbody transfer standard: cavity 2"))
                .build();
        ItemType item1= ItemType.builder()
                .name(itemName1)
                .identifications(identificationItemList)
                .build();
        ItemType item2= ItemType.builder()
                .name(itemName2)
                .identifications(identificationItemList)
                .build();
        ItemListType items = ItemListType.builder()
                .identifications(identificationItemList)
                .item(Arrays.asList(item1,item2))
                .build();

        CalibrationLaboratory calibrationLaboratory = CalibrationLaboratory.builder()
                .contact(contact)
                .build();
        TextType customerName = TextType.builder()
                .content(Collections.singletonList("EURAMET Pilot CCT K11 Consultative Committee for Temperature PTB Berlin"))
                .build();
        ContactType customer=ContactType.builder()
                .name(customerName)
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
                .build();

//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++MeasurementResults-----------------------------------------------
        MeasurementResultType result1 = MeasurementResultType.builder()
                .id("Temp_Comparison_PTB_1")
                .name(TextType.builder().content(Collections.singletonList("Comparison data of participant laboratory")).build())
                .build();

        MeasurementResultListType measurementResults = MeasurementResultListType.builder()
                .measurementResult(Arrays.asList(result1))
                .build();

        DigitalCalibrationCertificateType certificate = DigitalCalibrationCertificateType.builder()
                .schemaVersion("3.2.1")
                .administrativeData(administrativeData)
                .measurementResults(measurementResults)
                .build();


        System.out.println("dcc" + certificate);

        JAXBContext context = JAXBContext.newInstance(DigitalCalibrationCertificateType.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "https://ptb.de/dcc https://ptb.de/dcc/v3.2.1/dcc.xsd");
        StringWriter writer = new StringWriter();
        marshaller.marshal(certificate, writer);
        return writer.toString();
    }
}

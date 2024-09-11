package de.ptb.dsi.dme_backend.model;

import lombok.Data;

import java.util.List;

@Data
public class ComparisonDataModel {
   private List<ParticipantMeasuredValue> participantMeasuredValueList;//contributorList
   private List<ParticipantMeasuredValue> outliers;
   private List<AnalysisOutput> analysisOutputData;
//   private ReferenceValue referenceValue;
//   private List<EquivalenceValues> equivalenceValueList;
//   List of iteration en

}
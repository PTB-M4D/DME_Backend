package de.ptb.dsi.dme_backend.model;

import lombok.Data;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;

@Data
public class ComparisonDataModel {
   private HashMap<String, Contribution> contributions;//contributorList
   private HashMap<String,EntityUnderComparison> entities;//key entityId   z.B. "mass"
   private String pidReport;
   private String smartStandard;


   public ComparisonDataModel(){
      this.contributions = new HashMap<>();
      this.entities = new HashMap<>();
   }
}
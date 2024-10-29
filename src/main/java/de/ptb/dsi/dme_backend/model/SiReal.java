package de.ptb.dsi.dme_backend.model;


import lombok.Data;

@Data
public class SiReal {
    private Long id;
    private String name;
    private Double value;
    private String unit;
    private String dateTime;
    private Double expandedUncertainty;
    //private SiExpandedUnc expandedUncertainty;

    public SiReal(){}

    public SiReal(Double value, Double expandedUncertainty){
        this.value = value;
        this.expandedUncertainty = expandedUncertainty;
    }

    //TODO: Remove this temporary code when SiExpandedUncertainty has been implemented?
    /**
     * Returns the standard uncertainty using the expanded uncertainty
     * @return standard uncertainty
     */
    public Double getStandardUncertainty(){
        return expandedUncertainty /2;
    }

    /**
     * Sets the expanded uncertainty using the standard uncertainty
     */
    public void setStandardUncertainty(Double standardUncertainty){
        this.expandedUncertainty = standardUncertainty * 2;
    }
}

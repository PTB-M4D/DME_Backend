package de.ptb.dsi.dme_backend.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema
public class OutputReport {
    private String  fileName;
    private String base64String;
    @Override
    public String toString() {
        return "DKCRResponseMessage{" +
                "fileName='" + fileName +'\'' +
                ", base64String='" + base64String + '\'' +
                '}';
    }
}




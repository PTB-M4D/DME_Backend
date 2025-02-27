package de.ptb.dsi.dme_backend.service.plot;

import org.jfree.chart.JFreeChart;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Map;

public class ChartConverter {
    //Conversion from chart to base64
    public static String chartToBase64(JFreeChart chart, int width, int height) {
        try {
            //Create image object from the chart
            BufferedImage image = chart.createBufferedImage(width, height);

            //Image to ByteStream conversion
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ImageIO.write(image, "png", outputStream);
            byte[] imageBytes = outputStream.toByteArray();

            //ByteStream to Base64 conversion
            return Base64.getEncoder().encodeToString(imageBytes);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //Encode the chart to Base64 including the filename and data as json
    public static String chartToBase64WithFilename(JFreeChart chart, int width, int height, String filename) {
        try {
            //Create image object from the chart
            BufferedImage image = chart.createBufferedImage(width, height);

            //Image to ByteStream Conversion
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ImageIO.write(image, "png", outputStream);
            byte[] imageBytes = outputStream.toByteArray();

            // Encode Base64
            String base64Data = Base64.getEncoder().encodeToString(imageBytes);

            //Convert JSON-Object to Map
            Map<String, String> jsonMap = Map.of(
                    "filename", filename,
                    "data", base64Data
            );

            //Convert JSON to String
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonMap);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //Decode the Base64 and save it using its included filename
    public static void Base64WithFilenameToNamedImage(String jsonString) {
        try {
            //Convert JSON-String to Map
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, String> jsonMap = objectMapper.readValue(jsonString, new TypeReference<Map<String, String>>() {
            });

            //Grab filename and data
            String filename = jsonMap.get("filename");
            String base64Data = jsonMap.get("data");

            //Decode data
            byte[] decodedBytes = Base64.getDecoder().decode(base64Data);

            //TODO Save file (zip?)
            Files.write(Paths.get(filename), decodedBytes);
            System.out.println("File saved as " + filename);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
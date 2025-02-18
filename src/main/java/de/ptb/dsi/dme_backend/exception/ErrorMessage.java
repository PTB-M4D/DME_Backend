package de.ptb.dsi.dme_backend.exception;


import java.util.Date;

public record ErrorMessage(int statusCode,Date timestamp,String message,String description) {
    public ErrorMessage(int statusCode, Date timestamp, String message, String description) {
        this.statusCode = statusCode;
        this.timestamp = timestamp;
        this.message = message;
        this.description = description;
    }
}

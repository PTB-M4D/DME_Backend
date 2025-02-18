package de.ptb.dsi.dme_backend.exception;

import lombok.NoArgsConstructor;


public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String msg) {
        super(msg);
    }

}

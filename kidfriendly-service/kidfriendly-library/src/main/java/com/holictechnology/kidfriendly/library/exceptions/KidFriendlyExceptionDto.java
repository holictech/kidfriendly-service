package com.holictechnology.kidfriendly.library.exceptions;


import java.io.Serializable;


public class KidFriendlyExceptionDto implements Serializable {

    private static final long serialVersionUID = -6543024762660313322L;

    private String message;

    public KidFriendlyExceptionDto(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

package com.holictechnology.kidfriendly.domain.dtos.exception;


import java.io.Serializable;


public class ExceptionDto implements Serializable {

    private static final long serialVersionUID = -6543024762660313322L;

    private String message;

    public ExceptionDto(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

package com.holictechnology.kidfriendly.library.messages;


public enum KidFriendlyConstraintViolationEnum {

    UQ_DS_EMAIL("E-mail já cadastrado.");

    private String message;

    private KidFriendlyConstraintViolationEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

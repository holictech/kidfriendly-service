package com.holictechnology.kidfriendly.library.messages;

public enum KidFriendlyUniqueEnum {
    
    UQ_DS_EMAIL("E-mail já cadastrado.");
    
    private String message;
    
    private KidFriendlyUniqueEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}

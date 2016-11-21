package com.holictechnology.kidfriendly.domain.enums;


public enum StatusKidFriendlyEnum {

    NOTHING(Short.valueOf("1")), A_LITTLE(Short.valueOf("2")), NORMAL(Short.valueOf("3")), SUPER(Short.valueOf("4"));

    private Short idStatusKidFriendly;

    private StatusKidFriendlyEnum(Short idStatusKidFriendly) {
        this.idStatusKidFriendly = idStatusKidFriendly;
    }

    public Short getIdStatusKidFriendly() {
        return idStatusKidFriendly;
    }

    public static StatusKidFriendlyEnum valueOf(Short idStatusKidFriendly) {
        StatusKidFriendlyEnum statusKidFriendlyEnum = null;

        if (idStatusKidFriendly != null) {
            for (StatusKidFriendlyEnum _statusKidFriendlyEnum : StatusKidFriendlyEnum.values()) {
                if (_statusKidFriendlyEnum.getIdStatusKidFriendly().equals(idStatusKidFriendly)) {
                    statusKidFriendlyEnum = _statusKidFriendlyEnum;
                    break;
                }
            }
        }

        return statusKidFriendlyEnum;
    }
}

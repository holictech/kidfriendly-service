package com.holictechnology.kidfriendly.domain.enumerator;


import com.holictechnology.kidfriendly.domain.enumerator.interfaces.IEnum;


public enum StatusKidFriendlyEnum implements IEnum {

    NOTHING(Short.valueOf("1")), A_LITTLE(Short.valueOf("2")), NORMAL(Short.valueOf("3")), SUPER(Short.valueOf("4"));

    private Short value;

    /**
     * @param value
     */
    private StatusKidFriendlyEnum(final Short value) {
        this.value = value;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.holictechnology.kidfriendly.domain.enumerator.interfaces.IEnum#
     * getValue()
     */
    @Override
    public Short getValue() {
        return value;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.holictechnology.kidfriendly.domain.enumerator.interfaces.IEnum#
     * getDescription()
     */
    @Override
    public String getDescription() {
        return null;
    }

    /**
     * @param value
     * @return
     */
    public static StatusKidFriendlyEnum valueOf(Short value) {
        StatusKidFriendlyEnum statusKidFriendlyEnum = null;

        if (value != null) {
            for (StatusKidFriendlyEnum _statusKidFriendlyEnum : values()) {
                if (_statusKidFriendlyEnum.getValue().equals(value)) {
                    statusKidFriendlyEnum = _statusKidFriendlyEnum;
                    break;
                }
            }
        }

        return statusKidFriendlyEnum;
    }
}

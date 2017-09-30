package com.holictechnology.kidfriendly.domain.enumerator;


import com.holictechnology.kidfriendly.domain.enumerator.interfaces.IEnum;


public enum TypePhoneEnum implements IEnum {

    CELL_PHONE(Short.valueOf("1")), COMMERCIAL(Short.valueOf("2")), RESIDENTIAL(Short.valueOf("3"));

    private Short value;

    /**
     * @param value
     * @param description
     */
    private TypePhoneEnum(final Short value) {
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
    public static TypePhoneEnum valueOf(Short value) {
        TypePhoneEnum typePhoneEnum = null;

        if (value != null) {
            for (TypePhoneEnum _typePhoneEnum : values()) {
                if (_typePhoneEnum.getValue().equals(value)) {
                    typePhoneEnum = _typePhoneEnum;
                    break;
                }
            }
        }

        return typePhoneEnum;
    }
}

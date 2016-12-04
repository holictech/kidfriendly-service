package com.holictechnology.kidfriendly.domain.enums;


import com.holictechnology.kidfriendly.domain.enums.interfaces.IEnum;


public enum TypePhoneEnum implements IEnum {

    CELL_PHONE(Short.valueOf("1"), "Celular"), COMMERCIAL(Short.valueOf("2"), "Comercial"), RESIDENTIAL(Short.valueOf("3"), "Residencial");

    private Short value;
    private String description;

    /**
     * @param value
     * @param description
     */
    private TypePhoneEnum(final Short value, final String description) {
        this.value = value;
        this.description = description;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.holictechnology.kidfriendly.domain.enums.interfaces.Enumerator#
     * getValue()
     */
    @Override
    public Short getValue() {
        return value;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.holictechnology.kidfriendly.domain.enums.interfaces.Enumerator#
     * getDescription()
     */
    @Override
    public String getDescription() {
        return description;
    }

    /**
     * @param value
     * @return
     */
    public static TypePhoneEnum valueOf(Short value) {
        TypePhoneEnum typePhoneEnum = null;

        if (value != null) {
            for (TypePhoneEnum _typePhoneEnum : TypePhoneEnum.values()) {
                if (_typePhoneEnum.getValue().equals(value)) {
                    typePhoneEnum = _typePhoneEnum;
                    break;
                }
            }
        }

        return typePhoneEnum;
    }
}

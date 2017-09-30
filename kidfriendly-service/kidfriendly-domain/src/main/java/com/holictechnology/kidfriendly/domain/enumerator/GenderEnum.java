package com.holictechnology.kidfriendly.domain.enumerator;


import com.holictechnology.kidfriendly.domain.enumerator.interfaces.IEnum;


public enum GenderEnum implements IEnum {

    MALE('M'), FEMALE('F');

    private Character value;

    private GenderEnum(Character value) {
        this.value = value;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.holictechnology.kidfriendly.domain.enumerator.interfaces.IEnum#
     * getValue()
     */
    @Override
    public Character getValue() {
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
    public static GenderEnum valueOf(Character value) {
        GenderEnum genderEnum = null;

        if (value != null) {
            for (GenderEnum _genderEnum : values()) {
                if (_genderEnum.getValue().equals(value)) {
                    genderEnum = _genderEnum;
                    break;
                }
            }
        }

        return genderEnum;
    }
}

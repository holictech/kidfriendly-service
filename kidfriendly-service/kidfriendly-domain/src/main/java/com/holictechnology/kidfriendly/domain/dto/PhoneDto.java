package com.holictechnology.kidfriendly.domain.dto;


import com.holictechnology.kidfriendly.domain.enumerator.TypePhoneEnum;


public class PhoneDto {

    private Integer idPhone;
    private TypePhoneEnum typePhoneEnum;
    private String numPhone;

    public Integer getIdPhone() {
        return idPhone;
    }

    public void setIdPhone(Integer idPhone) {
        this.idPhone = idPhone;
    }

    public TypePhoneEnum getTypePhoneEnum() {
        return typePhoneEnum;
    }

    public void setTypePhoneEnum(TypePhoneEnum typePhoneEnum) {
        this.typePhoneEnum = typePhoneEnum;
    }

    public String getNumPhone() {
        return numPhone;
    }

    public void setNumPhone(String numPhone) {
        this.numPhone = numPhone;
    }

}

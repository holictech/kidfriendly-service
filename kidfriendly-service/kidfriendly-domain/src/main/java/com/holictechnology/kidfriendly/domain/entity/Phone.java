package com.holictechnology.kidfriendly.domain.entity;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.holictechnology.kidfriendly.domain.enumerator.TypePhoneEnum;
import com.holictechnology.kidfriendly.library.hibernate.EnumUserType;


@Entity
@Table(name = "PHONE")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idPhone", scope = Phone.class)
public class Phone implements Serializable {

    private static final long serialVersionUID = 5566522984253149293L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PHONE", nullable = false, unique = true)
    private Integer idPhone;

    @Type(type = "com.holictechnology.kidfriendly.library.hibernate.EnumUserType", parameters = {
            @Parameter(name = EnumUserType.PACKAGE_ENUM, value = "com.holictechnology.kidfriendly.domain.enumerator.TypePhoneEnum")
    })
    @Column(name = "NUM_TYPE_PHONE", nullable = false)
    private TypePhoneEnum typePhoneEnum;

    @Column(name = "NUM_PHONE", nullable = false, length = 15)
    private String numPhone;

    @JsonIdentityReference(alwaysAsId = true)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_COMPANY", nullable = false)
    private Company company;

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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}

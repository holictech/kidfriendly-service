package com.holictechnology.kidfriendly.domain.entitys;


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

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name = "PHONE", schema = "sistemap_kidfriendly")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idPhone", scope = Phone.class)
public class Phone implements Serializable {

    private static final long serialVersionUID = 5566522984253149293L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PHONE", nullable = false, unique = true)
    private Integer idPhone;

    @Column(name = "DES_TYPE_PHONE", nullable = false, length = 45)
    private String desTypePhone;

    @Column(name = "NUM_PHONE", nullable = false, unique = true)
    private String numPhone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_COMPANY", nullable = false)
    private Company company;

    public Integer getIdPhone() {
        return idPhone;
    }

    public void setIdPhone(Integer idPhone) {
        this.idPhone = idPhone;
    }

    public String getDesTypePhone() {
        return desTypePhone;
    }

    public void setDesTypePhone(String desTypePhone) {
        this.desTypePhone = desTypePhone;
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

    @JsonIdentityReference(alwaysAsId = true)
    public void setCompany(Company company) {
        this.company = company;
    }
}

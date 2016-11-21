package com.holictechnology.kidfriendly.domain.entitys;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name = "COUNTRY", schema = "sistemap_kidfriendly")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idCountry", scope = Country.class)
public class Country implements Serializable {

    private static final long serialVersionUID = -2430683484381039391L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_COUNTRY", nullable = false, unique = true)
    private Integer idCountry;

    @Column(name = "DES_COUNTRY", nullable = false, length = 45)
    private String desCountry;

    public Integer getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(Integer idCountry) {
        this.idCountry = idCountry;
    }

    public String getDesCountry() {
        return desCountry;
    }

    public void setDesCountry(String desCountry) {
        this.desCountry = desCountry;
    }
}

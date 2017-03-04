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
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name = "STATE")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idState", scope = State.class)
public class State implements Serializable {

    private static final long serialVersionUID = -1437352477659466902L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_STATE", nullable = false, unique = true)
    private Integer idState;

    @Column(name = "DES_STATE", nullable = false, length = 50)
    private String desState;

    @Column(name = "DES_SIGLA", nullable = false, length = 2)
    private String desSigla;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_COUNTRY", nullable = false)
    private Country country;

    public Integer getIdState() {
        return idState;
    }

    public void setIdState(Integer idState) {
        this.idState = idState;
    }

    public String getDesState() {
        return desState;
    }

    public void setDesState(String desState) {
        this.desState = desState;
    }

    public String getDesSigla() {
        return desSigla;
    }

    public void setDesSigla(String desSigla) {
        this.desSigla = desSigla;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}

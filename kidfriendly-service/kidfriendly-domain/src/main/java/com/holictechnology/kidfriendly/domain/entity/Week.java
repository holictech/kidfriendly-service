package com.holictechnology.kidfriendly.domain.entity;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name = "WEEK")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idWeek", scope = Week.class)
public class Week implements Serializable {

    private static final long serialVersionUID = 1472981879928602217L;

    @Id
    @Column(name = "ID_WEEK", nullable = false, unique = true)
    private Long idWeek;

    @Column(name = "DS_WEEK", nullable = false, length = 80)
    private String dsWeek;

    public Long getIdWeek() {
        return idWeek;
    }

    public void setIdWeek(Long idWeek) {
        this.idWeek = idWeek;
    }

    public String getDsWeek() {
        return dsWeek;
    }

    public void setDsWeek(String dsWeek) {
        this.dsWeek = dsWeek;
    }
}

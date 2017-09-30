package com.holictechnology.kidfriendly.domain.entity;


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
@Table(name = "SCHEDULE")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idSchedule", scope = Schedule.class)
public class Schedule implements Serializable {

    private static final long serialVersionUID = 7133123695507654399L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_SCHEDULE", nullable = false, unique = true)
    private Long idSchedule;

    @Column(name = "DS_SCHEDULE", nullable = false, length = 10)
    private String dsSchedule;

    public Long getIdSchedule() {
        return idSchedule;
    }

    public void setIdSchedule(Long idSchedule) {
        this.idSchedule = idSchedule;
    }

    public String getDsSchedule() {
        return dsSchedule;
    }

    public void setDsSchedule(String dsSchedule) {
        this.dsSchedule = dsSchedule;
    }
}

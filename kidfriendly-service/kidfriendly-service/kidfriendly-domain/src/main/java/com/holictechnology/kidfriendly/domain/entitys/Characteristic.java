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
@Table(name = "CHARACTERISTIC", schema = "sistemap_kidfriendly")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idCharacteristic", scope = Characteristic.class)
public class Characteristic implements Serializable {

    private static final long serialVersionUID = -6836581866966503934L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CHARACTERISTIC", nullable = false, unique = true)
    private Integer idCharacteristic;

    @Column(name = "DES_CHARACTERISTIC", nullable = false, length = 100)
    private String desCharacteristic;

    public Integer getIdCharacteristic() {
        return idCharacteristic;
    }

    public void setIdCharacteristic(Integer idCharacteristic) {
        this.idCharacteristic = idCharacteristic;
    }

    public String getDesCharacteristic() {
        return desCharacteristic;
    }

    public void setDesCharacteristic(String desCharacteristic) {
        this.desCharacteristic = desCharacteristic;
    }
}

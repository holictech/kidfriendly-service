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
@Table(name = "FOOD_TYPE")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idFoodType", scope = FoodType.class)
public class FoodType implements Serializable {

    private static final long serialVersionUID = -3632263560823822336L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_FOOD_TYPE", nullable = false, unique = true)
    private Long idFoodType;

    @Column(name = "DS_FOOD_TYPE", nullable = false, length = 200)
    private String dsFoodType;

    public Long getIdFoodType() {
        return idFoodType;
    }

    public void setIdFoodType(Long idFoodType) {
        this.idFoodType = idFoodType;
    }

    public String getDsFoodType() {
        return dsFoodType;
    }

    public void setDsFoodType(String dsFoodType) {
        this.dsFoodType = dsFoodType;
    }
}

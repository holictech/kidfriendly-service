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
@Table(name = "CATEGORY")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idCategory", scope = Category.class)
public class Category implements Serializable {

    private static final long serialVersionUID = 3180067818970738965L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CATEGORY", nullable = false, unique = true)
    private Integer idCategory;

    @Column(name = "DES_CATEGORY", nullable = false, length = 100)
    private String desCategory;

    public Integer getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
    }

    public String getDesCategory() {
        return desCategory;
    }

    public void setDesCategory(String desCategory) {
        this.desCategory = desCategory;
    }
}

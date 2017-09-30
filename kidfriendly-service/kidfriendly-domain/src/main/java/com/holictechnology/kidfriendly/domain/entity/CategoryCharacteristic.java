package com.holictechnology.kidfriendly.domain.entity;


import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.holictechnology.kidfriendly.domain.entity.pk.CategoryCharacteristicPK;


@Entity
@Table(name = "CATEGORY_CHARACTERISTIC")
public class CategoryCharacteristic implements Serializable {

    private static final long serialVersionUID = 1013975327619818024L;

    @EmbeddedId
    private CategoryCharacteristicPK categoryCharacteristicPK;

    public CategoryCharacteristicPK getCategoryCharacteristicPK() {
        return categoryCharacteristicPK;
    }

    public void setCategoryCharacteristicPK(
            CategoryCharacteristicPK categoryCharacteristicPK) {
        this.categoryCharacteristicPK = categoryCharacteristicPK;
    }
}

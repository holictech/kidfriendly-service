package com.holictechnology.kidfriendly.domain.entitys.pk;


import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.holictechnology.kidfriendly.domain.entitys.Category;
import com.holictechnology.kidfriendly.domain.entitys.Characteristic;


@Embeddable
public class CategoryCharacteristicPK implements Serializable {

    private static final long serialVersionUID = 1715009687105793045L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CATEGORY", nullable = false)
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CHARACTERISTIC", nullable = false)
    private Characteristic characteristic;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Characteristic getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(Characteristic characteristic) {
        this.characteristic = characteristic;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((category == null) ? 0 : category.hashCode());
        result = prime * result
                + ((characteristic == null) ? 0 : characteristic.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CategoryCharacteristicPK other = (CategoryCharacteristicPK) obj;
        if (category == null) {
            if (other.category != null)
                return false;
        } else if (!category.equals(other.category))
            return false;
        if (characteristic == null) {
            if (other.characteristic != null)
                return false;
        } else if (!characteristic.equals(other.characteristic))
            return false;
        return true;
    }
}

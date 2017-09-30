package com.holictechnology.kidfriendly.domain.entity.pk;


import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import com.holictechnology.kidfriendly.domain.entity.CategoryCharacteristic;
import com.holictechnology.kidfriendly.domain.entity.Company;


@Embeddable
public class CompanyCategoryCharacteristicPK implements Serializable {

    private static final long serialVersionUID = 1644638171537437199L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_COMPANY", nullable = false)
    private Company company;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns(value = {
            @JoinColumn(name = "ID_CATEGORY", nullable = false),
            @JoinColumn(name = "ID_CHARACTERISTIC", nullable = false)
    })
    private CategoryCharacteristic categoryCharacteristic;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public CategoryCharacteristic getCategoryCharacteristic() {
        return categoryCharacteristic;
    }

    public void setCategoryCharacteristic(CategoryCharacteristic categoryCharacteristic) {
        this.categoryCharacteristic = categoryCharacteristic;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((categoryCharacteristic == null) ? 0 : categoryCharacteristic.hashCode());
        result = prime * result + ((company == null) ? 0 : company.hashCode());
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
        CompanyCategoryCharacteristicPK other = (CompanyCategoryCharacteristicPK) obj;
        if (categoryCharacteristic == null) {
            if (other.categoryCharacteristic != null)
                return false;
        } else if (!categoryCharacteristic.equals(other.categoryCharacteristic))
            return false;
        if (company == null) {
            if (other.company != null)
                return false;
        } else if (!company.equals(other.company))
            return false;
        return true;
    }
}

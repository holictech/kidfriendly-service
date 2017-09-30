package com.holictechnology.kidfriendly.domain.entity.pk;


import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.holictechnology.kidfriendly.domain.entity.Company;
import com.holictechnology.kidfriendly.domain.entity.FoodType;


@Embeddable
public class CompanyFoodTypePK implements Serializable {

    private static final long serialVersionUID = -6064240256495472118L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_COMPANY", nullable = false)
    private Company company;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_FOOD_TYPE", nullable = false)
    private FoodType foodType;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public FoodType getFoodType() {
        return foodType;
    }

    public void setFoodType(FoodType foodType) {
        this.foodType = foodType;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((company == null) ? 0 : company.hashCode());
        result = prime * result + ((foodType == null) ? 0 : foodType.hashCode());
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
        CompanyFoodTypePK other = (CompanyFoodTypePK) obj;
        if (company == null) {
            if (other.company != null)
                return false;
        } else if (!company.equals(other.company))
            return false;
        if (foodType == null) {
            if (other.foodType != null)
                return false;
        } else if (!foodType.equals(other.foodType))
            return false;
        return true;
    }
}

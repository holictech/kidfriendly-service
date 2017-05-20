package com.holictechnology.kidfriendly.domain.entitys;


import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.holictechnology.kidfriendly.domain.entitys.pk.CompanyFoodTypePK;


@Entity
@Table(name = "COMPANY_FOOD_TYPE")
public class CompanyFoodType implements Serializable {

    private static final long serialVersionUID = 7659525423668129431L;

    @EmbeddedId
    private CompanyFoodTypePK companyFoodTypePK;

    public CompanyFoodTypePK getCompanyFoodTypePK() {
        return companyFoodTypePK;
    }

    public void setCompanyFoodTypePK(CompanyFoodTypePK companyFoodTypePK) {
        this.companyFoodTypePK = companyFoodTypePK;
    }
}

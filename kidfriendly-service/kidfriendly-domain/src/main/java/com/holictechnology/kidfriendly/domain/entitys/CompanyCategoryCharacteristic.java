package com.holictechnology.kidfriendly.domain.entitys;


import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.holictechnology.kidfriendly.domain.entitys.pk.CompanyCategoryCharacteristicPK;


@Entity
@Table(name = "COMPANY_CATEGORY_CHARACTERISTIC")
public class CompanyCategoryCharacteristic implements Serializable {

    private static final long serialVersionUID = -2741615789413611397L;

    @EmbeddedId
    private CompanyCategoryCharacteristicPK companyCategoryCharacteristicPK;

    public CompanyCategoryCharacteristicPK getCompanyCategoryCharacteristicPK() {
        return companyCategoryCharacteristicPK;
    }

    public void setCompanyCategoryCharacteristicPK(CompanyCategoryCharacteristicPK companyCategoryCharacteristicPK) {
        this.companyCategoryCharacteristicPK = companyCategoryCharacteristicPK;
    }
}

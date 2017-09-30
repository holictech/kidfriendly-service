package com.holictechnology.kidfriendly.domain.entity;


import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.holictechnology.kidfriendly.domain.entity.pk.CompanyWeekSchedulePK;


@Entity
@Table(name = "COMPANY_WEEK_SCHEDULE")
public class CompanyWeekSchedule implements Serializable {

    private static final long serialVersionUID = -4079674733380394364L;

    @EmbeddedId
    private CompanyWeekSchedulePK companyWeekSchedulePK;

    public CompanyWeekSchedulePK getCompanyWeekSchedulePK() {
        return companyWeekSchedulePK;
    }

    public void setCompanyWeekSchedulePK(CompanyWeekSchedulePK companyWeekSchedulePK) {
        this.companyWeekSchedulePK = companyWeekSchedulePK;
    }
}

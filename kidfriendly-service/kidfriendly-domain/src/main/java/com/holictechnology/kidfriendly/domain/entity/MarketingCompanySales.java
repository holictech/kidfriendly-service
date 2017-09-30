package com.holictechnology.kidfriendly.domain.entity;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name = "MARKETING_COMPANY_SALES")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idMarketingComplaySales", scope = MarketingCompanySales.class)
public class MarketingCompanySales implements Serializable {

    private static final long serialVersionUID = -3970326320149686805L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_MARKETING_COMPANY_SALES", nullable = false, unique = true)
    private Long idMarketingComplaySales;

    @Column(name = "VL_CONTRACT", nullable = false, precision = 13, scale = 2)
    private BigDecimal vlContract;

    @Temporal(TemporalType.DATE)
    @Column(name = "DT_INITIAL", nullable = false)
    private Date dtInitial;

    @Temporal(TemporalType.DATE)
    @Column(name = "DT_FINISH", nullable = false)
    private Date dtFinish;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_COMPANY", nullable = false)
    private Company company;

    public Long getIdMarketingComplaySales() {
        return idMarketingComplaySales;
    }

    public void setIdMarketingComplaySales(Long idMarketingComplaySales) {
        this.idMarketingComplaySales = idMarketingComplaySales;
    }

    public BigDecimal getVlContract() {
        return vlContract;
    }

    public void setVlContract(BigDecimal vlContract) {
        this.vlContract = vlContract;
    }

    public Date getDtInitial() {
        return dtInitial;
    }

    public void setDtInitial(Date dtInitial) {
        this.dtInitial = dtInitial;
    }

    public Date getDtFinish() {
        return dtFinish;
    }

    public void setDtFinish(Date dtFinish) {
        this.dtFinish = dtFinish;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}

package com.holictechnology.kidfriendly.domain.entitys;


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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name = "MARKETING_CONTRACT_OUTHER")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idMarketingContractOuther", scope = MarketingContractOuther.class)
public class MarketingContractOuther implements Serializable {

    private static final long serialVersionUID = -9135617162983034985L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_MARKETING_COMPANY_SALES", nullable = false, unique = true)
    private Long idMarketingContractOuther;

    @Column(name = "VL_CONTRACT", nullable = false, precision = 13, scale = 2)
    private BigDecimal vlContract;

    @Column(name = "DES_CNPJ", nullable = false)
    private String desCNPJ;

    @Temporal(TemporalType.DATE)
    @Column(name = "DT_INITIAL", nullable = false)
    private Date dtInitial;

    @Temporal(TemporalType.DATE)
    @Column(name = "DT_FINISH", nullable = false)
    private Date dtFinish;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns(value = {
            @JoinColumn(name = "ID_CATEGORY", nullable = false),
            @JoinColumn(name = "ID_CHACACTERISTIC", nullable = false)
    })
    private CategoryCharacteristic categoryCharacteristic;

    public Long getIdMarketingContractOuther() {
        return idMarketingContractOuther;
    }

    public void setIdMarketingContractOuther(Long idMarketingContractOuther) {
        this.idMarketingContractOuther = idMarketingContractOuther;
    }

    public BigDecimal getVlContract() {
        return vlContract;
    }

    public void setVlContract(BigDecimal vlContract) {
        this.vlContract = vlContract;
    }

    public String getDesCNPJ() {
        return desCNPJ;
    }

    public void setDesCNPJ(String desCNPJ) {
        this.desCNPJ = desCNPJ;
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

    public CategoryCharacteristic getCategoryCharacteristic() {
        return categoryCharacteristic;
    }

    public void setCategoryCharacteristic(CategoryCharacteristic categoryCharacteristic) {
        this.categoryCharacteristic = categoryCharacteristic;
    }
}

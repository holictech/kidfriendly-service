package com.holictechnology.kidfriendly.domain.entitys;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name = "INDICATE_COMPANY")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idIndicateCompany", scope = IndicateCompany.class)
public class IndicateCompany implements Serializable {

    private static final long serialVersionUID = -7402854415842748589L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_INDICATE_COMPANY", nullable = false, unique = true)
    private Long idIndicateCompany;

    @Column(name = "DS_NAME", nullable = false, length = 300)
    private String dsName;

    @Column(name = "LK_SITE", nullable = true, length = 100)
    private String lkSite;

    @Column(name = "DS_ADDRESS", nullable = false, length = 500)
    private String dsAddress;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_USER", nullable = false)
    private User user;

    public Long getIdIndicateCompany() {
        return idIndicateCompany;
    }

    public void setIdIndicateCompany(Long idIndicateCompany) {
        this.idIndicateCompany = idIndicateCompany;
    }

    public String getDsName() {
        return dsName;
    }

    public void setDsName(String dsName) {
        this.dsName = dsName;
    }

    public String getLkSite() {
        return lkSite;
    }

    public void setLkSite(String lkSite) {
        this.lkSite = lkSite;
    }

    public String getDsAddress() {
        return dsAddress;
    }

    public void setDsAddress(String dsAddress) {
        this.dsAddress = dsAddress;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

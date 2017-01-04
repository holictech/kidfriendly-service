package com.holictechnology.kidfriendly.domain.entitys;


import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.ws.rs.DefaultValue;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name = "COMPANY", schema = "sistemap_kidfriendly")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idCompany", scope = Company.class)
public class Company implements Serializable {

    private static final long serialVersionUID = 3729689464378480133L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_COMPANY", nullable = false, unique = true)
    private Long idCompany;

    @Column(name = "DES_NAME", nullable = false, length = 300)
    private String desName;

    @Column(name = "DES_CNPJ", nullable = true)
    private String desCNPJ;

    @Column(name = "DES_SITE", nullable = true, length = 100)
    private String desSite;

    @Lob
    @Column(name = "IMG_LOGO", nullable = true)
    private byte [] imgLogo;

    @Column(name = "NUM_RATE", nullable = true)
    private Short numRate;

    @Temporal(TemporalType.DATE)
    @Column(name = "DT_REGISTER", nullable = false)
    private Date dtRegister;

    @Column(name = "ST_ACTIVE", nullable = false)
    private Boolean stActive;

    @Column(name = "ST_HIGHLIGHT", nullable = true)
    private Boolean stHighlight;

    @Column(name = "DES_NAME_RESPONSIBLE", nullable = true, length = 150)
    private String desNameResponsible;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ADDRESS", nullable = true)
    private Address address;

    @OneToMany(orphanRemoval = true, mappedBy = "company", cascade = CascadeType.ALL)
    private Set<Phone> phones;

    public Long getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(Long idCompany) {
        this.idCompany = idCompany;
    }

    public String getDesName() {
        return desName;
    }

    public void setDesName(String desName) {
        this.desName = desName;
    }

    public String getDesCNPJ() {
        return desCNPJ;
    }

    public void setDesCNPJ(String desCNPJ) {
        this.desCNPJ = desCNPJ;
    }

    public String getDesSite() {
        return desSite;
    }

    public void setDesSite(String desSite) {
        this.desSite = desSite;
    }

    public byte [] getImgLogo() {
        return imgLogo;
    }

    public void setImgLogo(byte [] imgLogo) {
        this.imgLogo = imgLogo;
    }

    public Short getNumRate() {
        return numRate;
    }

    public void setNumRate(Short numRate) {
        this.numRate = numRate;
    }

    public Date getDtRegister() {
        return dtRegister;
    }

    public void setDtRegister(Date dtRegister) {
        this.dtRegister = dtRegister;
    }

    public Boolean getStActive() {
        return stActive;
    }

    @DefaultValue(value = "false")
    public void setStActive(Boolean stActive) {
        this.stActive = stActive;
    }

    public Boolean getStHighlight() {
        return stHighlight;
    }

    @DefaultValue(value = "false")
    public void setStHighlight(Boolean stHighlight) {
        this.stHighlight = stHighlight;
    }

    public String getDesNameResponsible() {
        return desNameResponsible;
    }

    public void setDesNameResponsible(String desNameResponsible) {
        this.desNameResponsible = desNameResponsible;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Phone> getPhones() {
        return phones;
    }

    public void setPhones(Set<Phone> phones) {
        this.phones = phones;
    }
}

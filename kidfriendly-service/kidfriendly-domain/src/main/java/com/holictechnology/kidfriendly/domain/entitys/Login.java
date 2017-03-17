package com.holictechnology.kidfriendly.domain.entitys;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name = "LOGIN")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idLogin", scope = Login.class)
public class Login implements Serializable {

    private static final long serialVersionUID = 243741892661177579L;

    @Id
    @Column(name = "ID_LOGIN", nullable = false, unique = true)
    private String idLogin;

    @Column(name = "DES_PASSWORD", nullable = false, length = 64)
    private String desPassword;

    @Column(name = "ST_ACTIVE", nullable = false)
    private Boolean stActive;

    @JsonIdentityReference(alwaysAsId = true)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_USER", nullable = true)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_COMPANY", nullable = true)
    private Company company;

    public String getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(String idLogin) {
        this.idLogin = idLogin;
    }

    public String getDesPassword() {
        return desPassword;
    }

    public void setDesPassword(String desPassword) {
        this.desPassword = desPassword;
    }

    public Boolean getStActive() {
        return stActive;
    }

    public void setStActive(Boolean stActive) {
        this.stActive = stActive;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}

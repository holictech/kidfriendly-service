package com.holictechnology.kidfriendly.domain.entitys;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.ws.rs.FormParam;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.providers.multipart.PartType;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name = "LOGIN", schema = "sistemap_kidfriendly")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idLogin", scope = Login.class)
public class Login implements Serializable {

    private static final long serialVersionUID = 243741892661177579L;

    @Id
    @Column(name = "ID_LOGIN", nullable = false, unique = true)
    private String idLogin;

    @Column(name = "DES_PASSWORD", nullable = false, length = 16)
    private String desPassword;

    @Column(name = "ST_ACTIVE", nullable = false)
    private Boolean stActive;

    @Column(name = "NUM_CNPJ", nullable = true)
    private Long numCNPJ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_USER", nullable = true)
    private User user;

    public String getIdLogin() {
        return idLogin;
    }

    @FormParam("idLogin")
    @PartType(MediaType.TEXT_PLAIN)
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

    public Long getNumCNPJ() {
        return numCNPJ;
    }

    public void setNumCNPJ(Long numCNPJ) {
        this.numCNPJ = numCNPJ;
    }

    @JsonIdentityReference(alwaysAsId = true)
    public User getUser() {
        return user;
    }

    @FormParam("user")
    @PartType(MediaType.APPLICATION_OCTET_STREAM)
    public void setUser(User user) {
        this.user = user;
    }
}

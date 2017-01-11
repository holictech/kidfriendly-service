package com.holictechnology.kidfriendly.domain.entitys;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name = "USER", schema = "sistemap_kidfriendly")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idUser", scope = User.class)
public class User implements Serializable {

    private static final long serialVersionUID = -4724425169536324180L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USER", nullable = false, unique = true)
    private Long idUser;

    @Column(name = "DES_NAME", nullable = false, length = 150)
    private String desName;

    @Lob
    @Column(name = "IMG_USER", nullable = true)
    private byte [] imgUser;

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
    private Login login;

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getDesName() {
        return desName;
    }

    public void setDesName(String desName) {
        this.desName = desName;
    }

    public byte [] getImgUser() {
        return imgUser;
    }

    public void setImgUser(byte [] imgUser) {
        this.imgUser = imgUser;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
}

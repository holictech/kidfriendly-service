package com.holictechnology.kidfriendly.domain.entitys;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.holictechnology.kidfriendly.domain.enums.GenderEnum;
import com.holictechnology.kidfriendly.library.hibernate.EnumUserType;


@Entity
@Table(name = "USER", schema = "sistemap_kidfriendly")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idUser", scope = User.class)
public class User implements Serializable {

    private static final long serialVersionUID = -4724425169536324180L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USER", nullable = false, unique = true)
    private Long idUser;

    @Column(name = "DS_NAME", nullable = false, length = 150)
    private String dsName;

    @Lob
    @Column(name = "MG_USER", nullable = true)
    private byte [] mgUser;

    @Type(type = "com.holictechnology.kidfriendly.library.hibernate.EnumUserType", parameters = {
            @Parameter(name = EnumUserType.PACKAGE_ENUM, value = "com.holictechnology.kidfriendly.domain.enums.GenderEnum")
    })
    @Column(name = "DS_GENDER", nullable = true)
    private GenderEnum genderEnum;

    @Temporal(TemporalType.DATE)
    @Column(name = "DT_BIRTHDAY", nullable = true)
    private Date dtBirthDay;

    @Column(name = "BL_HAS_CHILDREN", nullable = true)
    private Boolean blHasChildren;

    @Column(name = "ID_SOCIAL_NETWORK", nullable = true)
    private Long idSocialNetwork;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CITY", nullable = true)
    private City city;

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
    private Login login;

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getDsName() {
        return dsName;
    }

    public void setDsName(String dsName) {
        this.dsName = dsName;
    }

    public byte [] getMgUser() {
        return mgUser;
    }

    public void setMgUser(byte [] mgUser) {
        this.mgUser = mgUser;
    }

    public GenderEnum getGenderEnum() {
        return genderEnum;
    }

    public void setGenderEnum(GenderEnum genderEnum) {
        this.genderEnum = genderEnum;
    }

    public Date getDtBirthDay() {
        return dtBirthDay;
    }

    public void setDtBirthDay(Date dtBirthDay) {
        this.dtBirthDay = dtBirthDay;
    }

    public Boolean getBlHasChildren() {
        return blHasChildren;
    }

    public void setBlHasChildren(Boolean blHasChildren) {
        this.blHasChildren = blHasChildren;
    }

    public Long getIdSocialNetwork() {
        return idSocialNetwork;
    }

    public void setIdSocialNetwork(Long idSocialNetwork) {
        this.idSocialNetwork = idSocialNetwork;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
}

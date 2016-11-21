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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name = "RATING", schema = "sistemap_kidfriendly")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idRating", scope = Rating.class)
public class Rating implements Serializable {

    private static final long serialVersionUID = -489797414513933178L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_RATING", nullable = false, unique = true)
    private Long idRating;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DT_RATING", nullable = false)
    private Date dtRating;

    @Column(name = "DES_RATING", nullable = false, length = 500)
    private String desRating;

    @Column(name = "DES_ANSWER", nullable = true, length = 500)
    private String desAnswer;

    @Column(name = "ST_ATIVE", nullable = false)
    private Boolean stActive;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_COMPANY", nullable = false)
    private Company company;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_STATUS_KIDFRIENDLY", nullable = false)
    private StatusKidFriendly statusKidFriendly;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_USER", nullable = false)
    private User user;

    public Long getIdRating() {
        return idRating;
    }

    public void setIdRating(Long idRating) {
        this.idRating = idRating;
    }

    public Date getDtRating() {
        return dtRating;
    }

    public void setDtRating(Date dtRating) {
        this.dtRating = dtRating;
    }

    public String getDesRating() {
        return desRating;
    }

    public void setDesRating(String desRating) {
        this.desRating = desRating;
    }

    public String getDesAnswer() {
        return desAnswer;
    }

    public void setDesAnswer(String desAnswer) {
        this.desAnswer = desAnswer;
    }

    public Boolean getStActive() {
        return stActive;
    }

    public void setStActive(Boolean stActive) {
        this.stActive = stActive;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public StatusKidFriendly getStatusKidFriendly() {
        return statusKidFriendly;
    }

    public void setStatusKidFriendly(StatusKidFriendly statusKidFriendly) {
        this.statusKidFriendly = statusKidFriendly;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

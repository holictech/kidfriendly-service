package com.holictechnology.kidfriendly.domain.dto;


import java.io.Serializable;
import java.util.Date;


public class RatingDto implements Serializable {

    private static final long serialVersionUID = 4056665568970841371L;

    /*
     * RATING
     */
    private Long idRating;
    private Date dtRating;
    private String desRating;
    private String desAnswer;

    /*
     * StatusKidFriendly
     */
    private Short idStatusKidFriendly;

    /*
     * COMPANY
     */
    private Long idCompany;
    private String desNameCompany;

    /*
     * USER
     */
    private Long idUser;
    private String desNameUser;
    private byte [] imgUser;

    public RatingDto() {}

    public RatingDto(Long idRating, Date dtRating, String desRating, String desAnswer, Short idStatusKidFriendly, Long idCompany, String desNameCompany,
            Long idUser, String desNameUser, byte [] imgUser) {
        super();
        this.idRating = idRating;
        this.dtRating = dtRating;
        this.desRating = desRating;
        this.desAnswer = desAnswer;
        this.idStatusKidFriendly = idStatusKidFriendly;
        this.idCompany = idCompany;
        this.desNameCompany = desNameCompany;
        this.idUser = idUser;
        this.desNameUser = desNameUser;
        this.imgUser = imgUser;
    }

    public RatingDto(Long idRating, Date dtRating, String desRating, String desAnswer) {
        super();
        this.idRating = idRating;
        this.dtRating = dtRating;
        this.desRating = desRating;
        this.desAnswer = desAnswer;
    }

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

    public Short getIdStatusKidFriendly() {
        return idStatusKidFriendly;
    }

    public void setIdStatusKidFriendly(Short idStatusKidFriendly) {
        this.idStatusKidFriendly = idStatusKidFriendly;
    }

    public Long getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(Long idCompany) {
        this.idCompany = idCompany;
    }

    public String getDesNameCompany() {
        return desNameCompany;
    }

    public void setDesNameCompany(String desNameCompany) {
        this.desNameCompany = desNameCompany;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getDesNameUser() {
        return desNameUser;
    }

    public void setDesNameUser(String desNameUser) {
        this.desNameUser = desNameUser;
    }

    public byte [] getImgUser() {
        return imgUser;
    }

    public void setImgUser(byte [] imgUser) {
        this.imgUser = imgUser;
    }
}

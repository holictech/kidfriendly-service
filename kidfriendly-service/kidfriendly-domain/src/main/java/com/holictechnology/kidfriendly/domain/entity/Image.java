package com.holictechnology.kidfriendly.domain.entity;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name = "IMAGE")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idImage", scope = Image.class)
public class Image implements Serializable {

    private static final long serialVersionUID = -5441559221443193831L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_IMAGE", nullable = false, unique = true)
    private Long idImage;

    @Lob
    @Column(name = "IMG_IMAGE", nullable = false)
    private byte [] imgImage;

    @Column(name = "DES_IMAGE", nullable = false, length = 100)
    private String desImage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_COMPANY", nullable = true)
    private Company company;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_RATING", nullable = true)
    private Rating rating;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_MARKETING_CONTRACT_OUTHER", nullable = true)
    private MarketingContractOuther marketingContractOuther;

    public Long getIdImage() {
        return idImage;
    }

    public void setIdImage(Long idImage) {
        this.idImage = idImage;
    }

    public byte [] getImgImage() {
        return imgImage;
    }

    public void setImgImage(byte [] imgImage) {
        this.imgImage = imgImage;
    }

    public String getDesImage() {
        return desImage;
    }

    public void setDesImage(String desImage) {
        this.desImage = desImage;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public MarketingContractOuther getMarketingContractOuther() {
        return marketingContractOuther;
    }

    public void setMarketingContractOuther(
            MarketingContractOuther marketingContractOuther) {
        this.marketingContractOuther = marketingContractOuther;
    }
}

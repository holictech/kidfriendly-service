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
@Table(name = "ADDRESS", schema = "sistemap_kidfriendly")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idAddress", scope = Address.class)
public class Address implements Serializable {

    private static final long serialVersionUID = 930234172037087456L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ADDRESS", nullable = false, unique = true)
    private Long idAddress;

    @Column(name = "DES_STREET", nullable = false, length = 100)
    private String desStreet;

    @Column(name = "NUM_STREET", nullable = true)
    private Integer numStreet;

    @Column(name = "DES_COMPLEMENT", nullable = true, length = 200)
    private String desComplement;

    @Column(name = "DES_NEIGHBORHOOD", nullable = false, length = 100)
    private String desNeighborhood;

    @Column(name = "DES_CODE", nullable = false, length = 10)
    private String descCode;

    @Column(name = "NUM_LATITUDE", nullable = false)
    private Double numLatitude;

    @Column(name = "NUM_LONGITUDE", nullable = false)
    private Double numLongitude;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CITY", nullable = false)
    private City city;

    public Long getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(Long idAddress) {
        this.idAddress = idAddress;
    }

    public String getDesStreet() {
        return desStreet;
    }

    public void setDesStreet(String desStreet) {
        this.desStreet = desStreet;
    }

    public Integer getNumStreet() {
        return numStreet;
    }

    public void setNumStreet(Integer numStreet) {
        this.numStreet = numStreet;
    }

    public String getDesComplement() {
        return desComplement;
    }

    public void setDesComplement(String desComplement) {
        this.desComplement = desComplement;
    }

    public String getDesNeighborhood() {
        return desNeighborhood;
    }

    public void setDesNeighborhood(String desNeighborhood) {
        this.desNeighborhood = desNeighborhood;
    }

    public String getDescCode() {
        return descCode;
    }

    public void setDescCode(String descCode) {
        this.descCode = descCode;
    }

    public Double getNumLatitude() {
        return numLatitude;
    }

    public void setNumLatitude(Double numLatitude) {
        this.numLatitude = numLatitude;
    }

    public Double getNumLongitude() {
        return numLongitude;
    }

    public void setNumLongitude(Double numLongitude) {
        this.numLongitude = numLongitude;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}

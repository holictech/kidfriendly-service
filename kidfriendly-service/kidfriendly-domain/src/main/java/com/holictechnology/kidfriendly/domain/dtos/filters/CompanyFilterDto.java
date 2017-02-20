package com.holictechnology.kidfriendly.domain.dtos.filters;


import java.util.List;

import javax.ws.rs.QueryParam;


public class CompanyFilterDto extends AbstractFilterDto {

    private static final long serialVersionUID = 3823747291893267157L;
    
    @QueryParam(value = "desNameCompany")
    private String desNameCompany;
    
    @QueryParam(value = "idState")
    private Integer idState;

    @QueryParam(value = "idCity")
    private Integer idCity;
    
    @QueryParam(value = "idCategory")
    private Integer idCategory;

    @QueryParam(value = "characteristics")
    private List<Long> characteristics;    

    @QueryParam(value = "isSuperKidFriendly")
    private boolean isSuperKidFriendly;

    @QueryParam(value = "longitude")
    private Double longitude;

    @QueryParam(value = "latitude")
    private Double latitude;

    public String getDesNameCompany() {
        return desNameCompany;
    }

    public void setDesNameCompany(String desNameCompany) {
        this.desNameCompany = desNameCompany;
    }

    public Integer getIdState() {
        return idState;
    }

    public void setIdState(Integer idState) {
        this.idState = idState;
    }

    public Integer getIdCity() {
        return idCity;
    }

    public void setIdCity(Integer idCity) {
        this.idCity = idCity;
    }

    public Integer getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
    }

    public List<Long> getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(List<Long> characteristics) {
        this.characteristics = characteristics;
    }

    public boolean isSuperKidFriendly() {
        return isSuperKidFriendly;
    }

    public void setSuperKidFriendly(boolean isSuperKidFriendly) {
        this.isSuperKidFriendly = isSuperKidFriendly;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
}

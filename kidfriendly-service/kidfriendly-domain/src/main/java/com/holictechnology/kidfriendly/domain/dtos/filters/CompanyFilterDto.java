package com.holictechnology.kidfriendly.domain.dtos.filters;


import java.util.List;

import javax.ws.rs.QueryParam;


public class CompanyFilterDto extends AbstractFilterDto {

    private static final long serialVersionUID = 3823747291893267157L;

    @QueryParam(value = "idCharacteristic")
    private List<Long> characteristics;

    @QueryParam(value = "idCategory")
    private Integer idCategory;

    @QueryParam(value = "isSuperKidFriendly")
    private boolean isSuperKidFriendly;

    @QueryParam(value = "longitude")
    private Double longitude;

    @QueryParam(value = "latitude")
    private Double latitude;

    public List<Long> getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(List<Long> characteristics) {
        this.characteristics = characteristics;
    }

    public boolean isSuperKidFriendly() {
        return isSuperKidFriendly;
    }

    public Integer getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
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

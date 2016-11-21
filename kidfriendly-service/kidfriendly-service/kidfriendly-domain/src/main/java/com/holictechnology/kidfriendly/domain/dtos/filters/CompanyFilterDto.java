package com.holictechnology.kidfriendly.domain.dtos.filters;


import java.util.List;

import javax.ws.rs.QueryParam;


public class CompanyFilterDto extends AbstractFilterDto {

    private static final long serialVersionUID = 3823747291893267157L;

    private List<Long> characteristics;
    private Long idCategory;
    private boolean isSuperKidFriendly;
    private Double longitude;
    private Double latitude;

    public List<Long> getCharacteristics() {
        return characteristics;
    }

    @QueryParam(value = "idCharacteristic")
    public void setCharacteristics(List<Long> characteristics) {
        this.characteristics = characteristics;
    }

    public boolean isSuperKidFriendly() {
        return isSuperKidFriendly;
    }

    public Long getIdCategory() {
        return idCategory;
    }

    @QueryParam(value = "idCategory")
    public void setIdCategory(Long idCategory) {
        this.idCategory = idCategory;
    }

    @QueryParam(value = "isSuperKidFriendly")
    public void setSuperKidFriendly(boolean isSuperKidFriendly) {
        this.isSuperKidFriendly = isSuperKidFriendly;
    }

    public Double getLongitude() {
        return longitude;
    }

    @QueryParam(value = "longitude")
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    @QueryParam(value = "latitude")
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
}

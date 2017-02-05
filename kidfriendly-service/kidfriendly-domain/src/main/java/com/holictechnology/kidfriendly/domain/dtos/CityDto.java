package com.holictechnology.kidfriendly.domain.dtos;


public class CityDto {

    private Integer idCity;
    private String desCity;
    private Integer idState;
    private String desState;

    public Integer getIdCity() {
        return idCity;
    }

    public void setIdCity(Integer idCity) {
        this.idCity = idCity;
    }

    public String getDesCity() {
        return desCity;
    }

    public void setDesCity(String desCity) {
        this.desCity = desCity;
    }

    public Integer getIdState() {
        return idState;
    }

    public void setIdState(Integer idState) {
        this.idState = idState;
    }

    public String getDesState() {
        return desState;
    }

    public void setDesState(String desState) {
        this.desState = desState;
    }
}

package com.holictechnology.kidfriendly.domain.dtos;


import java.io.Serializable;


public class CompanyDto implements Serializable {

    private static final long serialVersionUID = 7135951175609215869L;

    private Long idCompany;
    private String desName;
    private byte [] imgLogo;
    private Short numRate;
    private String desState;
    private String desCity;
    
    private AdressDto adressDto;
    
    private ImageDto imageDto;

    public Long getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(Long idCompany) {
        this.idCompany = idCompany;
    }

    public String getDesName() {
        return desName;
    }

    public void setDesName(String desName) {
        this.desName = desName;
    }

    public byte [] getImgLogo() {
        return imgLogo;
    }

    public void setImgLogo(byte [] imgLogo) {
        this.imgLogo = imgLogo;
    }

    public Short getNumRate() {
        return numRate;
    }

    public void setNumRate(Short numRate) {
        this.numRate = numRate;
    }

    public String getDesState() {
        return desState;
    }

    public void setDesState(String desState) {
        this.desState = desState;
    }

    public String getDesCity() {
        return desCity;
    }

    public void setDesCity(String desCity) {
        this.desCity = desCity;
    }

	public AdressDto getAdressDto() {
		return adressDto;
	}

	public void setAdressDto(AdressDto adressDto) {
		this.adressDto = adressDto;
	}

	public ImageDto getImageDto() {
		return imageDto;
	}

	public void setImageDto(ImageDto imageDto) {
		this.imageDto = imageDto;
	}
    
}
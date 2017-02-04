package com.holictechnology.kidfriendly.domain.dtos;


import java.io.Serializable;
import java.util.List;


public class CompanyDto implements Serializable {

    private static final long serialVersionUID = 7135951175609215869L;

    private Long idCompany;
    private String desName;
    private byte [] imgLogo;
    private Short numRate;
    private String desSite;
    
    private AdressDto adressDto;
    
    private List<ImageDto> imageDtos;
    
    private List<PhoneDto> phoneDtos;

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

	public AdressDto getAdressDto() {
		return adressDto;
	}

	public void setAdressDto(AdressDto adressDto) {
		this.adressDto = adressDto;
	}

	public String getDesSite() {
		return desSite;
	}

	public void setDesSite(String desSite) {
		this.desSite = desSite;
	}

	public List<PhoneDto> getPhoneDtos() {
		return phoneDtos;
	}

	public void setPhoneDtos(List<PhoneDto> phoneDtos) {
		this.phoneDtos = phoneDtos;
	}

	public List<ImageDto> getImageDtos() {
		return imageDtos;
	}

	public void setImageDtos(List<ImageDto> imageDtos) {
		this.imageDtos = imageDtos;
	}
	
}
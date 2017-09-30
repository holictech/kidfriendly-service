package com.holictechnology.kidfriendly.domain.dto;


import java.io.Serializable;
import java.util.List;


public class CompanyDto implements Serializable {

    private static final long serialVersionUID = 7135951175609215869L;

    private Long idCompany;
    private String desName;
    private String document;
    private String desSite;
    private byte [] imgLogo;
    private byte [] mgHome;
    private Short numRate;
    private String namePearsonResponsible;
    private String email;
    private AddressDto addressDto;
    private List<PhoneDto> phoneDtos;
    private List<ImageDto> imageDtos;
    private CategoryDto categoryDto;
    private List<CategoryDto> categoryDtos;
    private List<HourDateDto> hourDateDtos;
    private Long typeFood;

    public CompanyDto() {}

    public Long getIdCompany() {
        return idCompany;
    }
    
    public Long getTypeFood() {
		return typeFood;
	}

	public void setTypeFood(Long typeFood) {
		this.typeFood = typeFood;
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

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getDesSite() {
        return desSite;
    }

    public void setDesSite(String desSite) {
        this.desSite = desSite;
    }

    public byte [] getImgLogo() {
        return imgLogo;
    }

    public void setImgLogo(byte [] imgLogo) {
        this.imgLogo = imgLogo;
    }

    public byte [] getMgHome() {
        return mgHome;
    }

    public void setMgHome(byte [] mgHome) {
        this.mgHome = mgHome;
    }

    public Short getNumRate() {
        return numRate;
    }

    public void setNumRate(Short numRate) {
        this.numRate = numRate;
    }

    public String getNamePearsonResponsible() {
        return namePearsonResponsible;
    }

    public void setNamePearsonResponsible(String namePearsonResponsible) {
        this.namePearsonResponsible = namePearsonResponsible;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AddressDto getAddressDto() {
        return addressDto;
    }

    public void setAddressDto(AddressDto addressDto) {
        this.addressDto = addressDto;
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

    public CategoryDto getCategoryDto() {
        return categoryDto;
    }

    public void setCategoryDto(CategoryDto categoryDto) {
        this.categoryDto = categoryDto;
    }

    public List<CategoryDto> getCategoryDtos() {
        return categoryDtos;
    }

    public void setCategoryDtos(List<CategoryDto> categoryDtos) {
        this.categoryDtos = categoryDtos;
    }

	public List<HourDateDto> getHourDateDtos() {
		return hourDateDtos;
	}

	public void setHourDateDtos(List<HourDateDto> hourDateDtos) {
		this.hourDateDtos = hourDateDtos;
	}
    
}

package com.holictechnology.kidfriendly.domain.dtos;


import java.io.Serializable;
import java.util.List;


public class CompanyDto implements Serializable {

    private static final long serialVersionUID = 7135951175609215869L;

    private Long idCompany;
    private String desName;
    private String document;
    private String email;
    private String namePearsonResponsible;
    private byte [] imgLogo;
    private Short numRate;
    private String desSite;
    private AddressDto addressDto;
    private List<ImageDto> imageDtos;
    private List<PhoneDto> phoneDtos;
    private CategoryDto categoryDto;
    private List<CategoryDto> categoryDtos;

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

    public AddressDto getAddressDto() {
        return addressDto;
    }

    public void setAddressDto(AddressDto addressDto) {
        this.addressDto = addressDto;
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

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNamePearsonResponsible() {
        return namePearsonResponsible;
    }

    public void setNamePearsonResponsible(String namePearsonResponsible) {
        this.namePearsonResponsible = namePearsonResponsible;
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
    
}

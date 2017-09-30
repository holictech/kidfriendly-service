package com.holictechnology.kidfriendly.domain.dto;

/**
 * Class responsible for image in company 
 * @author paulocotta
 *
 */
public class ImageDto {

	private Long idImage;

    private byte[] imgImage;
    
    private String dataImage;

    private String desImage;
    
    private String nameCompany;
    
    private Integer type;

	public Long getIdImage() {
		return idImage;
	}

	public void setIdImage(Long idImage) {
		this.idImage = idImage;
	}
	
	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public byte[] getImgImage() {
		return imgImage;
	}

	public void setImgImage(byte[] imgImage) {
		this.imgImage = imgImage;
	}

	public String getDesImage() {
		return desImage;
	}

	public void setDesImage(String desImage) {
		this.desImage = desImage;
	}

	public String getDataImage() {
		return dataImage;
	}

	public void setDataImage(String dataImage) {
		this.dataImage = dataImage;
	}

	public String getNameCompany() {
		return nameCompany;
	}

	public void setNameCompany(String nameCompany) {
		this.nameCompany = nameCompany;
	}
	
}
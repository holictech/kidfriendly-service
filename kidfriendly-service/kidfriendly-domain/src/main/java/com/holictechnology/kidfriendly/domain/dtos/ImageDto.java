package com.holictechnology.kidfriendly.domain.dtos;

/**
 * Class responsible for image in company 
 * @author paulocotta
 *
 */
public class ImageDto {

	private Long idImage;

    private byte [] imgImage;

    private String desImage;

	public Long getIdImage() {
		return idImage;
	}

	public void setIdImage(Long idImage) {
		this.idImage = idImage;
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
	
}
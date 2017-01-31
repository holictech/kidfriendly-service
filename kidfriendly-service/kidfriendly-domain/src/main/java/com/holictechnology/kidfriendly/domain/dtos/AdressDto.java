package com.holictechnology.kidfriendly.domain.dtos;

/**
 * Class responsible for address company
 * @author paulocotta
 *
 */
public class AdressDto {

	private Long idAddress;

    private String desStreet;

    private Integer numStreet;

    private String desComplement;

    private String desNeighborhood;

    private String descCode;

    private Double numLatitude;

    private Double numLongitude;

    private Integer idCity;

	public Long getIdAddress() {
		return idAddress;
	}

	public void setIdAddress(Long idAddress) {
		this.idAddress = idAddress;
	}

	public String getDesStreet() {
		return desStreet;
	}

	public void setDesStreet(String desStreet) {
		this.desStreet = desStreet;
	}

	public Integer getNumStreet() {
		return numStreet;
	}

	public void setNumStreet(Integer numStreet) {
		this.numStreet = numStreet;
	}

	public String getDesComplement() {
		return desComplement;
	}

	public void setDesComplement(String desComplement) {
		this.desComplement = desComplement;
	}

	public String getDesNeighborhood() {
		return desNeighborhood;
	}

	public void setDesNeighborhood(String desNeighborhood) {
		this.desNeighborhood = desNeighborhood;
	}

	public String getDescCode() {
		return descCode;
	}

	public void setDescCode(String descCode) {
		this.descCode = descCode;
	}

	public Double getNumLatitude() {
		return numLatitude;
	}

	public void setNumLatitude(Double numLatitude) {
		this.numLatitude = numLatitude;
	}

	public Double getNumLongitude() {
		return numLongitude;
	}

	public void setNumLongitude(Double numLongitude) {
		this.numLongitude = numLongitude;
	}

	public Integer getIdCity() {
		return idCity;
	}

	public void setIdCity(Integer idCity) {
		this.idCity = idCity;
	}
	
}
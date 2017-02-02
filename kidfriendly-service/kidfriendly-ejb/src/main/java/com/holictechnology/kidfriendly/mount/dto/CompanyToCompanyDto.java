package com.holictechnology.kidfriendly.mount.dto;

import java.util.ArrayList;
import java.util.List;

import com.holictechnology.kidfriendly.domain.dtos.CompanyDto;
import com.holictechnology.kidfriendly.domain.dtos.PhoneDto;
import com.holictechnology.kidfriendly.domain.entitys.Address;
import com.holictechnology.kidfriendly.domain.entitys.City;
import com.holictechnology.kidfriendly.domain.entitys.Company;
import com.holictechnology.kidfriendly.domain.entitys.Image;
import com.holictechnology.kidfriendly.domain.entitys.Phone;

/**
 * Class responsible for converte company entity and company dto
 * @author paulocotta
 *
 */
public class CompanyToCompanyDto {

	/**
	 * Instance in class for access methods
	 * @return
	 */
	public static CompanyToCompanyDto getInstance(){
		return new CompanyToCompanyDto();
	}
	
	/**
	 * Method in create object for persist
	 * @param companyDto
	 * @return
	 */
	public Company companyDtoToCompany(CompanyDto companyDto){
		Company company = new Company();
		
		company.setDesName(companyDto.getDesName());
		company.setIdCompany(companyDto.getIdCompany());
		company.setImgLogo(companyDto.getImgLogo());
		company.setNumRate(companyDto.getNumRate());
		company.setDesSite(companyDto.getDesSite());
		
		return company;
	}
	
	/**
	 * Method create address for company
	 * @param companyDto
	 * @param city
	 * @return
	 */
	public Address mountAddress(CompanyDto companyDto, City city){
		Address address = new Address();
		
		address.setCity(city);
		address.setDescCode(companyDto.getAdressDto().getDescCode());
		address.setDesComplement(companyDto.getAdressDto().getDesComplement());
		address.setDesNeighborhood(companyDto.getAdressDto().getDesNeighborhood());
		address.setDesStreet(companyDto.getAdressDto().getDesStreet());
		address.setNumLatitude(companyDto.getAdressDto().getNumLatitude());
		address.setNumLongitude(companyDto.getAdressDto().getNumLongitude());
		address.setNumStreet(companyDto.getAdressDto().getNumStreet());
		
		return address;
	}
	
	/**
	 * Method in mount images catalog company
	 * @param company
	 * @param images
	 * @param companyDto
	 * @return
	 */
	public List<Image> mountImageCompany(Company company, List<byte []> images, CompanyDto companyDto){
		List<Image> imagens = new ArrayList<Image>();
		
		if(images != null){
			if(!images.isEmpty()){
				for(int i=0; i<images.size(); i++){
					Image image = new Image();
					image.setCompany(company);
					image.setDesImage(companyDto.getImageDto().getDesImage());
					image.setImgImage(images.get(i));
					imagens.add(image);
				}
			}
		}
		
		return imagens;
	}
	
	/**
	 * Method mount phones in company
	 * @param companyDto
	 * @param company
	 * @return
	 */
	public List<Phone> mountPhone(CompanyDto companyDto, Company company){
		List<Phone> phones = new ArrayList<Phone>();
		
		if(companyDto.getPhoneDtos() != null){
			if(!companyDto.getPhoneDtos().isEmpty()){
				for(PhoneDto phoneDto : companyDto.getPhoneDtos()){
					Phone phone = new Phone();
					phone.setCompany(company);
					phone.setNumPhone(phoneDto.getNumPhone());
					phone.setTypePhoneEnum(phoneDto.getTypePhoneEnum());
					
					phones.add(phone);
				}
			}
		}
		
		return phones;
	}
	
}
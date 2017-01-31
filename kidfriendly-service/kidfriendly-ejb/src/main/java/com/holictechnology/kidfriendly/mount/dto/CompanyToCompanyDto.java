package com.holictechnology.kidfriendly.mount.dto;

import com.holictechnology.kidfriendly.domain.dtos.CompanyDto;
import com.holictechnology.kidfriendly.domain.entitys.Company;

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
	
	public Company companyDtoToCompany(CompanyDto companyDto){
		Company company = new Company();
		
		company.setDesName(companyDto.getDesName());
		company.setIdCompany(companyDto.getIdCompany());
		
		return company;
	}
	
}
package com.holictechnology.kidfriendly.ejbs.interfaces;


import java.util.Collection;
import java.util.List;

import javax.ejb.Local;

import com.holictechnology.kidfriendly.domain.dtos.CompanyDto;
import com.holictechnology.kidfriendly.domain.dtos.ImageDto;
import com.holictechnology.kidfriendly.domain.dtos.filters.CompanyFilterDto;
import com.holictechnology.kidfriendly.domain.dtos.result.ResultDto;
import com.holictechnology.kidfriendly.domain.entitys.Company;
import com.holictechnology.kidfriendly.library.exceptions.KidFriendlyException;


@Local
public interface CompanyLocal {

    /**
     * TODO - COLOCAR O COMENTÁRIO.
     * 
     * @param primaryKey
     * @param lazyAttributes
     * @return
     * @throws KidFriendlyException
     */
    Company find(Long primaryKey, final String ... lazyAttributes) throws KidFriendlyException;

    /**
     * TODO - COLOCAR O COMENTÁRIO.
     * 
     * @param limit
     * @return
     * @throws KidFriendlyException
     */
    Collection<CompanyDto> listSuggestions(Integer limit) throws KidFriendlyException;

    /**
     * TODO - COLOCAR O COMENTÁRIO.
     * 
     * @param limit
     * @param longitude
     * @param latitude
     * @return
     * @throws KidFriendlyException
     */
    Collection<CompanyDto> listNextToMe(Integer limit, Double longitude, Double latitude) throws KidFriendlyException;

    /**
     * TODO - COLOCAR O COMENTÁRIO.
     * 
     * @param companyFilterDto
     * @return
     * @throws KidFriendlyException
     */
    ResultDto<CompanyDto> search(CompanyFilterDto companyFilterDto) throws KidFriendlyException;
    
    /**
     * Method in register company in system
     * @param companyDto
     * @param city
     * @return
     */
    CompanyDto saveCompany(CompanyDto companyDto) throws KidFriendlyException;
    
    /**
     * Method search company a filters in view - search simple for admins
     * @param nameEstablishment
     * @param responsibleEstablishment
     * @param cnpj
     * @param objCity
     * @return
     */
    List<Company> searchCompanySimple(String nameEstablishment, String responsibleEstablishment,
    		String cnpj, Integer objCity);
    
    /**
     * Method in inactivate company stactive received false for company selected
     * @param company
     * @return
     */
    Company inactivateCompany(Company company);
    
    /**
     * Method edit company selected
     * @param company
     * @return
     */
    Company editCompany(Company company);
    
    /**
     * Method in create list for save images company
     * @param imageDto
     * @return
     */
    void preparImageSaveCompany(ImageDto imageDto);
    
}

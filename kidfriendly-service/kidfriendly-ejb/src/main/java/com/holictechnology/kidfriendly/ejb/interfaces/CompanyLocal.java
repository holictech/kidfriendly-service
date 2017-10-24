package com.holictechnology.kidfriendly.ejb.interfaces;


import java.util.Collection;
import java.util.List;

import javax.ejb.Local;

import com.holictechnology.kidfriendly.domain.dto.CompanyDto;
import com.holictechnology.kidfriendly.domain.dto.ImageDto;
import com.holictechnology.kidfriendly.domain.dto.filter.CompanyFilterDto;
import com.holictechnology.kidfriendly.domain.dto.result.ResultDto;
import com.holictechnology.kidfriendly.domain.entity.Address;
import com.holictechnology.kidfriendly.domain.entity.Company;
import com.holictechnology.kidfriendly.domain.entity.Phone;
import com.holictechnology.kidfriendly.library.exceptions.KidFriendlyException;


@Local
public interface CompanyLocal {

    /**
     * Method to list suggestions.
     * 
     * @param limit
     * @return
     * @throws KidFriendlyException
     */
    Collection<CompanyDto> listSuggestions(Integer limit) throws KidFriendlyException;

    /**
     * Method to list next to me.
     * 
     * @param limit
     * @param longitude
     * @param latitude
     * @return
     * @throws KidFriendlyException
     */
    Collection<CompanyDto> listNextToMe(Integer limit, Double longitude, Double latitude) throws KidFriendlyException;

    /**
     * Method to search.
     * 
     * @param companyFilterDto
     * @return
     * @throws KidFriendlyException
     */
    ResultDto<CompanyDto> search(CompanyFilterDto companyFilterDto) throws KidFriendlyException;

    /**
     * Method in register company in system
     * 
     * @param companyDto
     * @param city
     * @return
     */
    CompanyDto saveCompany(CompanyDto companyDto) throws KidFriendlyException;

    /**
     * Method search company a filters in view - search simple for admins
     * 
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
     * 
     * @param company
     * @return
     */
    Company inactivateCompany(Company company);

    /**
     * Method edit company selected
     * 
     * @param company
     * @return
     */
    Company editCompany(Company company);

    /**
     * Method in create list for save images company
     * 
     * @param imageDto
     * @return
     */
    void preparImageSaveCompany(ImageDto imageDto);

    /**
     * Method that lists the company's phones.
     * 
     * @param idCompany
     * @return
     */
    List<Phone> listPhonesByCompany(Long idCompany);

    /**
     * Method that searches the company's address.
     * 
     * @param idCompany
     * @return
     */
    Address findAddressByCompany(Long idCompany);
}

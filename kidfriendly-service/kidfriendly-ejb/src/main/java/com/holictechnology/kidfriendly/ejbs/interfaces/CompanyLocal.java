package com.holictechnology.kidfriendly.ejbs.interfaces;


import java.util.Collection;

import javax.ejb.Local;

import com.holictechnology.kidfriendly.domain.dtos.CompanyDto;
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
     * @param idUser
     * @return
     * @throws KidFriendlyException
     */
    Collection<CompanyDto> listLatestResearch(Integer limit, Long idUser) throws KidFriendlyException;

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
    CompanyDto saveOrUpdate(CompanyDto companyDto) throws KidFriendlyException;
    
}

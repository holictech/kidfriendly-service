package com.holictechnology.kidfriendly.ejbs.interfaces;


import java.util.List;

import javax.ejb.Local;

import com.holictechnology.kidfriendly.domain.dtos.CompanyDto;
import com.holictechnology.kidfriendly.domain.dtos.filters.CompanyFilterDto;
import com.holictechnology.kidfriendly.domain.dtos.result.ResultDto;
import com.holictechnology.kidfriendly.domain.entitys.Company;


@Local
public interface CompanyLocal {

    /**
     * TODO - COLOCAR O COMENTÁRIO.
     * 
     * @param primaryKey
     * @return
     */
    Company find(Long primaryKey);

    /**
     * TODO - COLOCAR O COMENTÁRIO.
     * 
     * @param limit
     * @param idUser
     * @return
     * @throws Exception
     */
    List<CompanyDto> listLatestResearch(Integer limit, Long idUser);

    /**
     * TODO - COLOCAR O COMENTÁRIO.
     * 
     * @param limit
     * @return
     * @throws Exception
     */
    List<CompanyDto> listSuggestions(Integer limit);

    /**
     * TODO - COLOCAR O COMENTÁRIO.
     * 
     * @param limit
     * @param longitude
     * @param latitude
     * @return
     * @throws Exception
     */
    List<CompanyDto> listNextToMe(Integer limit, Double longitude, Double latitude);

    /**
     * TODO - COLOCAR O COMENTÁRIO.
     * 
     * @param companyFilterDto
     * @return
     */
    ResultDto<CompanyDto> search(CompanyFilterDto companyFilterDto);
}

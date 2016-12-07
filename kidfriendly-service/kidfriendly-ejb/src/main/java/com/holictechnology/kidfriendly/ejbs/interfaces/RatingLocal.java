package com.holictechnology.kidfriendly.ejbs.interfaces;


import java.util.Collection;

import javax.ejb.Local;

import com.holictechnology.kidfriendly.domain.dtos.RatingDto;
import com.holictechnology.kidfriendly.domain.dtos.paginator.PaginatorDto;
import com.holictechnology.kidfriendly.domain.dtos.result.ResultDto;
import com.holictechnology.kidfriendly.library.exceptions.KidFriendlyException;


@Local
public interface RatingLocal {

    /**
     * TODO - COLOCAR O COMENTÁRIO.
     * 
     * @return
     * @throws KidFriendlyException
     */
    Collection<RatingDto> listPending() throws KidFriendlyException;

    /**
     * TODO - COLOCAR O COMENTÁRIO.
     * 
     * @param idCompany
     * @param paginatorDto
     * @return
     * @throws KidFriendlyException
     */
    ResultDto<RatingDto> listByCompany(Long idCompany, PaginatorDto paginatorDto) throws KidFriendlyException;
}

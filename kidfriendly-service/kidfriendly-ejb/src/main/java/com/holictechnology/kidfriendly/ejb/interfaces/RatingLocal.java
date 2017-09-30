package com.holictechnology.kidfriendly.ejb.interfaces;


import java.util.Collection;

import javax.ejb.Local;

import com.holictechnology.kidfriendly.domain.dto.RatingDto;
import com.holictechnology.kidfriendly.domain.dto.paginator.PaginatorDto;
import com.holictechnology.kidfriendly.domain.dto.result.ResultDto;
import com.holictechnology.kidfriendly.domain.entity.Company;
import com.holictechnology.kidfriendly.domain.entity.Rating;
import com.holictechnology.kidfriendly.library.exceptions.KidFriendlyException;


@Local
public interface RatingLocal {

    /**
     * Method for listing outstanding evaluations.
     * 
     * @return
     * @throws KidFriendlyException
     */
    Collection<RatingDto> listPending() throws KidFriendlyException;

    /**
     * Method to list the evaluations of the establishment.
     * 
     * @param idCompany
     * @param paginatorDto
     * @return
     * @throws KidFriendlyException
     */
    ResultDto<RatingDto> listByCompany(Long idCompany, PaginatorDto paginatorDto) throws KidFriendlyException;

    /**
     * Method to activate evaluation.
     * 
     * @param primaryKey
     * @throws KidFriendlyException
     */
    void activate(Long primaryKey) throws KidFriendlyException;

    /**
     * Method for calculating evaluations.
     * 
     * @param idCompany
     * @throws KidFriendlyException
     */
    void calculateRating(Company company) throws KidFriendlyException;

    /**
     * Method to delete evaluation.
     * 
     * @param primaryKey
     * @throws KidFriendlyException
     */
    void delete(Long primaryKey) throws KidFriendlyException;

    /**
     * Method to include evaluation.
     * 
     * @param rating
     * @throws KidFriendlyException
     */
    void include(Rating rating) throws KidFriendlyException;

    /**
     * Method to check the permission to evaluate.
     * 
     * @param idCompany
     * @param idUser
     * @return
     * @throws KidFriendlyException
     */
    boolean hasPermission(Long idCompany, Long idUser) throws KidFriendlyException;
}

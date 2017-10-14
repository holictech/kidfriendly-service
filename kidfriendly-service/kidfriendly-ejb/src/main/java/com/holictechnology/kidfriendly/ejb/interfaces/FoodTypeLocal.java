package com.holictechnology.kidfriendly.ejb.interfaces;


import java.util.List;

import javax.ejb.Local;

import com.holictechnology.kidfriendly.domain.entity.FoodType;


@Local
public interface FoodTypeLocal {

    /**
     * Method that lists all types of food.
     * 
     * @return
     */
    List<FoodType> listAll();

    /**
     * Method that lists types of food for a company.
     * 
     * @param idCompany
     * @return
     */
    List<FoodType> listByCompany(Long idCompany);
}

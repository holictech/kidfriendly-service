package com.holictechnology.kidfriendly.ejb.interfaces;


import java.util.List;

import javax.ejb.Local;

import com.holictechnology.kidfriendly.domain.entity.FoodType;


@Local
public interface TypeFoodLocal {

    /**
     * Method that lists all types of food.
     * 
     * @return
     */
    List<FoodType> listAll();
}

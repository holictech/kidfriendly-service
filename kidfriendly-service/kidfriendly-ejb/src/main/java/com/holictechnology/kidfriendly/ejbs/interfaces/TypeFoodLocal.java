package com.holictechnology.kidfriendly.ejbs.interfaces;

import java.util.List;

import javax.ejb.Local;

import com.holictechnology.kidfriendly.domain.entitys.FoodType;

@Local
public interface TypeFoodLocal {

	/**
	 * Foods all
	 * @return
	 */
	List<FoodType> foods();
	
}
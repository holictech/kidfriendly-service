package com.holictechnology.kidfriendly.ejbs.interfaces;


import java.util.List;

import javax.ejb.Local;

import com.holictechnology.kidfriendly.domain.entitys.Category;
import com.holictechnology.kidfriendly.domain.entitys.Characteristic;


@Local
public interface CharacteristicLocal {

    /**
     * Method to list characteristics by category.
     * 
     * @param idCategory
     *            - key {@link Category}
     * @return
     */
    List<Characteristic> listByCategory(Integer idCategory);
}

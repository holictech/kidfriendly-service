package com.holictechnology.kidfriendly.ejbs.interfaces;


import java.util.List;

import javax.ejb.Local;

import com.holictechnology.kidfriendly.domain.entitys.Category;


@Local
public interface CategoryLocal {

    /**
     * Method to list all categories.
     * 
     * @return
     */
    List<Category> listAll();
}

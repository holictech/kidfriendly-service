package com.holictechnology.kidfriendly.ejb.interfaces;


import java.util.Collection;

import javax.ejb.Local;

import com.holictechnology.kidfriendly.domain.entity.Category;
import com.holictechnology.kidfriendly.library.exceptions.KidFriendlyException;


@Local
public interface CategoryLocal {

    /**
     * Method to list all categories.
     * 
     * @return
     * @throws KidFriendlyException
     */
    Collection<Category> listAll() throws KidFriendlyException;
}

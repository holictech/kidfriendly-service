package com.holictechnology.kidfriendly.ejb.interfaces;


import java.util.Collection;

import javax.ejb.Local;

import com.holictechnology.kidfriendly.domain.entity.Category;
import com.holictechnology.kidfriendly.domain.entity.Characteristic;
import com.holictechnology.kidfriendly.domain.entity.Company;
import com.holictechnology.kidfriendly.library.exceptions.KidFriendlyException;


@Local
public interface CharacteristicLocal {

    /**
     * Method to list characteristics by category.
     * 
     * @param idCategory
     *            - key {@link Category}
     * @return
     * @throws KidFriendlyException
     */
    Collection<Characteristic> listByCategory(Integer idCategory) throws KidFriendlyException;

    /**
     * Method to list characteristics by company and category.
     * 
     * @param idCompany
     *            - key {@link Company}
     * @param idCategory
     *            - key {@link Category}
     * @return
     * @throws KidFriendlyException
     */
    Collection<Characteristic> listByCompanyCategory(Long idCompany, Integer idCategory) throws KidFriendlyException;
}

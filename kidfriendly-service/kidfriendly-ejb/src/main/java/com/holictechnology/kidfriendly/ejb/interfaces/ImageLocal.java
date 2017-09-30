package com.holictechnology.kidfriendly.ejb.interfaces;


import java.util.Collection;

import javax.ejb.Local;

import com.holictechnology.kidfriendly.domain.entity.Image;
import com.holictechnology.kidfriendly.library.exceptions.KidFriendlyException;


@Local
public interface ImageLocal {

    /**
     * Method for listing the images of the establishment.
     * 
     * @param idCompany
     * @return
     * @throws KidFriendlyException
     */
    Collection<Image> listByCompany(Long idCompany) throws KidFriendlyException;
}

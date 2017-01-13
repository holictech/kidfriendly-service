package com.holictechnology.kidfriendly.ejbs.interfaces;


import java.util.Collection;

import javax.ejb.Local;

import com.holictechnology.kidfriendly.domain.entitys.Image;
import com.holictechnology.kidfriendly.library.exceptions.KidFriendlyException;


@Local
public interface ImageLocal {

    /**
     * TODO - COLOCAR O COMENTÁRIO.
     * 
     * @param idCompany
     * @return
     * @throws KidFriendlyException
     */
    Collection<Image> listByCompany(Long idCompany) throws KidFriendlyException;
}

package com.holictechnology.kidfriendly.ejbs.interfaces;


import javax.ejb.Local;

import com.holictechnology.kidfriendly.domain.entitys.User;
import com.holictechnology.kidfriendly.library.exceptions.KidFriendlyException;


@Local
public interface UserLocal {

    /**
     * @param user
     * @throws KidFriendlyException
     */
    void includeWithLogin(User user) throws KidFriendlyException;

    /**
     * TODO - COLOCAR O COMENTÁRIO.
     * 
     * @param user
     * @throws KidFriendlyException
     */
    void includeSocialNetwork(User user) throws KidFriendlyException;
}

package com.holictechnology.kidfriendly.ejbs.interfaces;


import javax.ejb.Local;

import com.holictechnology.kidfriendly.domain.entitys.User;
import com.holictechnology.kidfriendly.library.exceptions.KidFriendlyException;


@Local
public interface UserLocal {

    /**
     * TODO - COLOCAR O COMENTÁRIO.
     * 
     * @param user
     * @throws KidFriendlyException
     */
    void includeSocialNetwork(User user) throws KidFriendlyException;
}

package com.holictechnology.kidfriendly.ejbs.interfaces;


import java.security.NoSuchAlgorithmException;

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
     * @throws NoSuchAlgorithmException
     */
    void includeWithLogin(User user) throws KidFriendlyException, NoSuchAlgorithmException;

    /**
     * TODO - COLOCAR O COMENTÁRIO.
     * 
     * @param user
     * @throws KidFriendlyException
     */
    void includeSocialNetwork(User user) throws KidFriendlyException;

    /**
     * TODO - COLOCAR O COMENTÁRIO.
     * 
     * @param user
     * @return
     * @throws KidFriendlyException
     */
    User update(User user) throws KidFriendlyException;
}

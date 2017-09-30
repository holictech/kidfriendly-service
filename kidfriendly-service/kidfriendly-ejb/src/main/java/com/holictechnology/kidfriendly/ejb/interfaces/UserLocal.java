package com.holictechnology.kidfriendly.ejb.interfaces;


import java.security.NoSuchAlgorithmException;

import javax.ejb.Local;

import com.holictechnology.kidfriendly.domain.entity.User;
import com.holictechnology.kidfriendly.library.exceptions.KidFriendlyException;


@Local
public interface UserLocal {

    /**
     * Method that includes the user with login.
     * 
     * @param user
     * @throws KidFriendlyException
     * @throws NoSuchAlgorithmException
     */
    void includeWithLogin(User user) throws KidFriendlyException;

    /**
     * Method to include social network user.
     * 
     * @param user
     * @throws KidFriendlyException
     */
    void includeSocialNetwork(User user) throws KidFriendlyException;

    /**
     * Method to update the user.
     * 
     * @param user
     * @return
     * @throws KidFriendlyException
     */
    User update(User user) throws KidFriendlyException;
}

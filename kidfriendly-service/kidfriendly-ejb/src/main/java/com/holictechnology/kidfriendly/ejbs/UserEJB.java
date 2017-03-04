package com.holictechnology.kidfriendly.ejbs;


import javax.ejb.Stateless;

import com.holictechnology.kidfriendly.domain.entitys.User;
import com.holictechnology.kidfriendly.ejbs.interfaces.UserLocal;
import com.holictechnology.kidfriendly.library.exceptions.KidFriendlyException;


@Stateless
public class UserEJB extends AbstractEJB implements UserLocal {

    private static final long serialVersionUID = -1879194541495435139L;

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.holictechnology.kidfriendly.ejbs.interfaces.UserLocal#include(com.
     * holictechnology.kidfriendly.domain.entitys.User)
     */
    @Override
    public void includeSocialNetwork(User user) throws KidFriendlyException {
        persist(user);
    }
}

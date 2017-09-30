package com.holictechnology.kidfriendly.ejb;


import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.holictechnology.kidfriendly.domain.entity.User;
import com.holictechnology.kidfriendly.ejb.interfaces.LoginLocal;
import com.holictechnology.kidfriendly.ejb.interfaces.UserLocal;
import com.holictechnology.kidfriendly.library.exceptions.KidFriendlyException;


@Stateless
public class UserEJB extends AbstractEJB implements UserLocal {

    private static final long serialVersionUID = -1879194541495435139L;

    @EJB
    private LoginLocal loginLocal;

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.holictechnology.kidfriendly.ejb.interfaces.UserLocal#includeWithLogin
     * (com.holictechnology.kidfriendly.domain.entity.User)
     */
    @Override
    public void includeWithLogin(User user) throws KidFriendlyException {
        illegalArgument(user);
        illegalArgument(user.getLogin());
        loginLocal.exist(user.getLogin());
        user.getLogin().setUser(user);
        persist(user);
        persist(user.getLogin());
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.holictechnology.kidfriendly.ejbs.interfaces.UserLocal#include(com.
     * holictechnology.kidfriendly.domain.entitys.User)
     */
    @Override
    public void includeSocialNetwork(User user) throws KidFriendlyException {
        illegalArgument(user);
        persist(user);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.holictechnology.kidfriendly.ejbs.interfaces.UserLocal#update(com.
     * holictechnology.kidfriendly.domain.entitys.User)
     */
    @Override
    public User update(User user) throws KidFriendlyException {
        illegalArgument(user);

        return merge(user);
    }
}

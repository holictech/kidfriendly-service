package com.holictechnology.kidfriendly.ejbs;


import javax.ejb.Stateless;

import com.holictechnology.kidfriendly.ejbs.interfaces.UserLocal;


@Stateless
public class UserEJB extends AbstractEJB implements UserLocal {

    private static final long serialVersionUID = -1879194541495435139L;

//    @EJB
//    private LoginLocal loginLocal;
//
//    /*
//     * (non-Javadoc)
//     * 
//     * @see com.holictechnology.kidfriendly.ejbs.interfaces.UserLocal#save(com.
//     * holictechnology.kidfriendly.domain.entitys.User)
//     */
//    @Override
//    @Transactional
//    public void save(User user) throws PersistenceException {
//        try {
//            if (!loginLocal.isExistLogin(user.getLogin().getIdLogin())) {
//                entityManager.persist(user);
//                loginLocal.save(user.getLogin());
//            }
//        } catch (PersistenceException e) {
//            throw e;
//        }
//    }
}

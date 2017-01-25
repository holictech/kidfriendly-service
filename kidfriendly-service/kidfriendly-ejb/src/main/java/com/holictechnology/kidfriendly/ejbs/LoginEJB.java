package com.holictechnology.kidfriendly.ejbs;


import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import com.holictechnology.kidfriendly.domain.dtos.LoginDto;
import com.holictechnology.kidfriendly.ejbs.interfaces.LoginLocal;
import com.holictechnology.kidfriendly.mount.dto.LoginToLoginDto;


@Stateless
public class LoginEJB extends AbstractEJB implements LoginLocal {

    private static final long serialVersionUID = 8439680343365480598L;

	@SuppressWarnings("unchecked")
	@Override
	public List<LoginDto> returnLoginAdm() {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT l FROM Login l WHERE l.stActive = :stActive AND l.user = null ORDER  BY l.idLogin ");
		
		Query query = entityManager.createQuery(sql.toString());
		query.setParameter("stActive", Boolean.FALSE);
		
		return LoginToLoginDto.getInstance().loginToLoginDto(query.getResultList());
	}

//    /*
//     * (non-Javadoc)
//     * 
//     * @see
//     * com.holictechnology.kidfriendly.ejbs.interfaces.LoginLocal#authenticate(
//     * java.lang.String)
//     */
//    @Override
//    @Transactional(value = TxType.SUPPORTS)
//    public UserDto authenticate(String email) throws Exception {
//        UserDto userDto = null;
//
//        try {
//            StringBuffer hql = new StringBuffer();
//            hql.append(
//                    "SELECT new com.holictechnology.kidfriendly.domain.dtos.UserDto(user.idUser, user.desName, user.imgUser, login.idLogin, login.stActive, login.desPassword) ");
//            hql.append("FROM com.holictechnology.kidfriendly.domain.entitys.Login login ");
//            hql.append("INNER JOIN login.user user ");
//            hql.append("WHERE login.idLogin LIKE :email");
//            TypedQuery<UserDto> typedQuery = entityManager.createQuery(hql.toString(), UserDto.class);
//            typedQuery.setParameter("email", email);
//
//            userDto = typedQuery.getSingleResult();
//            userDto.setToken(CriptographUtilites.getInstance().createCriptograph(email.concat(userDto.getToken())));
//        } catch (NoResultException e) {
//            KidFriendlyException.setMessageError(KidFriendlyConstant.ERROR_AUTHENTICATE_LOGIN_NOT_FOUND);
//            throw e;
//        } catch (Exception e) {
//            KidFriendlyException.setMessageError(KidFriendlyConstant.ERROR_UNAVAILABLE_SERVICE);
//            throw e;
//        }
//
//        return userDto;
//    }
//
//    /*
//     * (non-Javadoc)
//     * 
//     * @see com.holictechnology.kidfriendly.ejbs.interfaces.LoginLocal#save(com.
//     * holictechnology.kidfriendly.domain.entitys.Login)
//     */
//    @Override
//    @Transactional
//    public void save(Login login) throws PersistenceException {
//        try {
//            entityManager.persist(login);
//        } catch (PersistenceException e) {
//            throw e;
//        }
//    }
//
//    /*
//     * (non-Javadoc)
//     * 
//     * @see
//     * com.holictechnology.kidfriendly.ejbs.interfaces.LoginLocal#isExistLogin(
//     * java.lang.String)
//     */
//    public boolean isExistLogin(final String idLogin) {
//        StringBuffer hql = new StringBuffer();
//        hql.append("SELECT login.idLogin FROM com.holictechnology.kidfriendly.domain.entitys.Login AS login ");
//        hql.append("WHERE login.idLogin LIKE :idLogin");
//        TypedQuery<String> typedQuery = entityManager.createQuery(hql.toString(), String.class);
//        typedQuery.setParameter("idLogin", idLogin);
//
//        try {
//            typedQuery.getSingleResult();
//            KidFriendlyException.setMessageError(KidFriendlyConstant.ERROR_REGISTER_LOGIN_REGISTERED);
//
//            throw new PersistenceException(KidFriendlyException.getMessageError());
//        } catch (NoResultException e) {
//            return Boolean.FALSE;
//        }
//    }
}

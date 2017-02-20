package com.holictechnology.kidfriendly.ejbs;


import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.holictechnology.kidfriendly.domain.dtos.LoginDto;
import com.holictechnology.kidfriendly.domain.dtos.MessageDto;
import com.holictechnology.kidfriendly.domain.entitys.Login;
import com.holictechnology.kidfriendly.ejbs.interfaces.LoginLocal;
import com.holictechnology.kidfriendly.mount.dto.LoginToLoginDto;


@Stateless
public class LoginEJB extends AbstractEJB implements LoginLocal {

    private static final long serialVersionUID = 8439680343365480598L;

    @Override
	@SuppressWarnings("unchecked")
    @Transactional(value = TxType.NOT_SUPPORTED)
	public List<LoginDto> returnLoginAdm(String search) {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT l FROM Login l WHERE l.stActive = :stActive AND l.user = null ");
		
		if(!search.equals("null"))
			sql.append(" 	AND l.idLogin like :idLogin ");
		
		sql.append(" 		ORDER  BY l.idLogin ");
		
		Query query = entityManager.createQuery(sql.toString());
		query.setParameter("stActive", Boolean.FALSE);
		
		if(!search.equals("null"))
			query.setParameter("idLogin", "%" + search + "%");
		
		return LoginToLoginDto.getInstance().loginToLoginDto(query.getResultList());
	}

	@Override
	public LoginDto saveOrAlterUserAdm(LoginDto loginDto) {
		Login login = LoginToLoginDto.getInstance().loginDtoToLoginDtoSingle(loginDto);
		
		entityManager.merge(login);
		
		return LoginToLoginDto.getInstance().loginToLoginDtoSingle(login);
	}

	@Override
	public MessageDto deleteUserAdm(String idLogin) {
		MessageDto message = new MessageDto();
		
		try{
			Login login = entityManager.find(Login.class, idLogin);
			entityManager.remove(login);
			message.setMessage("Removido com sucesso.");
			message.setStatusSuccess(true);
		}catch (Exception e) {
			message.setMessage("Erro ao remover usuário, tente mais tarde e se persistir entre em contato com o suporte.");
			message.setStatusSuccess(false);
		}
		
		return message;
	}

	@Override
	public LoginDto registerUserAdm(String user, String pws) {
		Login login = new Login();
		
		login.setIdLogin(user);
		login.setDesPassword(pws);
		login.setStActive(Boolean.FALSE);
		
		entityManager.persist(login);
		
		return LoginToLoginDto.getInstance().loginToLoginDtoSingle(login);
	}

	@Override
	public Login login(String user, String pws) {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT l FROM Login l WHERE l.stActive = :stActive AND l.user = null ");
		sql.append(" 	AND l.idLogin = :idLogin ");
		sql.append(" 	AND l.desPassword = :desPassword ");
		
		Query query = entityManager.createQuery(sql.toString());
		query.setParameter("stActive", Boolean.FALSE);
		query.setParameter("idLogin", user);
		query.setParameter("desPassword", pws);
		
		try{
			Login login = (Login) query.getSingleResult();
			return login;
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
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

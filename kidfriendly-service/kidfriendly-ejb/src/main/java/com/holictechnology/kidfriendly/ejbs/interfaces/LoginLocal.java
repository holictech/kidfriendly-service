package com.holictechnology.kidfriendly.ejbs.interfaces;


import java.util.List;

import javax.ejb.Local;

import com.holictechnology.kidfriendly.domain.dtos.LoginDto;
import com.holictechnology.kidfriendly.domain.dtos.MessageDto;


@Local
public interface LoginLocal {

//    /**
//     * Method that authenticates the user.
//     * 
//     * @param email
//     * @return
//     * @throws Exception
//     */
//    UserDto authenticate(String email) throws KidFriendlyException;
//
//    /**
//     * Method to check if the login already exists
//     * 
//     * @param idLogin
//     * @return
//     * @throws Exception
//     */
//    boolean isExistLogin(final String idLogin) throws KidFriendlyException;
//
//    /**
//     * Method to save the user.
//     * 
//     * @param login
//     * @throws PersistenceException
//     */
//    void include(Login login) throws KidFriendlyException;
	
	
	/**
	 * Method in return login adim for system
	 * @return
	 */
	List<LoginDto> returnLoginAdm(String search);
	
	/**
	 * Method save or update user adm
	 * @param loginDto
	 * @return
	 */
	LoginDto saveOrAlterUserAdm(LoginDto loginDto);
	
	/**
	 * Method in delete user adm
	 * @param loginDto
	 * @return
	 */
	MessageDto deleteUserAdm(String idLogin);
	
	/**
	 * Register user in system admin
	 * @param user
	 * @param pws
	 * @return
	 */
	LoginDto registerUserAdm(String user, String pws);
	
}

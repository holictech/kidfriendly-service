package com.holictechnology.kidfriendly.ejb.interfaces;


import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.ejb.Local;

import com.holictechnology.kidfriendly.domain.dto.LoginDto;
import com.holictechnology.kidfriendly.domain.dto.MessageDto;
import com.holictechnology.kidfriendly.domain.entity.Login;
import com.holictechnology.kidfriendly.domain.entity.User;
import com.holictechnology.kidfriendly.library.exceptions.KidFriendlyException;


@Local
public interface LoginLocal {

    /**
     * Method in return login adim for system
     * 
     * @return
     */
    List<LoginDto> returnLoginAdm(String search);

    /**
     * Method save or update user adm
     * 
     * @param loginDto
     * @return
     */
    LoginDto saveOrAlterUserAdm(LoginDto loginDto);

    /**
     * Method in delete user adm
     * 
     * @param loginDto
     * @return
     */
    MessageDto deleteUserAdm(String idLogin);

    /**
     * Register user in system admin
     * 
     * @param user
     * @param pws
     * @return
     */
    LoginDto registerUserAdm(String user, String pws);

    /**
     * Method entrace user in system
     * 
     * @param user
     * @param pws
     * @return
     */
    Login login(String user, String pws);

    /**
     * Method that authenticates the user.
     * 
     * @param email
     * @param token
     * @return
     * @throws KidFriendlyException
     */
    User authenticateUser(String email, String token) throws KidFriendlyException;

    /**
     * Method to authenticate social network user.
     * 
     * @param idSocialNetwork
     * @return
     * @throws KidFriendlyException
     */
    User authenticateSocialNetwork(Long idSocialNetwork) throws KidFriendlyException;

    /**
     * Method that checks if the login exists. If true an exception will be
     * thrown.
     * 
     * @param login
     * @throws KidFriendlyException
     */
    void exist(Login login) throws KidFriendlyException;

    /**
     * Method to update.
     * 
     * @param login
     * @return
     * @throws KidFriendlyException
     * @throws NoSuchAlgorithmException
     */
    Login update(Login login) throws KidFriendlyException, NoSuchAlgorithmException;
}

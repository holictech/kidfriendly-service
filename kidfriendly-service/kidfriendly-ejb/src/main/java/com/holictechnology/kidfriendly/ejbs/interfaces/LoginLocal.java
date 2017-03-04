package com.holictechnology.kidfriendly.ejbs.interfaces;


import java.util.List;

import javax.ejb.Local;

import com.holictechnology.kidfriendly.domain.dtos.LoginDto;
import com.holictechnology.kidfriendly.domain.dtos.MessageDto;
import com.holictechnology.kidfriendly.domain.entitys.Login;
import com.holictechnology.kidfriendly.domain.entitys.User;
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
     * @return
     * @throws Exception
     */
    User authenticateUser(String email) throws KidFriendlyException;

    /**
     * TODO - COLOCAR O COMENTÁRIO.
     * 
     * @param idSocialNetwork
     * @return
     * @throws KidFriendlyException
     */
    User authenticateSocialNetwork(Long idSocialNetwork) throws KidFriendlyException;
}

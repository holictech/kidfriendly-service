package com.holictechnology.kidfriendly.controller.login;


import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.holictechnology.kidfriendly.controller.AbstractController;
import com.holictechnology.kidfriendly.domain.dtos.LoginDto;
import com.holictechnology.kidfriendly.domain.entitys.Login;
import com.holictechnology.kidfriendly.ejbs.interfaces.LoginLocal;
import com.holictechnology.kidfriendly.library.exceptions.KidFriendlyException;
import com.holictechnology.kidfriendly.library.messages.KidFriendlyMessages;


@Stateless
@Path(value = "/login")
public class LoginController extends AbstractController {

    private static final long serialVersionUID = -582220279986383312L;

    @EJB
    private LoginLocal loginLocal;
//
//    @GET
//    @Path(value = "/authenticate-user/{email}")
//    @Produces(value = MediaType.APPLICATION_JSON)
//    public Response authenticate(@PathParam(value = "email") String email) {
//        UserDto userDto = null;
//
//        try {
//            userDto = loginLocal.authenticate(email);
//        } catch (Exception e) {
//            createLogger(this.getClass()).error(e.getMessage());
//        }
//
//        return createResponse(userDto);
//    }
//
//    @GET
//    @Path(value = "/authenticate-company")
//    @Produces(value = MediaType.APPLICATION_JSON)
//    public Response authenticate() {
//        return createResponse(null);
//    }
    
    
    @GET
    @Path("/search-user-adm/{search}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response searchAdm(@PathParam("search") String search) throws KidFriendlyException{
    	List<LoginDto> loginDtos = null;
    	
    	try {
    		loginDtos = loginLocal.returnLoginAdm(search);
        } catch (Exception exception) {
            error(getClass(), exception, KidFriendlyMessages.ERROR_LIST_RATING);
        }
    	
    	return ok(loginDtos);
    }
    
    @PUT
    @Path("/update-user-adm")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUserAdm(LoginDto loginDto) throws KidFriendlyException{
    	LoginDto login = null;
    	
    	try {
    		login = loginLocal.saveOrAlterUserAdm(loginDto);
        } catch (Exception exception) {
            error(getClass(), exception, KidFriendlyMessages.ERROR_LIST_RATING);
        }
    	
    	return ok(login);
    }
    
    @DELETE
    @Path("/remove-user/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteUserAdm(@PathParam("id") String id){
    	return ok(loginLocal.deleteUserAdm(id));
    }
    
    @POST
    @Path("/register-user-adm/{user}/{pws}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response registerUserAdm(@PathParam("user") String user, @PathParam("pws") String pws){
    	return ok(loginLocal.registerUserAdm(user, pws));
    }
    
    @GET
    @Path("/login-entrace/{user}/{pws}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(@PathParam("user") String user, @PathParam("pws") String pws) throws KidFriendlyException{
    	Login login = null;
    	try{
    		login = loginLocal.login(user, pws);
    	}catch (Exception e) {
    		error(getClass(), e, KidFriendlyMessages.ERROR_AUTHENTICATE_LOGIN_NOT_FOUND);
		}
    	
    	return ok(login);
    }
    
}

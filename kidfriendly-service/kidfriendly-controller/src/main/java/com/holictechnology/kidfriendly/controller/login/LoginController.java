package com.holictechnology.kidfriendly.controller.login;


import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.holictechnology.kidfriendly.controller.AbstractController;
import com.holictechnology.kidfriendly.domain.dtos.LoginDto;
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
    @Path("/search-user-adm")
    @Produces(MediaType.APPLICATION_JSON)
    public Response searchAdm() throws KidFriendlyException{
    	List<LoginDto> loginDtos = null;
    	
    	try {
    		loginDtos = loginLocal.returnLoginAdm();
        } catch (Exception exception) {
            error(getClass(), exception, KidFriendlyMessages.ERROR_LIST_RATING);
        }
    	
    	return ok(loginDtos);
    }
    
}

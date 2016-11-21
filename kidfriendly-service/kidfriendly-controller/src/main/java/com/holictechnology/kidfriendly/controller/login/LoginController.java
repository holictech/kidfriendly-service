package com.holictechnology.kidfriendly.controller.login;


import javax.ejb.Stateless;
import javax.ws.rs.Path;

import com.holictechnology.kidfriendly.controller.AbstractController;


@Stateless
@Path(value = "/login")
public class LoginController extends AbstractController {

    private static final long serialVersionUID = -582220279986383312L;

//    @EJB
//    private LoginLocal loginLocal;
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
}

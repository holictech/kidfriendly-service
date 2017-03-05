package com.holictechnology.kidfriendly.controller.user;


import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.holictechnology.kidfriendly.controller.AbstractController;
import com.holictechnology.kidfriendly.domain.entitys.User;
import com.holictechnology.kidfriendly.ejbs.interfaces.UserLocal;
import com.holictechnology.kidfriendly.library.exceptions.KidFriendlyException;
import com.holictechnology.kidfriendly.library.messages.KidFriendlyMessages;


@Stateless
@Path(value = "/user")
public class UserController extends AbstractController {

    private static final long serialVersionUID = 8835168701212508626L;

    @EJB
    private UserLocal userLocal;

    @POST
    @Path(value = "/includesocialnetwork")
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response includeSocialNetwork(User user) throws KidFriendlyException {
        try {
            userLocal.includeSocialNetwork(user);
        } catch (Exception exception) {
            error(getClass(), exception, KidFriendlyMessages.ERROR_INCLUDE_USER);
        }

        return ok(user);
    }
}

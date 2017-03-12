package com.holictechnology.kidfriendly.controller.user;


import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.holictechnology.kidfriendly.controller.AbstractController;
import com.holictechnology.kidfriendly.domain.entitys.User;
import com.holictechnology.kidfriendly.ejbs.interfaces.UserLocal;
import com.holictechnology.kidfriendly.library.exceptions.KidFriendlyException;
import com.holictechnology.kidfriendly.library.messages.KidFriendlyMessages;
import com.holictechnology.kidfriendly.library.utilites.CriptographUtilities;
import com.holictechnology.kidfriendly.library.utilites.DateUtilities;


@Stateless
@Path(value = "/user")
public class UserController extends AbstractController {

    private static final long serialVersionUID = 8835168701212508626L;
    private static final String PATTERN = "yyyy-MM-dd";

    @EJB
    private UserLocal userLocal;

    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response include(User user) throws KidFriendlyException {
        try {
            userLocal.includeWithLogin(user);
            user.getLogin().setDesPassword(CriptographUtilities.getInstance().createToken(user.getLogin().getIdLogin(), user.getLogin().getDesPassword()));
        } catch (NoSuchAlgorithmException exception) {
            getLogger(getClass()).error(exception.getMessage(), exception);
        } catch (Exception exception) {
            error(getClass(), exception, KidFriendlyMessages.ERROR_INCLUDE_USER);
        }

        return ok(user);
    }

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

    @GET
    @Path(value = "/minmaxdtbirthday")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response minMaxDtBirthDay() throws KidFriendlyException {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("minDate", DateUtilities.subtractYear(-100, PATTERN));
        map.put("maxDate", DateUtilities.subtractYear(0, PATTERN));

        return ok(map);
    }

    @PUT
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response update(User user) throws KidFriendlyException {
        try {
            userLocal.update(user);
        } catch (Exception exception) {
            error(getClass(), exception, KidFriendlyMessages.ERROR_UPDATE_USER);
        }

        return ok(user);
    }
}

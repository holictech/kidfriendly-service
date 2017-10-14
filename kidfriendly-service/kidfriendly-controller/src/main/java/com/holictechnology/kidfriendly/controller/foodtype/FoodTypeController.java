package com.holictechnology.kidfriendly.controller.foodtype;


import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.holictechnology.kidfriendly.controller.AbstractController;
import com.holictechnology.kidfriendly.domain.entity.FoodType;
import com.holictechnology.kidfriendly.ejb.interfaces.FoodTypeLocal;
import com.holictechnology.kidfriendly.library.exceptions.KidFriendlyException;
import com.holictechnology.kidfriendly.library.messages.KidFriendlyMessages;


@Stateless
@Path(value = "/foodtype")
public class FoodTypeController extends AbstractController {

    private static final long serialVersionUID = 3068889304248681412L;

    @EJB
    private FoodTypeLocal foodTypeLocal;

    @GET
    @Path(value = "/listall")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response listAll() {
        return ok(foodTypeLocal.listAll());
    }

    @GET
    @Path(value = "/listbycompany/{idcompany}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response listByCompany(@PathParam(value = "idcompany") Long idCompany) throws KidFriendlyException {
        Collection<FoodType> foodTypes = null;

        try {
            foodTypes = foodTypeLocal.listByCompany(idCompany);
        } catch (Exception exception) {
            error(getClass(), exception, KidFriendlyMessages.ERROR_LIST_FOOD_TYPE_BY_COMPANY);
        }

        return ok(foodTypes);
    }
}

package com.holictechnology.kidfriendly.controller.typefood;


import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.holictechnology.kidfriendly.controller.AbstractController;
import com.holictechnology.kidfriendly.ejb.interfaces.TypeFoodLocal;


@Stateless
@Path("/typefood")
public class TypeFoodController extends AbstractController {

    private static final long serialVersionUID = 3068889304248681412L;

    @EJB
    private TypeFoodLocal typeFoodLocal;

    @GET
    @Path("/typefood")
    public Response listAll() {
        return ok(typeFoodLocal.listAll());
    }
}

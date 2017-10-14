package com.holictechnology.kidfriendly.controller.week;


import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.holictechnology.kidfriendly.controller.AbstractController;
import com.holictechnology.kidfriendly.ejb.interfaces.WeekLocal;


@Stateless
@Path(value = "/week")
public class WeekController extends AbstractController {

    private static final long serialVersionUID = 701882831970388533L;

    @EJB
    private WeekLocal weekLocal;

    @GET
    @Path(value = "/listall")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response listAll() {
        return ok(weekLocal.listAll());
    }
}

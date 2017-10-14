package com.holictechnology.kidfriendly.controller.schedule;


import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.holictechnology.kidfriendly.controller.AbstractController;
import com.holictechnology.kidfriendly.ejb.interfaces.ScheduleLocal;


@Stateless
@Path(value = "/schedule")
public class ScheduleController extends AbstractController {

    private static final long serialVersionUID = 273995064529353565L;

    @EJB
    private ScheduleLocal scheduleLocal;

    @GET
    @Path(value = "/listall")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response listAll() {
        return ok(scheduleLocal.listAll());
    }
}

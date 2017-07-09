package com.holictechnology.kidfriendly.controller.util;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.holictechnology.kidfriendly.controller.AbstractController;
import com.holictechnology.kidfriendly.ejbs.interfaces.WeekLocal;

@Stateless
@Path("/week")
public class WeekController extends AbstractController {

	private static final long serialVersionUID = 701882831970388533L;
	
	@EJB
	private WeekLocal week;
	
	@GET
	@Path("/week")
	public Response receivedWeek(){
		return ok(week.weekAll());
	}

}

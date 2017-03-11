package com.holictechnology.kidfriendly.controller.home;


import java.util.HashMap;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.holictechnology.kidfriendly.controller.AbstractController;
import com.holictechnology.kidfriendly.ejbs.interfaces.CompanyLocal;
import com.holictechnology.kidfriendly.library.exceptions.KidFriendlyException;
import com.holictechnology.kidfriendly.library.messages.KidFriendlyMessages;


@Stateless
@Path(value = "/home")
public class HomeController extends AbstractController {

    private static final long serialVersionUID = -8310756154712464910L;
    private static final String SUGGESTIONS = "suggestions";
    private static final String NEXT_TO_ME = "nextToMe";
    private static final Integer DEFAULT_LIMIT = 5;

    @EJB
    private CompanyLocal companyLocal;

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response listCompanies(@QueryParam(value = "longitude") Double longitude, @QueryParam(value = "latitude") Double latitude)
            throws KidFriendlyException {
        Map<String, Object> map = new HashMap<String, Object>();

        try {
            map.put(SUGGESTIONS, companyLocal.listSuggestions(DEFAULT_LIMIT));
            map.put(NEXT_TO_ME, companyLocal.listNextToMe(DEFAULT_LIMIT, longitude, latitude));
        } catch (Exception exception) {
            error(getClass(), exception, KidFriendlyMessages.ERROR_LIST_COMPANY);
        }

        System.out.println();

        return ok(map);
    }
}

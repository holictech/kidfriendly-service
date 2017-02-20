package com.holictechnology.kidfriendly.controller.locality;


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
import com.holictechnology.kidfriendly.domain.entitys.City;
import com.holictechnology.kidfriendly.domain.entitys.Country;
import com.holictechnology.kidfriendly.domain.entitys.State;
import com.holictechnology.kidfriendly.ejbs.interfaces.LocalityLocal;
import com.holictechnology.kidfriendly.library.exceptions.KidFriendlyException;
import com.holictechnology.kidfriendly.library.messages.KidFriendlyMessages;


@Stateless
@Path(value = "/locality")
public class LocalityController extends AbstractController {

    private static final long serialVersionUID = 1622667971739144550L;

    @EJB
    private LocalityLocal localityLocal;

    @GET
    @Path("/listallcountries")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response listAllCoutries() throws KidFriendlyException {
        Collection<Country> listCountry = null;

        try {
            listCountry = localityLocal.listAllCountries();
        } catch (Exception exception) {
            error(getClass(), exception, KidFriendlyMessages.ERROR_LIST_COUNTRY);
        }

        return ok(listCountry);
    }

    @GET
    @Path("/liststatebycountry/{idCountry}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response listStateByCountry(@PathParam(value = "idCountry") Integer idCountry) throws KidFriendlyException {
        Collection<State> listState = null;

        try {
            listState = localityLocal.listStateByCountry(idCountry);
        } catch (Exception exception) {
            error(getClass(), exception, KidFriendlyMessages.ERROR_LIST_STATE);
        }

        return ok(listState);
    }

    @GET
    @Path("/liststatewithcitybycountry/{idCountry}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response listStateWithCityByCountry(@PathParam(value = "idCountry") Integer idCountry) throws KidFriendlyException {
        Collection<State> listState = null;

        try {
            listState = localityLocal.listStateWithCityByCountry(idCountry);
        } catch (Exception exception) {
            error(getClass(), exception, KidFriendlyMessages.ERROR_LIST_STATE);
        }

        return ok(listState);
    }

    @GET
    @Path("/listcitybystate/{idState}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response listCityByState(@PathParam(value = "idState") Integer idState) throws KidFriendlyException {
        Collection<City> listCity = null;

        try {
            listCity = localityLocal.listCityByState(idState);
        } catch (Exception exception) {
            error(getClass(), exception, KidFriendlyMessages.ERROR_LIST_CITY);
        }

        return ok(listCity);
    }
}

package com.holictechnology.kidfriendly.controller.locality;


import javax.ejb.Stateless;
import javax.ws.rs.Path;

import com.holictechnology.kidfriendly.controller.AbstractController;


@Stateless
@Path(value = "/locality")
public class LocalityController extends AbstractController {

    private static final long serialVersionUID = 1622667971739144550L;

//    @EJB
//    private LocalityLocal localityLocal;
//
//    @GET
//    @Path("/listallcountries")
//    @Produces(value = MediaType.APPLICATION_JSON)
//    public Response listAllCoutries() {
//        List<Country> listCountry = null;
//
//        try {
//            listCountry = localityLocal.listAllCountries();
//        } catch (Exception e) {
//            createLogger(this.getClass()).error(e.getMessage());
//        }
//
//        return createResponse(listCountry);
//    }
//
//    @GET
//    @Path("/liststatebycountry/{idcountry}")
//    @Produces(value = MediaType.APPLICATION_JSON)
//    public Response listStateByCountry(@PathParam(value = "idcountry") Integer idCountry) {
//        List<State> listState = null;
//
//        try {
//            listState = localityLocal.listStateByCountry(idCountry);
//        } catch (Exception e) {
//            createLogger(this.getClass()).error(e.getMessage());
//        }
//
//        return createResponse(listState);
//    }
//
//    @GET
//    @Path("/listcitybystate/{idstate}")
//    @Produces(value = MediaType.APPLICATION_JSON)
//    public Response listCityByState(@PathParam(value = "idstate") Integer idState) {
//        List<City> listCity = null;
//
//        try {
//            listCity = localityLocal.listCityByState(idState);
//        } catch (Exception e) {
//            createLogger(this.getClass()).error(e.getMessage());
//        }
//
//        return createResponse(listCity);
//    }
}

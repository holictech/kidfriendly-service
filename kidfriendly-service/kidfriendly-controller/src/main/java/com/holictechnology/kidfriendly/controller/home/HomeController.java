package com.holictechnology.kidfriendly.controller.home;


import java.util.Collection;
import java.util.LinkedList;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.holictechnology.kidfriendly.controller.AbstractController;
import com.holictechnology.kidfriendly.domain.dtos.CompanyDto;
import com.holictechnology.kidfriendly.ejbs.interfaces.CompanyLocal;
import com.holictechnology.kidfriendly.library.exceptions.KidFriendlyException;
import com.holictechnology.kidfriendly.library.messages.KidFriendlyMessages;


@Stateless
@Path(value = "/home")
public class HomeController extends AbstractController {

    private static final long serialVersionUID = -8310756154712464910L;
    private static final Integer DEFAULT_LIMIT = 20;

    @EJB
    private CompanyLocal companyLocal;

    @GET
    @Path(value = "/suggestions")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response listSuggestions() throws KidFriendlyException {
        Collection<CompanyDto> listCompanyDto = new LinkedList<>();

        try {
            listCompanyDto.addAll(companyLocal.listSuggestions(DEFAULT_LIMIT));
        } catch (Exception exception) {
            error(getClass(), exception, KidFriendlyMessages.ERROR_LIST_COMPANY_SUGGESTIONS);
        }

        return ok(listCompanyDto);
    }

    @GET
    @Path(value = "/nexttome")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response listNextToMe(@QueryParam(value = "longitude") Double longitude, @QueryParam(value = "latitude") Double latitude)
            throws KidFriendlyException {
        Collection<CompanyDto> listCompanyDto = new LinkedList<>();

        try {
            listCompanyDto.addAll(companyLocal.listNextToMe(DEFAULT_LIMIT, longitude, latitude));
        } catch (Exception exception) {
            error(getClass(), exception, KidFriendlyMessages.ERROR_LIST_COMPANY_NEXTTOME);
        }

        return ok(listCompanyDto);
    }
}

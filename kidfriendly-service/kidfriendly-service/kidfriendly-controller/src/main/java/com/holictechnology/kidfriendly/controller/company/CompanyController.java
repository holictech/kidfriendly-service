package com.holictechnology.kidfriendly.controller.company;


import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.holictechnology.kidfriendly.controller.AbstractController;
import com.holictechnology.kidfriendly.domain.entitys.Company;
import com.holictechnology.kidfriendly.ejbs.interfaces.CompanyLocal;
import com.holictechnology.kidfriendly.library.exceptions.KidFriendlyException;
import com.holictechnology.kidfriendly.library.messages.KidFriendlyMessages;


@Stateless
@Path(value = "/company")
public class CompanyController extends AbstractController {

    private static final long serialVersionUID = -8531055502119999069L;

    @EJB
    private CompanyLocal companyLocal;

    @GET
    @Path(value = "{primaryKey}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response find(@PathParam(value = "primaryKey") Long primaryKey) throws KidFriendlyException {
        Company company = null;

        try {
            companyLocal.find(primaryKey);
        } catch (Exception exception) {
            error(getClass(), new KidFriendlyException(KidFriendlyMessages.ERROR_COMPANY_BY_PRIMARY_KEY, exception));
        }

        return ok(company);
    }
}

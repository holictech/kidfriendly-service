package com.holictechnology.kidfriendly.controller.company;


import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.holictechnology.kidfriendly.controller.AbstractController;
import com.holictechnology.kidfriendly.domain.dtos.paginator.PaginatorDto;
import com.holictechnology.kidfriendly.domain.entitys.Company;
import com.holictechnology.kidfriendly.ejbs.interfaces.CharacteristicLocal;
import com.holictechnology.kidfriendly.ejbs.interfaces.CompanyLocal;
import com.holictechnology.kidfriendly.ejbs.interfaces.RatingLocal;
import com.holictechnology.kidfriendly.library.exceptions.KidFriendlyException;
import com.holictechnology.kidfriendly.library.messages.KidFriendlyMessages;


@Stateless
@Path(value = "/company")
public class CompanyController extends AbstractController {

    private static final long serialVersionUID = -8531055502119999069L;

    @EJB
    private CompanyLocal companyLocal;

    @EJB
    private CharacteristicLocal characteristicLocal;

    @EJB
    private RatingLocal ratingLocal;

    @GET
    @Path(value = "/{primaryKey}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response find(@PathParam(value = "primaryKey") Long primaryKey) throws KidFriendlyException {
        Company company = null;

        try {
            company = companyLocal.find(primaryKey);
        } catch (Exception exception) {
            error(getClass(), exception, KidFriendlyMessages.ERROR_COMPANY_BY_PRIMARY_KEY);
        }

        return ok(company);
    }

    @GET
    @Path(value = "/details/{primaryKey}")
    public Response details(@PathParam(value = "primaryKey") Long primaryKey, @QueryParam(value = "idCategory") Integer idCategory)
            throws KidFriendlyException {
        Map<String, Object> details = new HashMap<String, Object>();

        try {
            details.put("company", companyLocal.find(primaryKey, "address.city.state", "phones"));
            details.put("characteristics", characteristicLocal.listByCompanyCategory(primaryKey, idCategory));
            details.put("ratings", ratingLocal.listByCompany(primaryKey, new PaginatorDto(BigInteger.TEN.longValue())));
        } catch (Exception exception) {
            error(getClass(), exception, KidFriendlyMessages.ERROR_COMPANY_BY_PRIMARY_KEY);
        }

        return ok(details);
    }
}

package com.holictechnology.kidfriendly.controller.rating;


import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.holictechnology.kidfriendly.controller.AbstractController;
import com.holictechnology.kidfriendly.domain.dtos.RatingDto;
import com.holictechnology.kidfriendly.domain.dtos.paginator.PaginatorDto;
import com.holictechnology.kidfriendly.domain.dtos.result.ResultDto;
import com.holictechnology.kidfriendly.ejbs.interfaces.RatingLocal;
import com.holictechnology.kidfriendly.library.exceptions.KidFriendlyException;
import com.holictechnology.kidfriendly.library.messages.KidFriendlyMessages;


@Stateless
@Path(value = "/rating")
public class RatingController extends AbstractController {

    private static final long serialVersionUID = -3927236943583790641L;

    @EJB
    private RatingLocal ratingLocal;

    @GET
    @Path(value = "/listpending")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response listPending() throws KidFriendlyException {
        Collection<RatingDto> ratings = null;

        try {
            ratings = ratingLocal.listPending();
        } catch (Exception exception) {
            error(getClass(), exception, KidFriendlyMessages.ERROR_LIST_RATING);
        }

        return ok(ratings);
    }

    @GET
    @Path(value = "/listbycompany/{idCompany}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response listByCompany(@PathParam(value = "idCompany") Long idCompany, @BeanParam PaginatorDto paginatorDto) throws KidFriendlyException {
        ResultDto<RatingDto> resultDto = null;

        try {
            resultDto = ratingLocal.listByCompany(idCompany, paginatorDto);
        } catch (Exception exception) {
            error(getClass(), exception, KidFriendlyMessages.ERROR_LIST_RATING);
        }

        return ok(resultDto);
    }

    @PUT
    @Path(value = "/activate/{primaryKey}")
    public void activate(@PathParam(value = "primaryKey") Long primaryKey) throws KidFriendlyException {
        try {
            ratingLocal.activate(primaryKey);
        } catch (Exception exception) {
            error(getClass(), exception, KidFriendlyMessages.ERROR_ACTIVATE_RATING);
        }
    }
    
    @PUT
    @Path(value = "/activate-logic-fail/{primaryKey}")
    public void deleteLogic(@PathParam(value = "primaryKey") Long primaryKey) throws KidFriendlyException {
        try {
            ratingLocal.activateNotShow(primaryKey);
        } catch (Exception exception) {
            error(getClass(), (KidFriendlyException.class.isAssignableFrom(exception.getClass()) ? (KidFriendlyException) exception
                    : new KidFriendlyException(KidFriendlyMessages.ERROR_ACTIVATE_RATING, exception)));
        }
    }
    
}

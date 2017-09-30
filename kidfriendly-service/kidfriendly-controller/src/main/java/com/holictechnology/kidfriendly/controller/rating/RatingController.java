package com.holictechnology.kidfriendly.controller.rating;


import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.holictechnology.kidfriendly.controller.AbstractController;
import com.holictechnology.kidfriendly.domain.dto.RatingDto;
import com.holictechnology.kidfriendly.domain.dto.paginator.PaginatorDto;
import com.holictechnology.kidfriendly.domain.dto.result.ResultDto;
import com.holictechnology.kidfriendly.domain.entity.Rating;
import com.holictechnology.kidfriendly.ejb.interfaces.RatingLocal;
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
    @Consumes(value = MediaType.APPLICATION_JSON)
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
    @Path(value = "/delete/{primaryKey}")
    public void delete(@PathParam(value = "primaryKey") Long primaryKey) throws KidFriendlyException {
        try {
            ratingLocal.delete(primaryKey);
        } catch (Exception exception) {
            error(getClass(), exception, KidFriendlyMessages.ERROR_DELETE_RATING);
        }
    }

    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    public void include(Rating rating) throws KidFriendlyException {
        try {
            ratingLocal.include(rating);
        } catch (Exception exception) {
            error(getClass(), exception, KidFriendlyMessages.ERROR_INCLUDE_RATING);
        }
    }

    @GET
    @Path(value = "/haspermission/{idCompany}/{idUser}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response hasPermission(@PathParam(value = "idCompany") Long idCompany, @PathParam(value = "idUser") Long idUser) throws KidFriendlyException {
        Boolean hasPermission = Boolean.FALSE;

        try {
            hasPermission = ratingLocal.hasPermission(idCompany, idUser);
        } catch (Exception exception) {
            error(getClass(), exception, KidFriendlyMessages.ERROR_HAS_PERMISSION_RATING);
        }

        return ok(hasPermission);
    }
}

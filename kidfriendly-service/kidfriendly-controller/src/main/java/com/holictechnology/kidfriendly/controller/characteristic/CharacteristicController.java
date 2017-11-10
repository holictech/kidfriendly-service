package com.holictechnology.kidfriendly.controller.characteristic;


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
import com.holictechnology.kidfriendly.domain.entity.Characteristic;
import com.holictechnology.kidfriendly.ejb.interfaces.CharacteristicLocal;
import com.holictechnology.kidfriendly.library.exceptions.KidFriendlyException;
import com.holictechnology.kidfriendly.library.messages.KidFriendlyMessages;


@Stateless
@Path(value = "/characteristic")
public class CharacteristicController extends AbstractController {

    private static final long serialVersionUID = -357899393420921091L;

    @EJB
    private CharacteristicLocal characteristicLocal;

    @GET
    @Path(value = "/listbycategory/{idCategory}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response listByCategory(@PathParam(value = "idCategory") Integer idCategory) throws KidFriendlyException {
        Collection<Characteristic> characteristics = null;

        try {
            characteristics = characteristicLocal.listByCategory(idCategory);
        } catch (Exception exception) {
            error(getClass(), exception, KidFriendlyMessages.ERROR_LIST_CHARACTERISTIC);
        }

        return ok(characteristics);
    }

    @GET
    @Path(value = "/listbycompany/{idCompany}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response listByCompany(@PathParam(value = "idCompany") Long idCompany) throws KidFriendlyException {
        return listByCompanyCategory(idCompany, null);
    }

    @GET
    @Path(value = "/listbycompanycategory/{idCompany}/{idCategory}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response listByCompanyCategory(@PathParam(value = "idCompany") Long idCompany, @PathParam(value = "idCategory") Integer idCategory)
            throws KidFriendlyException {
        Collection<Characteristic> characteristics = null;

        try {
            characteristics = characteristicLocal.listByCompanyCategory(idCompany, idCategory);
        } catch (Exception exception) {
            error(getClass(), exception, KidFriendlyMessages.ERROR_LIST_CHARACTERISTIC);
        }

        return ok(characteristics);
    }

    @GET
    @Path(value = "/listall")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response listAll() throws KidFriendlyException {
        Collection<Characteristic> characteristics = null;

        try {
            characteristics = characteristicLocal.listAll();
        } catch (Exception exception) {
            error(getClass(), exception, KidFriendlyMessages.ERROR_LIST_CHARACTERISTIC);
        }

        return ok(characteristics);
    }
}

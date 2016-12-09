package com.holictechnology.kidfriendly.controller.characteristic;


import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.holictechnology.kidfriendly.controller.AbstractController;
import com.holictechnology.kidfriendly.domain.entitys.Characteristic;
import com.holictechnology.kidfriendly.ejbs.interfaces.CharacteristicLocal;
import com.holictechnology.kidfriendly.library.exceptions.KidFriendlyException;
import com.holictechnology.kidfriendly.library.messages.KidFriendlyMessages;


@Stateless
@Path(value = "/characteristic")
public class CharacteristicController extends AbstractController {

    private static final long serialVersionUID = -357899393420921091L;

    @EJB
    private CharacteristicLocal characteristicLocal;

    @GET
    @Path(value = "/listbycategory")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response listByCategory(@QueryParam(value = "idCategory") Integer idCategory) throws KidFriendlyException {
        Collection<Characteristic> characteristics = null;

        try {
            characteristics = characteristicLocal.listByCategory(idCategory);
        } catch (Exception exception) {
            error(getClass(), (KidFriendlyException.class.isAssignableFrom(exception.getClass()) ? (KidFriendlyException) exception
                    : new KidFriendlyException(KidFriendlyMessages.ERROR_LIST_CHARACTERISTIC_BY_CATEGORY, exception)));
        }

        return ok(characteristics);
    }
}

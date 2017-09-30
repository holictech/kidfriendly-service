package com.holictechnology.kidfriendly.controller.image;


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
import com.holictechnology.kidfriendly.domain.entity.Image;
import com.holictechnology.kidfriendly.ejb.interfaces.ImageLocal;
import com.holictechnology.kidfriendly.library.exceptions.KidFriendlyException;
import com.holictechnology.kidfriendly.library.messages.KidFriendlyMessages;


@Stateless
@Path(value = "/image")
public class ImageController extends AbstractController {

    private static final long serialVersionUID = 530244971549913162L;

    @EJB
    private ImageLocal imageLocal;

    @GET
    @Path(value = "/listbycompany/{idCompany}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response listByCompany(@PathParam(value = "idCompany") Long idCompany) throws KidFriendlyException {
        Collection<Image> images = null;

        try {
            images = imageLocal.listByCompany(idCompany);
        } catch (Exception exception) {
            error(getClass(), exception, KidFriendlyMessages.ERROR_LIST_IMAGE);
        }

        return ok(images);
    }
}

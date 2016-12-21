package com.holictechnology.kidfriendly.controller.category;


import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.holictechnology.kidfriendly.controller.AbstractController;
import com.holictechnology.kidfriendly.domain.entitys.Category;
import com.holictechnology.kidfriendly.ejbs.interfaces.CategoryLocal;
import com.holictechnology.kidfriendly.library.exceptions.KidFriendlyException;
import com.holictechnology.kidfriendly.library.messages.KidFriendlyMessages;


@Stateless
@Path(value = "/category")
public class CategoryController extends AbstractController {

    private static final long serialVersionUID = -9010798745443025193L;

    @EJB
    private CategoryLocal categoryLocal;

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response listAll() throws KidFriendlyException {
        Collection<Category> categories = null;

        try {
            categories = categoryLocal.listAll();
        } catch (Exception exception) {
            error(getClass(), exception, KidFriendlyMessages.ERROR_LIST_CATEGORY);
        }

        return ok(categories);
    }
}

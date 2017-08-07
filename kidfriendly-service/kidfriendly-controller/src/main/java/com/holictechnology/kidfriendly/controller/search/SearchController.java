package com.holictechnology.kidfriendly.controller.search;


import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.holictechnology.kidfriendly.controller.AbstractController;
import com.holictechnology.kidfriendly.domain.dtos.CompanyDto;
import com.holictechnology.kidfriendly.domain.dtos.filters.CompanyFilterDto;
import com.holictechnology.kidfriendly.domain.dtos.result.ResultDto;
import com.holictechnology.kidfriendly.ejbs.interfaces.CompanyLocal;
import com.holictechnology.kidfriendly.library.exceptions.KidFriendlyException;
import com.holictechnology.kidfriendly.library.messages.KidFriendlyMessages;


@Stateless
@Path(value = "/search")
public class SearchController extends AbstractController {

    private static final long serialVersionUID = 5479075605870543898L;

    @EJB
    private CompanyLocal companyLocal;

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response search(@BeanParam CompanyFilterDto companyFilterDto) throws KidFriendlyException {
        ResultDto<CompanyDto> resultDto = null;

        try {
            resultDto = companyLocal.search(companyFilterDto);
        } catch (Exception exception) {
            error(getClass(), exception, KidFriendlyMessages.ERROR_COMPANY_SEARCH);
        }

        return ok(resultDto);
    }
}

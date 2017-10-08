package com.holictechnology.kidfriendly.controller.company;


import java.util.Base64;

import javax.ejb.EJB;
import javax.ejb.Stateless;
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
import com.holictechnology.kidfriendly.domain.dto.CompanyDto;
import com.holictechnology.kidfriendly.domain.dto.ImageDto;
import com.holictechnology.kidfriendly.domain.entity.Company;
import com.holictechnology.kidfriendly.ejb.interfaces.CompanyLocal;
import com.holictechnology.kidfriendly.library.exceptions.KidFriendlyException;
import com.holictechnology.kidfriendly.library.messages.KidFriendlyMessages;


@Stateless
@Path(value = "/company")
public class CompanyController extends AbstractController {

    private static final long serialVersionUID = -8531055502119999069L;

    @EJB
    private CompanyLocal companyLocal;

    @POST
    @Path("/register-company")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveCompany(CompanyDto companyDto) throws KidFriendlyException {
        try {
            companyLocal.saveCompany(companyDto);
        } catch (KidFriendlyException e) {
            error(getClass(), e, KidFriendlyMessages.ERROR_COMPANY_SAVE);
        }

        return ok(companyDto);
    }

    @GET
    @Path("/search-company/{nameEstablishment}/{responsibleEstablishment}/{cnpj}/{objCity}")
    public Response searchCompany(@PathParam("nameEstablishment") String nameEstablishment,
            @PathParam("responsibleEstablishment") String responsibleEstablishment,
            @PathParam("cnpj") String cnpj, @PathParam("objCity") Integer objCity) {
        return ok(companyLocal.searchCompanySimple(nameEstablishment, responsibleEstablishment, cnpj, objCity));
    }

    @POST
    @Path("/image-selected")
    @Produces(MediaType.APPLICATION_JSON)
    public void imageData(ImageDto imageDto) {
        imageDto.setImgImage(Base64.getDecoder().decode(imageDto.getDataImage()));
        companyLocal.preparImageSaveCompany(imageDto);
    }

    @PUT
    @Path("/inative-company")
    public Response inativeCompany(Company company) {
        return ok(companyLocal.inactivateCompany(company));
    }

    @PUT
    @Path("/edit-company")
    @Produces(MediaType.APPLICATION_JSON)
    public Response editCompany(Company company) {
        return ok(companyLocal.editCompany(company));
    }
}

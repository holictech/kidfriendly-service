package com.holictechnology.kidfriendly.controller.contact;


import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import com.holictechnology.kidfriendly.controller.AbstractController;
import com.holictechnology.kidfriendly.domain.dtos.EmailDto;
import com.holictechnology.kidfriendly.domain.dtos.EmailDto.Recipient;
import com.holictechnology.kidfriendly.ejbs.interfaces.EmailLocal;
import com.holictechnology.kidfriendly.library.exceptions.KidFriendlyException;


@Stateless
@Path(value = "/contact")
public class ContactController extends AbstractController {

    private static final long serialVersionUID = -4409979256028470431L;

    @EJB
    private EmailLocal emailLocal;

    @POST
    @Path(value = "/send")
    @Consumes(value = MediaType.APPLICATION_JSON)
    public void send(EmailDto emailDto) throws KidFriendlyException {
        emailLocal.sendSimpleEmail(emailDto);
    }

    @POST
    @Path(value = "/contact-us")
    @Consumes(value = MediaType.APPLICATION_JSON)
    public void contactUs(EmailDto emailDto) throws KidFriendlyException {
        emailDto.getRecipients().add(new Recipient("Kid Friendly", "faleconosco@kidfriendly.com.br"));
        send(emailDto);
    }
}

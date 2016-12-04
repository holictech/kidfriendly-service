package com.holictechnology.kidfriendly.library.resteasy;


import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import com.holictechnology.kidfriendly.library.exceptions.ExceptionDto;
import com.holictechnology.kidfriendly.library.exceptions.KidFriendlyException;


@Provider
public class ExceptionMapper implements javax.ws.rs.ext.ExceptionMapper<KidFriendlyException> {

    @Override
    public Response toResponse(KidFriendlyException kidFriendlyException) {
        /**
         * TODO - REMOVER HEADER 
         */
        return Response.status(kidFriendlyException.getStatus()).entity(new ExceptionDto(kidFriendlyException.getMessage()))
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization").header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD").header("Access-Control-Max-Age", "1209600").build();
    }
}

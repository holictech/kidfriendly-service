package com.holictechnology.kidfriendly.library.resteasy;


import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import com.holictechnology.kidfriendly.library.exceptions.KidFriendlyExceptionDto;
import com.holictechnology.kidfriendly.library.exceptions.KidFriendlyException;


@Provider
public class ExceptionMapper implements javax.ws.rs.ext.ExceptionMapper<KidFriendlyException> {

    /*
     * (non-Javadoc)
     * 
     * @see javax.ws.rs.ext.ExceptionMapper#toResponse(java.lang.Throwable)
     */
    @Override
    public Response toResponse(KidFriendlyException kidFriendlyException) {
        return Response.status(kidFriendlyException.getStatus()).entity(new KidFriendlyExceptionDto(kidFriendlyException.getMessage())).build();
    }
}

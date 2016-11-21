package com.holictechnology.kidfriendly.library.resteasy;


import javax.ws.rs.Produces;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;


@Provider
@Produces
public class ContextResolver implements javax.ws.rs.ext.ContextResolver<ObjectMapper> {

    private ObjectMapper objectMapper = null;

    public ContextResolver() {
        Hibernate5Module hibernate5Module = new Hibernate5Module();
        hibernate5Module.configure(Hibernate5Module.Feature.FORCE_LAZY_LOADING,
                Boolean.FALSE);

        objectMapper = new ObjectMapper();
        objectMapper.registerModule(hibernate5Module);
    }

    @Override
    public ObjectMapper getContext(Class<?> clazz) {
        return objectMapper;
    }
}

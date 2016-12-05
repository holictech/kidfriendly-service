package com.holictechnology.kidfriendly.controller;


import java.io.Serializable;

import javax.ejb.TransactionManagement;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;
import javax.ws.rs.core.Response;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.holictechnology.kidfriendly.library.exceptions.KidFriendlyException;
import com.holictechnology.kidfriendly.library.messages.KidFriendlyUniqueEnum;


@TransactionManagement
@Transactional(value = TxType.NOT_SUPPORTED)
public abstract class AbstractController implements Serializable {

    private static final long serialVersionUID = -7183158366724998348L;

    /**
     * @param clazz
     * @return
     */
    protected Logger getLogger(Class<?> clazz) {
        return LoggerFactory.getLogger(clazz);
    }

    /**
     * @param clazz
     * @param kidFriendlyException
     * @throws CapitalPrimeException
     */
    protected void error(Class<?> clazz, KidFriendlyException kidFriendlyException) throws KidFriendlyException {
        getLogger(clazz).error(kidFriendlyException.getCause() + ": " + kidFriendlyException.getMessage(), kidFriendlyException);
        ConstraintViolationException constraintViolationException = getConstraintViolationException(kidFriendlyException);

        if (constraintViolationException != null && StringUtils.isNotBlank(constraintViolationException.getConstraintName())) {
            KidFriendlyUniqueEnum kidFriendlyUniqueEnum = KidFriendlyUniqueEnum.valueOf(constraintViolationException.getConstraintName());

            if (kidFriendlyUniqueEnum != null) {
                kidFriendlyException = new KidFriendlyException(kidFriendlyException.getMessage() + " " + kidFriendlyUniqueEnum.getMessage(),
                        kidFriendlyException);
            }
        }

        throw kidFriendlyException;
    }

    /**
     * TODO - REMOVER HEADER
     * 
     * @param object
     * @return
     */
    protected Response ok(Object object) {
        return Response.ok(object).header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization").header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD").header("Access-Control-Max-Age", "1209600").build();
    }

    /**
     * @param throwable
     * @return
     */
    private ConstraintViolationException getConstraintViolationException(Throwable throwable) {
        ConstraintViolationException constraintViolationException = null;

        if (throwable != null) {
            do {
                throwable = throwable.getCause();

                if (throwable != null && ConstraintViolationException.class.isAssignableFrom(throwable.getClass())) {
                    constraintViolationException = (ConstraintViolationException) throwable;
                }
            } while (throwable != null && ((throwable.getCause() != null && throwable.getClass().isAssignableFrom(throwable.getCause().getClass()))
                    || (!ConstraintViolationException.class.isAssignableFrom(throwable.getClass()))));
        }

        return constraintViolationException;
    }
}

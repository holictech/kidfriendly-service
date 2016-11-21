package com.holictechnology.kidfriendly.library.exceptions;


import javax.ws.rs.core.Response.Status;


/**
 * Class responsible for application errors.
 * 
 * @author Wesley
 *
 */
public class KidFriendlyException extends Exception {

    private static final long serialVersionUID = 4261636462411541279L;

    private Status status = null;

    public KidFriendlyException(String message, Throwable cause) {
        this(Status.INTERNAL_SERVER_ERROR, message, cause);
    }

    public KidFriendlyException(Status status, String message, Throwable cause) {
        super(message, cause);
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }
}

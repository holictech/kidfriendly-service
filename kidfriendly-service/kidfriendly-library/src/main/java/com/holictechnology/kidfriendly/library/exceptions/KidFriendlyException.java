package com.holictechnology.kidfriendly.library.exceptions;


import javax.ejb.ApplicationException;
import javax.ws.rs.core.Response.Status;


@ApplicationException(rollback = true)
public class KidFriendlyException extends Exception {

    private static final long serialVersionUID = 4261636462411541279L;

    private Status status = null;

    public KidFriendlyException(String message) {
        this(message, null);
    }

    public KidFriendlyException(Status status, String message) {
        this(status, message, null);
    }

    public KidFriendlyException(Throwable cause) {
        this(cause.getMessage(), cause);
    }

    public KidFriendlyException(Status status, Throwable cause) {
        this(status, cause.getMessage(), cause);
    }

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

package com.gupb.util.exception;


public class GupbRuntimeException extends RuntimeException {
    private static final long serialVersionUID = -1949770547060521702L;

    /**
     * Instantiates a new Gupb runtime exception.
     */
    public GupbRuntimeException() {
    }

    /**
     * Instantiates a new Gupb runtime exception.
     *
     * @param message the message
     */
    public GupbRuntimeException(final String message) {
        super(message);
    }

    /**
     * Instantiates a new Gupb runtime exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public GupbRuntimeException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Gupb runtime exception.
     *
     * @param cause the cause
     */
    public GupbRuntimeException(final Throwable cause) {
        super(cause);
    }
}

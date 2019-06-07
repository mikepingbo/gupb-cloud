package com.gupb.util.exception;

public class GupbException extends RuntimeException {
    private static final long serialVersionUID = -948934144333391208L;

    /**
     * Instantiates a new Gupb exception.
     */
    public GupbException() {
    }

    /**
     * Instantiates a new Gupb exception.
     *
     * @param message the message
     */
    public GupbException(final String message) {
        super(message);
    }

    /**
     * Instantiates a new Gupb exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public GupbException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Gupb exception.
     *
     * @param cause the cause
     */
    public GupbException(final Throwable cause) {
        super(cause);
    }
}

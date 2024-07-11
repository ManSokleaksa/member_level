package com.member_level.member_level.exception;

public class NoSuchElementFoundException extends RuntimeException {

    /**
     * Instantiates a new No such element found exception.
     */
    public NoSuchElementFoundException() {
        super();
    }

    /**
     * Instantiates a new No such element found exception.
     *
     * @param message the message
     */
    public NoSuchElementFoundException(String message) {
        super(message);
    }

    /**
     * Instantiates a new No such element found exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public NoSuchElementFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}

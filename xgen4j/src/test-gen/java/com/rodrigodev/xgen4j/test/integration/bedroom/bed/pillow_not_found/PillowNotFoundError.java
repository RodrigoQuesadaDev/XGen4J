package com.rodrigodev.xgen4j.test.integration.bedroom.bed.pillow_not_found;

import com.rodrigodev.xgen4j.test.integration.bedroom.bed.BedError;

import java.lang.String;

import com.rodrigodev.xgen4j.test.integration.ErrorCode;

/**
 * Autogenerated by XGen on January 1, 0001.
 */
public abstract class PillowNotFoundError extends BedError {

    public static final ErrorCode CODE = new ErrorCode("pillow-not-found", BedError.CODE);

    private static String MESSAGE_FORMAT = "There is no pillow! How can %s sleep here?";

    private static String createMessage(String personName) {
        if(personName == null) throw new NullPointerException("personName");

        return String.format(MESSAGE_FORMAT, personName);
    }

    public static void throwException(String personName) {
        throw new PillowNotFoundException(createMessage(personName));
    }

    public static void throwException(String personName, Throwable cause) {
        throw new PillowNotFoundException(createMessage(personName), cause);
    }


}

package com.rodrigodev.xgen.test.integration.bedroom.bed.pillow_not_found;

import com.rodrigodev.xgen.test.integration.bedroom.bed.BedError;

import java.lang.String;

/**
* Autogenerated by XGen on 12/05/15.
*/
public abstract class PillowNotFoundError extends BedError {

    private static String MESSAGE_FORMAT = "There is no pillow! How can %s sleep here?";

    public static void throwException(String personName) {
        throw new PillowNotFoundException(String.format(MESSAGE_FORMAT, personName));
    }
}

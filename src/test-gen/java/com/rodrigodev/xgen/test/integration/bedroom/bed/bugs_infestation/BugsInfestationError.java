package com.rodrigodev.xgen.test.integration.bedroom.bed.bugs_infestation;

import com.rodrigodev.xgen.test.integration.bedroom.bed.BedError;

import java.lang.String;

import com.rodrigodev.xgen.test.integration.ErrorCode;

/**
 * Autogenerated by XGen on January 1, 0001.
 */
public abstract class BugsInfestationError extends BedError {

    public static final ErrorCode CODE = new ErrorCode("bugs-infestation", BedError.CODE);

    private static String MESSAGE_FORMAT = "Oh shoot, there is bug infestation here. We better move to %s.";

    private static String createMessage(String place) {
        if(place == null) throw new NullPointerException("place");

        return String.format(MESSAGE_FORMAT, place);
    }

    public static void throwException(String place) {
        throw new BugsInfestationException(createMessage(place));
    }

    public static void throwException(String place, Throwable cause) {
        throw new BugsInfestationException(createMessage(place), cause);
    }


}

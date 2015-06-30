package com.rodrigodev.xgen.test.integration.bedroom.bed.bugs_infestation;

import com.rodrigodev.xgen.test.integration.bedroom.bed.BedError;
import com.rodrigodev.xgen.test.integration.ErrorCode;

import java.lang.String;

/**
* Autogenerated by XGen on June 30, 2015.
*/
public abstract class BugsInfestationError extends BedError {

    public static final ErrorCode CODE = new ErrorCode("house.bedroom.bed.bugs-infestation");

    private static String MESSAGE_FORMAT = "Oh shoot, there is bug infestation here. We better move to %s.";

    public static void throwException(String place) {
        throw new BugsInfestationException(String.format(MESSAGE_FORMAT, place));
    }
}

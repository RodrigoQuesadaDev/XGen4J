package com.rodrigodev.xgen.test.integration.bedroom.bed.bed_is_warm;

import com.rodrigodev.xgen.test.integration.bedroom.bed.BedError;

import java.lang.Integer;

import com.rodrigodev.xgen.test.integration.ErrorCode;

/**
 * Autogenerated by XGen on July 13, 2015.
 */
public abstract class BedIsWarmError extends BedError {

    public static final ErrorCode CODE = new ErrorCode("bed-is-warm", BedError.CODE);

    private static String MESSAGE_FORMAT = "Bed #%d is too damn warm!";

    private static String createMessage(Integer bedNumber) {
        if(bedNumber == null) throw new NullPointerException("bedNumber");

        return String.format(MESSAGE_FORMAT, bedNumber);
    }

    public static void throwException(Integer bedNumber) {
        throw new BedIsWarmException(createMessage(bedNumber));
    }

    public static void throwException(Integer bedNumber, Throwable cause) {
        throw new BedIsWarmException(createMessage(bedNumber), cause);
    }


}

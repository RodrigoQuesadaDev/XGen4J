package com.rodrigodev.xgen.test.integration.bedroom.bed.bed_is_warm;

import com.rodrigodev.xgen.test.integration.bedroom.bed.BedError;
import com.rodrigodev.xgen.test.integration.ErrorCode;

import java.lang.Integer;

/**
* Autogenerated by XGen on June 28, 2015.
*/
public abstract class BedIsWarmError extends BedError {

    public static final ErrorCode CODE = new ErrorCode("undefined");

    private static String MESSAGE_FORMAT = "Bed #%d is too damn warm!";

    public static void throwException(Integer bedNumber) {
        throw new BedIsWarmException(String.format(MESSAGE_FORMAT, bedNumber));
    }
}

package com.rodrigodev.xgen.test.integration;

/**
* Autogenerated by XGen on 12/05/15.
*/
public abstract class BedIsWarmError extends BedError {

    private static String MESSAGE_FORMAT = "Bed #%d is too damn warm!";

    public static void throwException(Integer bedNumber) {
        throw new BedIsWarmException(String.format(MESSAGE_FORMAT, bedNumber));
    }
}

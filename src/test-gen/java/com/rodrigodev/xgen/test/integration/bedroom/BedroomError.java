package com.rodrigodev.xgen.test.integration.bedroom;

import com.rodrigodev.xgen.test.integration.HouseError;
import com.rodrigodev.xgen.test.integration.ErrorCode;

import java.lang.String;

/**
* Autogenerated by XGen on July 1, 2015.
*/
public abstract class BedroomError extends HouseError {

    public static final ErrorCode CODE = new ErrorCode("bedroom", HouseError.CODE);

    private static String MESSAGE_FORMAT = "%s's bedroom is not a good place to sleep.";

    public static void throwException(String personName) {
        throw new BedroomException(String.format(MESSAGE_FORMAT, personName));
    }
}

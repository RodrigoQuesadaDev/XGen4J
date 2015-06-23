package com.rodrigodev.xgen.test.integration.bedroom;

import com.rodrigodev.xgen.test.integration.HouseError;

/**
* Autogenerated by XGen on 12/05/15.
*/
public abstract class BedroomError extends HouseError {

    private static String MESSAGE_FORMAT = "%s's bedroom is not a good place to sleep.";

    public static void throwException(String personName) {
        throw new BedroomException(String.format(MESSAGE_FORMAT, personName));
    }
}
package com.rodrigodev.xgen.test.gen.exceptions_generator.generate;

/**
* Autogenerated by XGen on 12/05/15.
*/
public class BedroomError {

    private static String MESSAGE_FORMAT = "%'s bedroom is not a good place to sleep.";

    public static void throwException(String personName) {
        throw new DirtyException(String.format(MESSAGE_FORMAT, personName));
    }
}

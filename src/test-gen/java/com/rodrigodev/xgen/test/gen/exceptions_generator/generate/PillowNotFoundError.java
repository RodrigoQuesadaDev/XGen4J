package com.rodrigodev.xgen.test.gen.exceptions_generator.generate;

/**
* Autogenerated by XGen on 12/05/15.
*/
public class PillowNotFoundError {

    private static String MESSAGE_FORMAT = "There is no pillow! How can %s sleep here?";

    public static void throwException(String personName) {
        throw new DirtyException(String.format(MESSAGE_FORMAT, personName));
    }
}

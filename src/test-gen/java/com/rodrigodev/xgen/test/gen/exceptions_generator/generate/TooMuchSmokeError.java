package com.rodrigodev.xgen.test.gen.exceptions_generator.generate;

/**
* Autogenerated by XGen on 12/05/15.
*/
public class TooMuchSmokeError {

    private static String MESSAGE_FORMAT = "Wow, there is too much smoke coming out from the oven. Do you think the %s is okay?";

    public static void throwException(String model) {
        throw new TooMuchSmokeException(String.format(MESSAGE_FORMAT, model));
    }
}

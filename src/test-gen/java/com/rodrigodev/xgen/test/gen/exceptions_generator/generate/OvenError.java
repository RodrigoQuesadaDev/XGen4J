package com.rodrigodev.xgen.test.gen.exceptions_generator.generate;

/**
* Autogenerated by XGen on 12/05/15.
*/
public class OvenError {

    private static String MESSAGE_FORMAT = "The oven is not working. Model: %s";

    public static void throwException(String model) {
        throw new DirtyException(String.format(MESSAGE_FORMAT, model));
    }
}

package com.rodrigodev.xgen.test.gen.exceptions_generator.generate;

/**
* Autogenerated by XGen on 12/05/15.
*/
public class UndercookedError {

    private static String MESSAGE_FORMAT = "%s is undercooked my friend, I won't eat that.";

    public static void throwException(String model) {
        throw new DirtyException(String.format(MESSAGE_FORMAT, model));
    }
}
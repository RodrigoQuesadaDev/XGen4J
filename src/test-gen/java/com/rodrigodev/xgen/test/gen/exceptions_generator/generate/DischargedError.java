package com.rodrigodev.xgen.test.gen.exceptions_generator.generate;

/**
* Autogenerated by XGen on 12/05/15.
*/
public class DischargedError {

    private static String MESSAGE_FORMAT = "%s is discharged.";

    public static void throwException(String applianceName) {
        throw new DirtyException(String.format(MESSAGE_FORMAT, applianceName));
    }
}

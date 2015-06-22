package com.rodrigodev.xgen.test.integration;

/**
* Autogenerated by XGen on 12/05/15.
*/
public class DischargedError extends ApplianceError {

    private static String MESSAGE_FORMAT = "The %s is discharged.";

    public static void throwException(String applianceName) {
        throw new DischargedException(String.format(MESSAGE_FORMAT, applianceName));
    }
}

package com.rodrigodev.xgen.test.gen.exceptions_generator.generate;

/**
* Autogenerated by XGen on 12/05/15.
*/
public class ApplianceError {

    private static String MESSAGE_FORMAT = "Something went wrong with %s appliance.";

    public static void throwException(String applianceName) {
        throw new ApplianceException(String.format(MESSAGE_FORMAT, applianceName));
    }
}

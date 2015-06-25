package com.rodrigodev.xgen.test.integration.common.appliance.damaged;

import com.rodrigodev.xgen.test.integration.common.appliance.ApplianceError;

import java.lang.String;

/**
* Autogenerated by XGen on 12/05/15.
*/
public abstract class DamagedError extends ApplianceError {

    private static String MESSAGE_FORMAT = "The %s has been damaged.";

    public static void throwException(String applianceName) {
        throw new DamagedException(String.format(MESSAGE_FORMAT, applianceName));
    }
}

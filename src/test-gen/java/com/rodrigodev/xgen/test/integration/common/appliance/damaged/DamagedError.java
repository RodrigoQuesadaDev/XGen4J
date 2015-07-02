package com.rodrigodev.xgen.test.integration.common.appliance.damaged;

import com.rodrigodev.xgen.test.integration.common.appliance.ApplianceError;
import com.rodrigodev.xgen.test.integration.ErrorCode;

import java.lang.String;

/**
* Autogenerated by XGen on July 1, 2015.
*/
public abstract class DamagedError extends ApplianceError {

    public static final ErrorCode CODE = new ErrorCode("damaged", ApplianceError.CODE);

    private static String MESSAGE_FORMAT = "The %s has been damaged.";

    public static void throwException(String applianceName) {
        throw new DamagedException(String.format(MESSAGE_FORMAT, applianceName));
    }
}

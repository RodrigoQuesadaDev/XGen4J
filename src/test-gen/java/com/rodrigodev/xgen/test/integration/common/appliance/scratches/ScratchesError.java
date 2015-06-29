package com.rodrigodev.xgen.test.integration.common.appliance.scratches;

import com.rodrigodev.xgen.test.integration.common.appliance.ApplianceError;
import com.rodrigodev.xgen.test.integration.ErrorCode;

import java.lang.String;

/**
* Autogenerated by XGen on June 28, 2015.
*/
public abstract class ScratchesError extends ApplianceError {

    public static final ErrorCode CODE = new ErrorCode("house.common.appliance.scratches");

    private static String MESSAGE_FORMAT = "The %s got some scratches.";

    public static void throwException(String applianceName) {
        throw new ScratchesException(String.format(MESSAGE_FORMAT, applianceName));
    }
}

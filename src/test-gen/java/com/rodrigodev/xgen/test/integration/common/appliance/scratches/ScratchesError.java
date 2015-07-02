package com.rodrigodev.xgen.test.integration.common.appliance.scratches;

import com.rodrigodev.xgen.test.integration.common.appliance.ApplianceError;
import com.rodrigodev.xgen.test.integration.ErrorCode;

import java.lang.String;

/**
* Autogenerated by XGen on July 1, 2015.
*/
public abstract class ScratchesError extends ApplianceError {

    public static final ErrorCode CODE = new ErrorCode("scratches", ApplianceError.CODE);

    private static String MESSAGE_FORMAT = "The %s got some scratches.";

    public static void throwException(String applianceName) {
        throw new ScratchesException(String.format(MESSAGE_FORMAT, applianceName));
    }
}

package com.rodrigodev.xgen.test.integration.common.appliance.discharged;

import com.rodrigodev.xgen.test.integration.common.appliance.ApplianceError;
import com.rodrigodev.xgen.test.integration.ErrorCode;

import java.lang.String;

/**
* Autogenerated by XGen on July 3, 2015.
*/
public abstract class DischargedError extends ApplianceError {

    public static final ErrorCode CODE = new ErrorCode("discharged", ApplianceError.CODE);

    private static String MESSAGE_FORMAT = "The %s is discharged.";

    public static void throwException(String applianceName) {
        if(applianceName == null) throw new NullPointerException("applianceName");

        throw new DischargedException(String.format(MESSAGE_FORMAT, applianceName));
    }
}

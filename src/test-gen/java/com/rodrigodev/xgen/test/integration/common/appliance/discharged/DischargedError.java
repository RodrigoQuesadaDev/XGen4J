package com.rodrigodev.xgen.test.integration.common.appliance.discharged;

import com.rodrigodev.xgen.test.integration.common.appliance.ApplianceError;

import java.lang.String;

import com.rodrigodev.xgen.test.integration.ErrorCode;
import com.rodrigodev.xgen.test.integration.HouseException.ExceptionType;

/**
* Autogenerated by XGen on July 4, 2015.
*/
public abstract class DischargedError extends ApplianceError {

    public static final ErrorCode CODE = new ErrorCode("discharged", ApplianceError.CODE);

    private static String MESSAGE_FORMAT = "The %s is discharged.";

    private static String createMessage(String applianceName) {
        return String.format(MESSAGE_FORMAT, applianceName);
    }

    public static void throwException(String applianceName) {
        if(applianceName == null) throw new NullPointerException("applianceName");

        throw new DischargedException(createMessage(applianceName));
    }

    public static void throwException(ExceptionType exceptionType, String applianceName) {
        throwExceptionForCommonError(exceptionType, createMessage(applianceName));
    }

}

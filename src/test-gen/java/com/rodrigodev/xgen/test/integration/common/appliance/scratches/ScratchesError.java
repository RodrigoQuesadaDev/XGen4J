package com.rodrigodev.xgen.test.integration.common.appliance.scratches;

import com.rodrigodev.xgen.test.integration.common.appliance.ApplianceError;

import java.lang.String;

import com.rodrigodev.xgen.test.integration.ErrorCode;
import com.rodrigodev.xgen.test.integration.HouseException;
import com.rodrigodev.xgen.test.integration.HouseException.ExceptionType;

/**
 * Autogenerated by XGen on July 12, 2015.
 */
public abstract class ScratchesError extends ApplianceError {

    public static final ErrorCode CODE = new ErrorCode("scratches", ApplianceError.CODE);

    private static String MESSAGE_FORMAT = "The %s got some scratches.";

    private static String createMessage(String applianceName) {
        if(applianceName == null) throw new NullPointerException("applianceName");

        return String.format(MESSAGE_FORMAT, applianceName);
    }

    public static void throwException(String applianceName) {
        throw new ScratchesException(createMessage(applianceName));
    }

    public static void throwException(String applianceName, Throwable cause) {
        throw new ScratchesException(createMessage(applianceName), cause);
    }

    public static void throwException(ExceptionType exceptionType, String applianceName) {
        throwExceptionForCommonError(exceptionType, createMessage(applianceName));
    }

    public static void throwException(ExceptionType exceptionType, String applianceName, Throwable cause) {
        throwExceptionForCommonError(exceptionType, createMessage(applianceName), cause);
    }

}

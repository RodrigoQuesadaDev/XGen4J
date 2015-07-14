package com.rodrigodev.xgen.test.integration.common.appliance;

import com.rodrigodev.xgen.test.integration.common.CommonError;

import java.lang.String;

import com.rodrigodev.xgen.test.integration.ErrorCode;
import com.rodrigodev.xgen.test.integration.HouseException;
import com.rodrigodev.xgen.test.integration.HouseException.ExceptionType;

/**
 * Autogenerated by XGen on January 1, 0001.
 */
public abstract class ApplianceError extends CommonError {

    public static final ErrorCode CODE = new ErrorCode("appliance", CommonError.CODE);

    private static String MESSAGE_FORMAT = "Something went wrong with %s appliance.";

    private static String createMessage(String applianceName) {
        if(applianceName == null) throw new NullPointerException("applianceName");

        return String.format(MESSAGE_FORMAT, applianceName);
    }

    public static void throwException(String applianceName) {
        throw new ApplianceException(createMessage(applianceName));
    }

    public static void throwException(String applianceName, Throwable cause) {
        throw new ApplianceException(createMessage(applianceName), cause);
    }

    public static void throwException(ExceptionType exceptionType, String applianceName) {
        throwExceptionForCommonError(exceptionType, createMessage(applianceName));
    }

    public static void throwException(ExceptionType exceptionType, String applianceName, Throwable cause) {
        throwExceptionForCommonError(exceptionType, createMessage(applianceName), cause);
    }

}

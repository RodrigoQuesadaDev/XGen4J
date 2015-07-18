package com.rodrigodev.xgen4j.test.integration.common.appliance.damaged;

import com.rodrigodev.xgen4j.test.integration.common.appliance.ApplianceError;

import java.lang.String;

import com.rodrigodev.xgen4j.test.integration.ErrorCode;
import com.rodrigodev.xgen4j.test.integration.HouseException;
import com.rodrigodev.xgen4j.test.integration.HouseException.ExceptionType;

/**
 * Autogenerated by XGen4J on January 1, 0001.
 */
public abstract class DamagedError extends ApplianceError {

    public static final ErrorCode CODE = new ErrorCode("damaged", ApplianceError.CODE);

    private static String MESSAGE_FORMAT = "The %s has been damaged.";

    private static String createMessage(String applianceName) {
        if(applianceName == null) throw new NullPointerException("applianceName");

        return String.format(MESSAGE_FORMAT, applianceName);
    }

    public static void throwException(String applianceName) {
        throw new DamagedException(CODE, createMessage(applianceName));
    }

    public static void throwException(String applianceName, Throwable cause) {
        throw new DamagedException(CODE, createMessage(applianceName), cause);
    }

    public static void throwException(ExceptionType exceptionType, String applianceName) {
        throwExceptionForCommonError(CODE, exceptionType, createMessage(applianceName));
    }

    public static void throwException(ExceptionType exceptionType, String applianceName, Throwable cause) {
        throwExceptionForCommonError(CODE, exceptionType, createMessage(applianceName), cause);
    }

}

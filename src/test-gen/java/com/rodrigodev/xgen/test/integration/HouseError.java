package com.rodrigodev.xgen.test.integration;




import com.rodrigodev.xgen.test.integration.HouseException.ExceptionType;

/**
 * Autogenerated by XGen on July 13, 2015.
 */
public abstract class HouseError {

    public static final ErrorCode CODE = new ErrorCode("house");


    protected static void throwExceptionForCommonError(ExceptionType exceptionType, String message) {
        if(exceptionType == null) throw new NullPointerException("exceptionType");

        throw exceptionType.createException(message);
    }

    protected static void throwExceptionForCommonError(ExceptionType exceptionType, String message, Throwable cause) {
        if(exceptionType == null) throw new NullPointerException("exceptionType");

        throw exceptionType.createException(message, cause);
    }
}

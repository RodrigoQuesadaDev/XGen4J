package com.rodrigodev.xgen4j.test.naming.errorNameCanContainLettersNumbersHyphensOrUnderscores;




import com.rodrigodev.xgen4j.test.naming.errorNameCanContainLettersNumbersHyphensOrUnderscores.Root1Name1Exception.ExceptionType;

/**
 * Autogenerated by XGen on January 1, 0001.
 */
public abstract class Root1Name1Error {

    public static final ErrorCode CODE = new ErrorCode("root-1-name-1");


    protected static void throwExceptionForCommonError(ExceptionType exceptionType, String message) {
        if(exceptionType == null) throw new NullPointerException("exceptionType");

        throw exceptionType.createException(message);
    }

    protected static void throwExceptionForCommonError(ExceptionType exceptionType, String message, Throwable cause) {
        if(exceptionType == null) throw new NullPointerException("exceptionType");

        throw exceptionType.createException(message, cause);
    }
}
package com.rodrigodev.xgen.test.message.descriptionWithNoParamsIsAllowed;




import com.rodrigodev.xgen.test.message.descriptionWithNoParamsIsAllowed.RootException.ExceptionType;

/**
 * Autogenerated by XGen on January 1, 0001.
 */
public abstract class RootError {

    public static final ErrorCode CODE = new ErrorCode("root");


    protected static void throwExceptionForCommonError(ExceptionType exceptionType, String message) {
        if(exceptionType == null) throw new NullPointerException("exceptionType");

        throw exceptionType.createException(message);
    }

    protected static void throwExceptionForCommonError(ExceptionType exceptionType, String message, Throwable cause) {
        if(exceptionType == null) throw new NullPointerException("exceptionType");

        throw exceptionType.createException(message, cause);
    }
}

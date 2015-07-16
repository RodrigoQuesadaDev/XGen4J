package com.rodrigodev.xgen4j.test.generation_options.checkedExceptionsAreGeneratedWhenCorrespondingOptionIsSet;




import com.rodrigodev.xgen4j.test.generation_options.checkedExceptionsAreGeneratedWhenCorrespondingOptionIsSet.CRootException.ExceptionType;

/**
 * Autogenerated by XGen on January 1, 0001.
 */
public abstract class CRootError {

    public static final ErrorCode CODE = new ErrorCode("c-root");


    protected static void throwExceptionForCommonError(ExceptionType exceptionType, String message) throws CRootException {
        if(exceptionType == null) throw new NullPointerException("exceptionType");

        throw exceptionType.createException(message);
    }

    protected static void throwExceptionForCommonError(ExceptionType exceptionType, String message, Throwable cause) throws CRootException {
        if(exceptionType == null) throw new NullPointerException("exceptionType");

        throw exceptionType.createException(message, cause);
    }
}
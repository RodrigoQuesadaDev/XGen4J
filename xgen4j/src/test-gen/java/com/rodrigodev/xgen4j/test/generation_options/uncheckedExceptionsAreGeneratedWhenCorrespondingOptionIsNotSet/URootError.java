package com.rodrigodev.xgen4j.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsNotSet;




import com.rodrigodev.xgen4j.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsNotSet.URootException.ExceptionType;

/**
 * Autogenerated by XGen4J on January 1, 0001.
 */
public abstract class URootError {

    public static final ErrorCode CODE = new ErrorCode("u-root");


    protected static void throwExceptionForCommonError(ExceptionType exceptionType, String message) {
        if(exceptionType == null) throw new NullPointerException("exceptionType");

        throw exceptionType.createException(message);
    }

    protected static void throwExceptionForCommonError(ExceptionType exceptionType, String message, Throwable cause) {
        if(exceptionType == null) throw new NullPointerException("exceptionType");

        throw exceptionType.createException(message, cause);
    }
}

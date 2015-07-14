package com.rodrigodev.xgen.test.generation_options.customOptionalClassIsUsedWhenCorrespondingOptionIsSet;




import com.rodrigodev.xgen.test.generation_options.customOptionalClassIsUsedWhenCorrespondingOptionIsSet.CustomRootException.ExceptionType;

/**
 * Autogenerated by XGen on January 1, 0001.
 */
public abstract class CustomRootError {

    public static final ErrorCode CODE = new ErrorCode("custom-root");


    protected static void throwExceptionForCommonError(ExceptionType exceptionType, String message) {
        if(exceptionType == null) throw new NullPointerException("exceptionType");

        throw exceptionType.createException(message);
    }

    protected static void throwExceptionForCommonError(ExceptionType exceptionType, String message, Throwable cause) {
        if(exceptionType == null) throw new NullPointerException("exceptionType");

        throw exceptionType.createException(message, cause);
    }
}

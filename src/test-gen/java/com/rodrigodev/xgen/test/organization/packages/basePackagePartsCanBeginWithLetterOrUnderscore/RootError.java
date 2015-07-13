package com.rodrigodev.xgen.test.organization.packages.basePackagePartsCanBeginWithLetterOrUnderscore;




import com.rodrigodev.xgen.test.organization.packages.basePackagePartsCanBeginWithLetterOrUnderscore.RootException.ExceptionType;

/**
 * Autogenerated by XGen on July 13, 2015.
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

package com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified_specialCases;




import com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified_specialCases.RootName10___Exception.ExceptionType;

/**
 * Autogenerated by XGen on January 1, 0001.
 */
public abstract class RootName10___Error {

    public static final ErrorCode CODE = new ErrorCode("root-name-10");


    protected static void throwExceptionForCommonError(ExceptionType exceptionType, String message) {
        if(exceptionType == null) throw new NullPointerException("exceptionType");

        throw exceptionType.createException(message);
    }

    protected static void throwExceptionForCommonError(ExceptionType exceptionType, String message, Throwable cause) {
        if(exceptionType == null) throw new NullPointerException("exceptionType");

        throw exceptionType.createException(message, cause);
    }
}

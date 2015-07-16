package com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified_specialCases;




import com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified_specialCases.RootName7_Exception.ExceptionType;

/**
 * Autogenerated by XGen4J on January 1, 0001.
 */
public abstract class RootName7_Error {

    public static final ErrorCode CODE = new ErrorCode("root-name-7");


    protected static void throwExceptionForCommonError(ExceptionType exceptionType, String message) {
        if(exceptionType == null) throw new NullPointerException("exceptionType");

        throw exceptionType.createException(message);
    }

    protected static void throwExceptionForCommonError(ExceptionType exceptionType, String message, Throwable cause) {
        if(exceptionType == null) throw new NullPointerException("exceptionType");

        throw exceptionType.createException(message, cause);
    }
}

package com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedOnAMixedSituation;




import com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.RootNameException.ExceptionType;

/**
 * Autogenerated by XGen on July 13, 2015.
 */
public abstract class RootNameError {

    public static final ErrorCode CODE = new ErrorCode("root-name");


    protected static void throwExceptionForCommonError(ExceptionType exceptionType, String message) {
        if(exceptionType == null) throw new NullPointerException("exceptionType");

        throw exceptionType.createException(message);
    }

    protected static void throwExceptionForCommonError(ExceptionType exceptionType, String message, Throwable cause) {
        if(exceptionType == null) throw new NullPointerException("exceptionType");

        throw exceptionType.createException(message, cause);
    }
}

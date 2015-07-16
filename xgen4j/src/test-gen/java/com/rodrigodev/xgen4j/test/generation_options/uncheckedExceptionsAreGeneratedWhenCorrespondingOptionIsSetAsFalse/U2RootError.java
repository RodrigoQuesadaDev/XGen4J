package com.rodrigodev.xgen4j.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsSetAsFalse;




import com.rodrigodev.xgen4j.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsSetAsFalse.U2RootException.ExceptionType;

/**
 * Autogenerated by XGen4J on January 1, 0001.
 */
public abstract class U2RootError {

    public static final ErrorCode CODE = new ErrorCode("u-2-root");


    protected static void throwExceptionForCommonError(ExceptionType exceptionType, String message) {
        if(exceptionType == null) throw new NullPointerException("exceptionType");

        throw exceptionType.createException(message);
    }

    protected static void throwExceptionForCommonError(ExceptionType exceptionType, String message, Throwable cause) {
        if(exceptionType == null) throw new NullPointerException("exceptionType");

        throw exceptionType.createException(message, cause);
    }
}

package com.rodrigodev.xgen4j.test.naming.ifErrorNameHasHyphensTheyAreConvertedToUnderscores;




import com.rodrigodev.xgen4j.test.naming.ifErrorNameHasHyphensTheyAreConvertedToUnderscores.Root___Name5___Exception.ExceptionType;

/**
 * Autogenerated by XGen on January 1, 0001.
 */
public abstract class Root___Name5___Error {

    public static final ErrorCode CODE = new ErrorCode("root-name-5");


    protected static void throwExceptionForCommonError(ExceptionType exceptionType, String message) {
        if(exceptionType == null) throw new NullPointerException("exceptionType");

        throw exceptionType.createException(message);
    }

    protected static void throwExceptionForCommonError(ExceptionType exceptionType, String message, Throwable cause) {
        if(exceptionType == null) throw new NullPointerException("exceptionType");

        throw exceptionType.createException(message, cause);
    }
}

package com.rodrigodev.xgen.test.naming.ifErrorNameHasHyphensTheyAreConvertedToUnderscores;




import com.rodrigodev.xgen.test.naming.ifErrorNameHasHyphensTheyAreConvertedToUnderscores.Root__Name4__Exception.ExceptionType;

/**
 * Autogenerated by XGen on January 1, 0001.
 */
public abstract class Root__Name4__Error {

    public static final ErrorCode CODE = new ErrorCode("root-name-4");


    protected static void throwExceptionForCommonError(ExceptionType exceptionType, String message) {
        if(exceptionType == null) throw new NullPointerException("exceptionType");

        throw exceptionType.createException(message);
    }

    protected static void throwExceptionForCommonError(ExceptionType exceptionType, String message, Throwable cause) {
        if(exceptionType == null) throw new NullPointerException("exceptionType");

        throw exceptionType.createException(message, cause);
    }
}

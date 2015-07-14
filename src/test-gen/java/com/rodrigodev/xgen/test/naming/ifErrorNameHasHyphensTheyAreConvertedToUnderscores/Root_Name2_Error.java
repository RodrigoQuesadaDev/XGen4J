package com.rodrigodev.xgen.test.naming.ifErrorNameHasHyphensTheyAreConvertedToUnderscores;




import com.rodrigodev.xgen.test.naming.ifErrorNameHasHyphensTheyAreConvertedToUnderscores.Root_Name2_Exception.ExceptionType;

/**
 * Autogenerated by XGen on January 1, 0001.
 */
public abstract class Root_Name2_Error {

    public static final ErrorCode CODE = new ErrorCode("root-name-2");


    protected static void throwExceptionForCommonError(ExceptionType exceptionType, String message) {
        if(exceptionType == null) throw new NullPointerException("exceptionType");

        throw exceptionType.createException(message);
    }

    protected static void throwExceptionForCommonError(ExceptionType exceptionType, String message, Throwable cause) {
        if(exceptionType == null) throw new NullPointerException("exceptionType");

        throw exceptionType.createException(message, cause);
    }
}

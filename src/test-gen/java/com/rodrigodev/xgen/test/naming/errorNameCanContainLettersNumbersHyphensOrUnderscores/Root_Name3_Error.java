package com.rodrigodev.xgen.test.naming.errorNameCanContainLettersNumbersHyphensOrUnderscores;




import com.rodrigodev.xgen.test.naming.errorNameCanContainLettersNumbersHyphensOrUnderscores.Root_Name3_Exception.ExceptionType;

/**
* Autogenerated by XGen on July 8, 2015.
*/
public abstract class Root_Name3_Error {

    public static final ErrorCode CODE = new ErrorCode("root-name-3");


    protected static void throwExceptionForCommonError(ExceptionType exceptionType, String message) {
        if(exceptionType == null) throw new NullPointerException("exceptionType");

        throw exceptionType.createException(message);
    }

    protected static void throwExceptionForCommonError(ExceptionType exceptionType, String message, Throwable cause) {
        if(exceptionType == null) throw new NullPointerException("exceptionType");

        throw exceptionType.createException(message, cause);
    }
}

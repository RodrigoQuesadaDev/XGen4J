package com.rodrigodev.xgen.test.naming.errorNameCanContainLettersNumbersHyphensOrUnderscores;




import com.rodrigodev.xgen.test.naming.errorNameCanContainLettersNumbersHyphensOrUnderscores.Root_Name2_Exception.ExceptionType;

/**
* Autogenerated by XGen on July 8, 2015.
*/
public abstract class Root_Name2_Error {

    public static final ErrorCode CODE = new ErrorCode("root-name-2");


    protected static void throwExceptionForCommonError(ExceptionType exceptionType, String message) {
        if(exceptionType == null) throw new NullPointerException("exceptionType");

        throw exceptionType.createException(message);
    }
}

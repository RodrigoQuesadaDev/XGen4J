package com.rodrigodev.xgen.test.message.descriptionWithNoParamsIsAllowed;




import com.rodrigodev.xgen.test.message.descriptionWithNoParamsIsAllowed.RootException.ExceptionType;

/**
* Autogenerated by XGen on July 8, 2015.
*/
public abstract class RootError {

    public static final ErrorCode CODE = new ErrorCode("root");


    protected static void throwExceptionForCommonError(ExceptionType exceptionType, String message) {
        if(exceptionType == null) throw new NullPointerException("exceptionType");

        throw exceptionType.createException(message);
    }
}

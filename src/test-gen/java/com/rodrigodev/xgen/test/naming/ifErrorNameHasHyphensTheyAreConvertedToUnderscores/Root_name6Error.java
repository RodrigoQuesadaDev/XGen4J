package com.rodrigodev.xgen.test.naming.ifErrorNameHasHyphensTheyAreConvertedToUnderscores;




import com.rodrigodev.xgen.test.naming.ifErrorNameHasHyphensTheyAreConvertedToUnderscores.Root_name6Exception.ExceptionType;

/**
* Autogenerated by XGen on July 8, 2015.
*/
public abstract class Root_name6Error {

    public static final ErrorCode CODE = new ErrorCode("root-name-6");


    protected static void throwExceptionForCommonError(ExceptionType exceptionType, String message) {
        if(exceptionType == null) throw new NullPointerException("exceptionType");

        throw exceptionType.createException(message);
    }
}

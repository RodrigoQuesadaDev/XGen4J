package com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified_specialCases;




import com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified_specialCases.Root_Name1Exception.ExceptionType;

/**
* Autogenerated by XGen on July 6, 2015.
*/
public abstract class Root_Name1Error {

    public static final ErrorCode CODE = new ErrorCode("root-name-1");


    protected static void throwExceptionForCommonError(ExceptionType exceptionType, String message) {
        if(exceptionType == null) throw new NullPointerException("exceptionType");

        throw exceptionType.createException(message);
    }
}

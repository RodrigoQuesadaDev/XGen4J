package com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified_specialCases;




import com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified_specialCases.Root_Name2Exception.ExceptionType;

/**
* Autogenerated by XGen on July 4, 2015.
*/
public abstract class Root_Name2Error {

    public static final ErrorCode CODE = new ErrorCode("root-name-2");


    protected static void throwExceptionForCommonError(ExceptionType exceptionType, String message) {
        throw exceptionType.createException(message);
    }
}

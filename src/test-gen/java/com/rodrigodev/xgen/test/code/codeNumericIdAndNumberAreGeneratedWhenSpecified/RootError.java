package com.rodrigodev.xgen.test.code.codeNumericIdAndNumberAreGeneratedWhenSpecified;




import com.rodrigodev.xgen.test.code.codeNumericIdAndNumberAreGeneratedWhenSpecified.RootException.ExceptionType;

/**
* Autogenerated by XGen on July 4, 2015.
*/
public abstract class RootError {

    public static final ErrorCode CODE = new ErrorCode("root", 123);


    protected static void throwExceptionForCommonError(ExceptionType exceptionType, String message) {
        throw exceptionType.createException(message);
    }
}

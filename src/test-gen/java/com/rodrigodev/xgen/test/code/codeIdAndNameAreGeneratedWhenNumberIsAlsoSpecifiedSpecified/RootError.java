package com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedWhenNumberIsAlsoSpecifiedSpecified;




import com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedWhenNumberIsAlsoSpecifiedSpecified.RootException.ExceptionType;

/**
* Autogenerated by XGen on July 4, 2015.
*/
public abstract class RootError {

    public static final ErrorCode CODE = new ErrorCode("code-name-root", 1);


    protected static void throwExceptionForCommonError(ExceptionType exceptionType, String message) {
        throw exceptionType.createException(message);
    }
}

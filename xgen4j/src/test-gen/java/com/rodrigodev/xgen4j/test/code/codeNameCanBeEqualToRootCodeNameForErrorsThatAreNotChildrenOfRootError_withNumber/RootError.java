package com.rodrigodev.xgen4j.test.code.codeNameCanBeEqualToRootCodeNameForErrorsThatAreNotChildrenOfRootError_withNumber;




import com.rodrigodev.xgen4j.test.code.codeNameCanBeEqualToRootCodeNameForErrorsThatAreNotChildrenOfRootError_withNumber.RootException.ExceptionType;

/**
 * Autogenerated by XGen4J on January 1, 0001.
 */
public abstract class RootError {

    public static final ErrorCode CODE = new ErrorCode("code-name-root", 1);


    protected static void throwExceptionForCommonError(ErrorCode code, ExceptionType exceptionType, String message) {
        if(exceptionType == null) throw new NullPointerException("exceptionType");

        throw exceptionType.createException(code, message);
    }

    protected static void throwExceptionForCommonError(ErrorCode code, ExceptionType exceptionType, String message, Throwable cause) {
        if(exceptionType == null) throw new NullPointerException("exceptionType");

        throw exceptionType.createException(code, message, cause);
    }
}

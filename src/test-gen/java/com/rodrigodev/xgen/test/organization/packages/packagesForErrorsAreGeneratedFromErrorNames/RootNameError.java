package com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames;




import com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames.RootNameException.ExceptionType;

/**
* Autogenerated by XGen on July 4, 2015.
*/
public abstract class RootNameError {

    public static final ErrorCode CODE = new ErrorCode("root-name");


    protected static void throwExceptionForCommonError(ExceptionType exceptionType, String message) {
        throw exceptionType.createException(message);
    }
}

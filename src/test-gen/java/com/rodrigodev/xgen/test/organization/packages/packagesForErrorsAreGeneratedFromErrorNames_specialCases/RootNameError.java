package com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames_specialCases;




import com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames_specialCases.RootNameException.ExceptionType;

/**
* Autogenerated by XGen on July 6, 2015.
*/
public abstract class RootNameError {

    public static final ErrorCode CODE = new ErrorCode("root-name");


    protected static void throwExceptionForCommonError(ExceptionType exceptionType, String message) {
        if(exceptionType == null) throw new NullPointerException("exceptionType");

        throw exceptionType.createException(message);
    }
}

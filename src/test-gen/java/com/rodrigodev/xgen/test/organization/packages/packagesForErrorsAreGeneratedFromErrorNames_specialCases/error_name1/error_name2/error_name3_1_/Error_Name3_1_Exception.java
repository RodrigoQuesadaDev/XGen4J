package com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames_specialCases.error_name1.error_name2.error_name3_1_;

import com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames_specialCases.error_name1.error_name2.ErrorName2Exception;
import com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames_specialCases.RootNameException;

/**
* Autogenerated by XGen on July 8, 2015.
*/
public class Error_Name3_1_Exception extends ErrorName2Exception {

    public static final ExceptionType TYPE = new ExceptionType();

    private static class ExceptionType extends RootNameException.ExceptionType {

        @Override
        protected RootNameException createException(String message) {
            return new Error_Name3_1_Exception(message);
        }

        @Override
        protected RootNameException createException(String message, Throwable cause) {
            return new Error_Name3_1_Exception(message, cause);
        }
    }

    protected Error_Name3_1_Exception(String message) {
        super(message);
    }

    protected Error_Name3_1_Exception(String message, Throwable cause) {
        super(message, cause);
    }
}

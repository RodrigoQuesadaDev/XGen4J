package com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames_specialCases.error_name1.error_name2.error_name3_2_;

import com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames_specialCases.error_name1.error_name2.ErrorName2Exception;
import com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames_specialCases.RootNameException;

/**
 * Autogenerated by XGen on July 12, 2015.
 */
public class Error_Name3_2_Exception extends ErrorName2Exception {

    public static final ExceptionType TYPE = new ExceptionType();

    private static class ExceptionType extends RootNameException.ExceptionType {

        @Override
        protected RootNameException createException(String message) {
            return new Error_Name3_2_Exception(message);
        }

        @Override
        protected RootNameException createException(String message, Throwable cause) {
            return new Error_Name3_2_Exception(message, cause);
        }
    }

    protected Error_Name3_2_Exception(String message) {
        super(message);
    }

    protected Error_Name3_2_Exception(String message, Throwable cause) {
        super(message, cause);
    }
}

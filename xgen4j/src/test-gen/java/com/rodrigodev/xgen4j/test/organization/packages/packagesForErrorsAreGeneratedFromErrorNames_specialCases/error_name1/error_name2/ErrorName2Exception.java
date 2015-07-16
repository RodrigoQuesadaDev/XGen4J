package com.rodrigodev.xgen4j.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames_specialCases.error_name1.error_name2;

import com.rodrigodev.xgen4j.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames_specialCases.error_name1.ErrorName1Exception;
import com.rodrigodev.xgen4j.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames_specialCases.RootNameException;

/**
 * Autogenerated by XGen on January 1, 0001.
 */
public class ErrorName2Exception extends ErrorName1Exception {

    public static final ExceptionType TYPE = new ExceptionType();

    private static class ExceptionType extends RootNameException.ExceptionType {

        @Override
        protected RootNameException createException(String message) {
            return new ErrorName2Exception(message);
        }

        @Override
        protected RootNameException createException(String message, Throwable cause) {
            return new ErrorName2Exception(message, cause);
        }
    }

    protected ErrorName2Exception(String message) {
        super(message);
    }

    protected ErrorName2Exception(String message, Throwable cause) {
        super(message, cause);
    }
}
package com.rodrigodev.xgen4j.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames_specialCases.error_name1.error_name2.error_name_9_name3_1_;

import com.rodrigodev.xgen4j.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames_specialCases.error_name1.error_name2.ErrorName2Exception;
import com.rodrigodev.xgen4j.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames_specialCases.RootNameException;
import com.rodrigodev.xgen4j.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames_specialCases.ErrorCode;

/**
 * Autogenerated by XGen4J on January 1, 0001.
 */
public class Error_Name_9_Name3_1_Exception extends ErrorName2Exception {

    public static final ExceptionType TYPE = new ExceptionType();

    protected Error_Name_9_Name3_1_Exception(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    protected Error_Name_9_Name3_1_Exception(ErrorCode errorCode, String message, Throwable cause) {
        super(errorCode, message, cause);
    }

    private static class ExceptionType extends RootNameException.ExceptionType {

        @Override
        protected RootNameException createException(ErrorCode errorCode, String message) {
            return new Error_Name_9_Name3_1_Exception(errorCode, message);
        }

        @Override
        protected RootNameException createException(ErrorCode errorCode, String message, Throwable cause) {
            return new Error_Name_9_Name3_1_Exception(errorCode, message, cause);
        }
    }
}

package com.rodrigodev.xgen4j.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames.error9_name1;

import com.rodrigodev.xgen4j.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames.Root9NameException;
import com.rodrigodev.xgen4j.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames.Root9NameException;
import com.rodrigodev.xgen4j.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames.ErrorCode;

/**
 * Autogenerated by XGen4J on January 1, 0001.
 */
public class Error9Name1Exception extends Root9NameException {

    public static final ExceptionType TYPE = new ExceptionType();

    protected Error9Name1Exception(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    protected Error9Name1Exception(ErrorCode errorCode, String message, Throwable cause) {
        super(errorCode, message, cause);
    }

    private static class ExceptionType extends Root9NameException.ExceptionType {

        @Override
        protected Root9NameException createException(ErrorCode errorCode, String message) {
            return new Error9Name1Exception(errorCode, message);
        }

        @Override
        protected Root9NameException createException(ErrorCode errorCode, String message, Throwable cause) {
            return new Error9Name1Exception(errorCode, message, cause);
        }
    }
}

package com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified.error_name1.error_name2.error_name3_2;

import com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified.error_name1.error_name2.ErrorName2Exception;
import com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified.RootNameException;

/**
 * Autogenerated by XGen on July 11, 2015.
 */
public class ErrorName3_2Exception extends ErrorName2Exception {

    public static final ExceptionType TYPE = new ExceptionType();

    private static class ExceptionType extends RootNameException.ExceptionType {

        @Override
        protected RootNameException createException(String message) {
            return new ErrorName3_2Exception(message);
        }

        @Override
        protected RootNameException createException(String message, Throwable cause) {
            return new ErrorName3_2Exception(message, cause);
        }
    }

    protected ErrorName3_2Exception(String message) {
        super(message);
    }

    protected ErrorName3_2Exception(String message, Throwable cause) {
        super(message, cause);
    }
}

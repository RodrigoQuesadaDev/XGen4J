package com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified.error_name1.error_name2.error_name3_3;

import com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified.error_name1.error_name2.ErrorName2Exception;
import com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified.RootNameException;

/**
 * Autogenerated by XGen4J on January 1, 0001.
 */
public class ErrorName3_3Exception extends ErrorName2Exception {

    public static final ExceptionType TYPE = new ExceptionType();

    private static class ExceptionType extends RootNameException.ExceptionType {

        @Override
        protected RootNameException createException(String message) {
            return new ErrorName3_3Exception(message);
        }

        @Override
        protected RootNameException createException(String message, Throwable cause) {
            return new ErrorName3_3Exception(message, cause);
        }
    }

    protected ErrorName3_3Exception(String message) {
        super(message);
    }

    protected ErrorName3_3Exception(String message, Throwable cause) {
        super(message, cause);
    }
}

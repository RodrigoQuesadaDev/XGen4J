package com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified.error_name1;

import com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified.RootNameException;
import com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified.RootNameException;

/**
 * Autogenerated by XGen4J on January 1, 0001.
 */
public class ErrorName1Exception extends RootNameException {

    public static final ExceptionType TYPE = new ExceptionType();

    private static class ExceptionType extends RootNameException.ExceptionType {

        @Override
        protected RootNameException createException(String message) {
            return new ErrorName1Exception(message);
        }

        @Override
        protected RootNameException createException(String message, Throwable cause) {
            return new ErrorName1Exception(message, cause);
        }
    }

    protected ErrorName1Exception(String message) {
        super(message);
    }

    protected ErrorName1Exception(String message, Throwable cause) {
        super(message, cause);
    }
}

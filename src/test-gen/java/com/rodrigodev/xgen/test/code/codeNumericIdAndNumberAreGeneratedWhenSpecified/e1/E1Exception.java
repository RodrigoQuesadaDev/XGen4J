package com.rodrigodev.xgen.test.code.codeNumericIdAndNumberAreGeneratedWhenSpecified.e1;

import com.rodrigodev.xgen.test.code.codeNumericIdAndNumberAreGeneratedWhenSpecified.RootException;
import com.rodrigodev.xgen.test.code.codeNumericIdAndNumberAreGeneratedWhenSpecified.RootException;

/**
 * Autogenerated by XGen on July 12, 2015.
 */
public class E1Exception extends RootException {

    public static final ExceptionType TYPE = new ExceptionType();

    private static class ExceptionType extends RootException.ExceptionType {

        @Override
        protected RootException createException(String message) {
            return new E1Exception(message);
        }

        @Override
        protected RootException createException(String message, Throwable cause) {
            return new E1Exception(message, cause);
        }
    }

    protected E1Exception(String message) {
        super(message);
    }

    protected E1Exception(String message, Throwable cause) {
        super(message, cause);
    }
}

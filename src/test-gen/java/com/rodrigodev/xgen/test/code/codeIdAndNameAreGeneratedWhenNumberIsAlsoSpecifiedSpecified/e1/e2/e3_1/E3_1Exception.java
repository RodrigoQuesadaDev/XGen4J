package com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedWhenNumberIsAlsoSpecifiedSpecified.e1.e2.e3_1;

import com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedWhenNumberIsAlsoSpecifiedSpecified.e1.e2.E2Exception;
import com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedWhenNumberIsAlsoSpecifiedSpecified.RootException;

/**
 * Autogenerated by XGen on July 13, 2015.
 */
public class E3_1Exception extends E2Exception {

    public static final ExceptionType TYPE = new ExceptionType();

    private static class ExceptionType extends RootException.ExceptionType {

        @Override
        protected RootException createException(String message) {
            return new E3_1Exception(message);
        }

        @Override
        protected RootException createException(String message, Throwable cause) {
            return new E3_1Exception(message, cause);
        }
    }

    protected E3_1Exception(String message) {
        super(message);
    }

    protected E3_1Exception(String message, Throwable cause) {
        super(message, cause);
    }
}

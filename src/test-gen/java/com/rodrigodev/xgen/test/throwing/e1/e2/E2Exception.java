package com.rodrigodev.xgen.test.throwing.e1.e2;

import com.rodrigodev.xgen.test.throwing.e1.E1Exception;
import com.rodrigodev.xgen.test.throwing.RootException;

/**
 * Autogenerated by XGen on July 11, 2015.
 */
public class E2Exception extends E1Exception {

    public static final ExceptionType TYPE = new ExceptionType();

    private static class ExceptionType extends RootException.ExceptionType {

        @Override
        protected RootException createException(String message) {
            return new E2Exception(message);
        }

        @Override
        protected RootException createException(String message, Throwable cause) {
            return new E2Exception(message, cause);
        }
    }

    protected E2Exception(String message) {
        super(message);
    }

    protected E2Exception(String message, Throwable cause) {
        super(message, cause);
    }
}

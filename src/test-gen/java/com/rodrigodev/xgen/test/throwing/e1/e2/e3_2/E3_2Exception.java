package com.rodrigodev.xgen.test.throwing.e1.e2.e3_2;

import com.rodrigodev.xgen.test.throwing.e1.e2.E2Exception;
import com.rodrigodev.xgen.test.throwing.RootException;

/**
 * Autogenerated by XGen on July 11, 2015.
 */
public class E3_2Exception extends E2Exception {

    public static final ExceptionType TYPE = new ExceptionType();

    private static class ExceptionType extends RootException.ExceptionType {

        @Override
        protected RootException createException(String message) {
            return new E3_2Exception(message);
        }

        @Override
        protected RootException createException(String message, Throwable cause) {
            return new E3_2Exception(message, cause);
        }
    }

    protected E3_2Exception(String message) {
        super(message);
    }

    protected E3_2Exception(String message, Throwable cause) {
        super(message, cause);
    }
}

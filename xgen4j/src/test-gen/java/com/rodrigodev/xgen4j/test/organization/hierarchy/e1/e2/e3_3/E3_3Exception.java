package com.rodrigodev.xgen4j.test.organization.hierarchy.e1.e2.e3_3;

import com.rodrigodev.xgen4j.test.organization.hierarchy.e1.e2.E2Exception;
import com.rodrigodev.xgen4j.test.organization.hierarchy.RootException;

/**
 * Autogenerated by XGen on January 1, 0001.
 */
public class E3_3Exception extends E2Exception {

    public static final ExceptionType TYPE = new ExceptionType();

    private static class ExceptionType extends RootException.ExceptionType {

        @Override
        protected RootException createException(String message) {
            return new E3_3Exception(message);
        }

        @Override
        protected RootException createException(String message, Throwable cause) {
            return new E3_3Exception(message, cause);
        }
    }

    protected E3_3Exception(String message) {
        super(message);
    }

    protected E3_3Exception(String message, Throwable cause) {
        super(message, cause);
    }
}

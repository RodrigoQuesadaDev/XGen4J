package com.rodrigodev.xgen.test.info_generation.ea1.ea2.ea3_2;

import com.rodrigodev.xgen.test.info_generation.ea1.ea2.EA2Exception;
import com.rodrigodev.xgen.test.info_generation.RootException;

/**
 * Autogenerated by XGen on July 11, 2015.
 */
public class EA3_2Exception extends EA2Exception {

    public static final ExceptionType TYPE = new ExceptionType();

    private static class ExceptionType extends RootException.ExceptionType {

        @Override
        protected RootException createException(String message) {
            return new EA3_2Exception(message);
        }

        @Override
        protected RootException createException(String message, Throwable cause) {
            return new EA3_2Exception(message, cause);
        }
    }

    protected EA3_2Exception(String message) {
        super(message);
    }

    protected EA3_2Exception(String message, Throwable cause) {
        super(message, cause);
    }
}

package com.rodrigodev.xgen.test.generation_options.java8OptionalClassIsUsedWhenNoOptionIsSet.default_e1.default_e2.default_e3_3;

import com.rodrigodev.xgen.test.generation_options.java8OptionalClassIsUsedWhenNoOptionIsSet.default_e1.default_e2.DefaultE2Exception;
import com.rodrigodev.xgen.test.generation_options.java8OptionalClassIsUsedWhenNoOptionIsSet.DefaultRootException;

/**
 * Autogenerated by XGen on July 13, 2015.
 */
public class DefaultE3_3Exception extends DefaultE2Exception {

    public static final ExceptionType TYPE = new ExceptionType();

    private static class ExceptionType extends DefaultRootException.ExceptionType {

        @Override
        protected DefaultRootException createException(String message) {
            return new DefaultE3_3Exception(message);
        }

        @Override
        protected DefaultRootException createException(String message, Throwable cause) {
            return new DefaultE3_3Exception(message, cause);
        }
    }

    protected DefaultE3_3Exception(String message) {
        super(message);
    }

    protected DefaultE3_3Exception(String message, Throwable cause) {
        super(message, cause);
    }
}

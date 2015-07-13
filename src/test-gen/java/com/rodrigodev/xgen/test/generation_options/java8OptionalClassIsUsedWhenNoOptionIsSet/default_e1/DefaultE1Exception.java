package com.rodrigodev.xgen.test.generation_options.java8OptionalClassIsUsedWhenNoOptionIsSet.default_e1;

import com.rodrigodev.xgen.test.generation_options.java8OptionalClassIsUsedWhenNoOptionIsSet.DefaultRootException;
import com.rodrigodev.xgen.test.generation_options.java8OptionalClassIsUsedWhenNoOptionIsSet.DefaultRootException;

/**
 * Autogenerated by XGen on July 13, 2015.
 */
public class DefaultE1Exception extends DefaultRootException {

    public static final ExceptionType TYPE = new ExceptionType();

    private static class ExceptionType extends DefaultRootException.ExceptionType {

        @Override
        protected DefaultRootException createException(String message) {
            return new DefaultE1Exception(message);
        }

        @Override
        protected DefaultRootException createException(String message, Throwable cause) {
            return new DefaultE1Exception(message, cause);
        }
    }

    protected DefaultE1Exception(String message) {
        super(message);
    }

    protected DefaultE1Exception(String message, Throwable cause) {
        super(message, cause);
    }
}

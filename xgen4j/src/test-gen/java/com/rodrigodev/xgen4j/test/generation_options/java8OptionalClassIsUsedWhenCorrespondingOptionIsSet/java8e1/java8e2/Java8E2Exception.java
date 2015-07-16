package com.rodrigodev.xgen4j.test.generation_options.java8OptionalClassIsUsedWhenCorrespondingOptionIsSet.java8e1.java8e2;

import com.rodrigodev.xgen4j.test.generation_options.java8OptionalClassIsUsedWhenCorrespondingOptionIsSet.java8e1.Java8E1Exception;
import com.rodrigodev.xgen4j.test.generation_options.java8OptionalClassIsUsedWhenCorrespondingOptionIsSet.Java8RootException;

/**
 * Autogenerated by XGen on January 1, 0001.
 */
public class Java8E2Exception extends Java8E1Exception {

    public static final ExceptionType TYPE = new ExceptionType();

    private static class ExceptionType extends Java8RootException.ExceptionType {

        @Override
        protected Java8RootException createException(String message) {
            return new Java8E2Exception(message);
        }

        @Override
        protected Java8RootException createException(String message, Throwable cause) {
            return new Java8E2Exception(message, cause);
        }
    }

    protected Java8E2Exception(String message) {
        super(message);
    }

    protected Java8E2Exception(String message, Throwable cause) {
        super(message, cause);
    }
}
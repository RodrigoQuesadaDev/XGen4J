package com.rodrigodev.xgen4j.test.generation_options.java8OptionalClassIsUsedWhenCorrespondingOptionIsSet.java8e1.java8e2.java8e3_1;

import com.rodrigodev.xgen4j.test.generation_options.java8OptionalClassIsUsedWhenCorrespondingOptionIsSet.java8e1.java8e2.Java8E2Exception;
import com.rodrigodev.xgen4j.test.generation_options.java8OptionalClassIsUsedWhenCorrespondingOptionIsSet.Java8RootException;

/**
 * Autogenerated by XGen on January 1, 0001.
 */
public class Java8E3_1Exception extends Java8E2Exception {

    public static final ExceptionType TYPE = new ExceptionType();

    private static class ExceptionType extends Java8RootException.ExceptionType {

        @Override
        protected Java8RootException createException(String message) {
            return new Java8E3_1Exception(message);
        }

        @Override
        protected Java8RootException createException(String message, Throwable cause) {
            return new Java8E3_1Exception(message, cause);
        }
    }

    protected Java8E3_1Exception(String message) {
        super(message);
    }

    protected Java8E3_1Exception(String message, Throwable cause) {
        super(message, cause);
    }
}
package com.rodrigodev.xgen.test.generation_options.java8OptionalClassIsUsedWhenCorrespondingOptionIsSet.java8e1.java8e2.java8e3_2;

import com.rodrigodev.xgen.test.generation_options.java8OptionalClassIsUsedWhenCorrespondingOptionIsSet.java8e1.java8e2.Java8E2Exception;
import com.rodrigodev.xgen.test.generation_options.java8OptionalClassIsUsedWhenCorrespondingOptionIsSet.Java8RootException;

/**
 * Autogenerated by XGen on July 13, 2015.
 */
public class Java8E3_2Exception extends Java8E2Exception {

    public static final ExceptionType TYPE = new ExceptionType();

    private static class ExceptionType extends Java8RootException.ExceptionType {

        @Override
        protected Java8RootException createException(String message) {
            return new Java8E3_2Exception(message);
        }

        @Override
        protected Java8RootException createException(String message, Throwable cause) {
            return new Java8E3_2Exception(message, cause);
        }
    }

    protected Java8E3_2Exception(String message) {
        super(message);
    }

    protected Java8E3_2Exception(String message, Throwable cause) {
        super(message, cause);
    }
}

package com.rodrigodev.xgen4j.test.generation_options.java8OptionalClassIsUsedWhenCorrespondingOptionIsSet.e1.e2.e3_1;

import com.rodrigodev.xgen4j.test.generation_options.java8OptionalClassIsUsedWhenCorrespondingOptionIsSet.e1.e2.E2Exception;
import com.rodrigodev.xgen4j.test.generation_options.java8OptionalClassIsUsedWhenCorrespondingOptionIsSet.RootException;

/**
 * Autogenerated by XGen4J on January 1, 0001.
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

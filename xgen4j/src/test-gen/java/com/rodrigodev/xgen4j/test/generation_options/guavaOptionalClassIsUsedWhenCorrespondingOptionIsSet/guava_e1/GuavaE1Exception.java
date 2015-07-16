package com.rodrigodev.xgen4j.test.generation_options.guavaOptionalClassIsUsedWhenCorrespondingOptionIsSet.guava_e1;

import com.rodrigodev.xgen4j.test.generation_options.guavaOptionalClassIsUsedWhenCorrespondingOptionIsSet.GuavaRootException;
import com.rodrigodev.xgen4j.test.generation_options.guavaOptionalClassIsUsedWhenCorrespondingOptionIsSet.GuavaRootException;

/**
 * Autogenerated by XGen4J on January 1, 0001.
 */
public class GuavaE1Exception extends GuavaRootException {

    public static final ExceptionType TYPE = new ExceptionType();

    private static class ExceptionType extends GuavaRootException.ExceptionType {

        @Override
        protected GuavaRootException createException(String message) {
            return new GuavaE1Exception(message);
        }

        @Override
        protected GuavaRootException createException(String message, Throwable cause) {
            return new GuavaE1Exception(message, cause);
        }
    }

    protected GuavaE1Exception(String message) {
        super(message);
    }

    protected GuavaE1Exception(String message, Throwable cause) {
        super(message, cause);
    }
}

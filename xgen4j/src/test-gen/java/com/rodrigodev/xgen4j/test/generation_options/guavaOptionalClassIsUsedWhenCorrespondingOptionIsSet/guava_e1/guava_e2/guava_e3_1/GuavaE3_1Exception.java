package com.rodrigodev.xgen4j.test.generation_options.guavaOptionalClassIsUsedWhenCorrespondingOptionIsSet.guava_e1.guava_e2.guava_e3_1;

import com.rodrigodev.xgen4j.test.generation_options.guavaOptionalClassIsUsedWhenCorrespondingOptionIsSet.guava_e1.guava_e2.GuavaE2Exception;
import com.rodrigodev.xgen4j.test.generation_options.guavaOptionalClassIsUsedWhenCorrespondingOptionIsSet.GuavaRootException;

/**
 * Autogenerated by XGen4J on January 1, 0001.
 */
public class GuavaE3_1Exception extends GuavaE2Exception {

    public static final ExceptionType TYPE = new ExceptionType();

    private static class ExceptionType extends GuavaRootException.ExceptionType {

        @Override
        protected GuavaRootException createException(String message) {
            return new GuavaE3_1Exception(message);
        }

        @Override
        protected GuavaRootException createException(String message, Throwable cause) {
            return new GuavaE3_1Exception(message, cause);
        }
    }

    protected GuavaE3_1Exception(String message) {
        super(message);
    }

    protected GuavaE3_1Exception(String message, Throwable cause) {
        super(message, cause);
    }
}

package com.rodrigodev.xgen.test.generation_options.guavaOptionalClassIsUsedWhenCorrespondingOptionIsSet.guava_e1.guava_e2.guava_e3_3;

import com.rodrigodev.xgen.test.generation_options.guavaOptionalClassIsUsedWhenCorrespondingOptionIsSet.guava_e1.guava_e2.GuavaE2Exception;
import com.rodrigodev.xgen.test.generation_options.guavaOptionalClassIsUsedWhenCorrespondingOptionIsSet.GuavaRootException;

/**
 * Autogenerated by XGen on January 1, 0001.
 */
public class GuavaE3_3Exception extends GuavaE2Exception {

    public static final ExceptionType TYPE = new ExceptionType();

    private static class ExceptionType extends GuavaRootException.ExceptionType {

        @Override
        protected GuavaRootException createException(String message) {
            return new GuavaE3_3Exception(message);
        }

        @Override
        protected GuavaRootException createException(String message, Throwable cause) {
            return new GuavaE3_3Exception(message, cause);
        }
    }

    protected GuavaE3_3Exception(String message) {
        super(message);
    }

    protected GuavaE3_3Exception(String message, Throwable cause) {
        super(message, cause);
    }
}

package com.rodrigodev.xgen.test.message.descriptionWithCustomObjectThatGeneratesTheMessageCanBeUsed_inheritedImplementation.e1.e2;

import com.rodrigodev.xgen.test.message.descriptionWithCustomObjectThatGeneratesTheMessageCanBeUsed_inheritedImplementation.e1.E1Exception;
import com.rodrigodev.xgen.test.message.descriptionWithCustomObjectThatGeneratesTheMessageCanBeUsed_inheritedImplementation.RootException;

/**
 * Autogenerated by XGen on January 1, 0001.
 */
public class E2Exception extends E1Exception {

    public static final ExceptionType TYPE = new ExceptionType();

    private static class ExceptionType extends RootException.ExceptionType {

        @Override
        protected RootException createException(String message) {
            return new E2Exception(message);
        }

        @Override
        protected RootException createException(String message, Throwable cause) {
            return new E2Exception(message, cause);
        }
    }

    protected E2Exception(String message) {
        super(message);
    }

    protected E2Exception(String message, Throwable cause) {
        super(message, cause);
    }
}

package com.rodrigodev.xgen4j.test.message.descriptionWithCustomObjectThatGeneratesTheMessageCanBeUsed_inheritedImplementation.e1;

import com.rodrigodev.xgen4j.test.message.descriptionWithCustomObjectThatGeneratesTheMessageCanBeUsed_inheritedImplementation.RootException;
import com.rodrigodev.xgen4j.test.message.descriptionWithCustomObjectThatGeneratesTheMessageCanBeUsed_inheritedImplementation.RootException;

/**
 * Autogenerated by XGen4J on January 1, 0001.
 */
public class E1Exception extends RootException {

    public static final ExceptionType TYPE = new ExceptionType();

    private static class ExceptionType extends RootException.ExceptionType {

        @Override
        protected RootException createException(String message) {
            return new E1Exception(message);
        }

        @Override
        protected RootException createException(String message, Throwable cause) {
            return new E1Exception(message, cause);
        }
    }

    protected E1Exception(String message) {
        super(message);
    }

    protected E1Exception(String message, Throwable cause) {
        super(message, cause);
    }
}

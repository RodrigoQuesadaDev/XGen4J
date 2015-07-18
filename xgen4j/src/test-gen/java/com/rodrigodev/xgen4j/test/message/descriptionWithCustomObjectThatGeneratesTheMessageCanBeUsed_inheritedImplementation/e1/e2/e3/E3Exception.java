package com.rodrigodev.xgen4j.test.message.descriptionWithCustomObjectThatGeneratesTheMessageCanBeUsed_inheritedImplementation.e1.e2.e3;

import com.rodrigodev.xgen4j.test.message.descriptionWithCustomObjectThatGeneratesTheMessageCanBeUsed_inheritedImplementation.e1.e2.E2Exception;
import com.rodrigodev.xgen4j.test.message.descriptionWithCustomObjectThatGeneratesTheMessageCanBeUsed_inheritedImplementation.RootException;
import com.rodrigodev.xgen4j.test.message.descriptionWithCustomObjectThatGeneratesTheMessageCanBeUsed_inheritedImplementation.ErrorCode;

/**
 * Autogenerated by XGen4J on January 1, 0001.
 */
public class E3Exception extends E2Exception {

    public static final ExceptionType TYPE = new ExceptionType();

    protected E3Exception(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    protected E3Exception(ErrorCode errorCode, String message, Throwable cause) {
        super(errorCode, message, cause);
    }

    private static class ExceptionType extends RootException.ExceptionType {

        @Override
        protected RootException createException(ErrorCode errorCode, String message) {
            return new E3Exception(errorCode, message);
        }

        @Override
        protected RootException createException(ErrorCode errorCode, String message, Throwable cause) {
            return new E3Exception(errorCode, message, cause);
        }
    }
}

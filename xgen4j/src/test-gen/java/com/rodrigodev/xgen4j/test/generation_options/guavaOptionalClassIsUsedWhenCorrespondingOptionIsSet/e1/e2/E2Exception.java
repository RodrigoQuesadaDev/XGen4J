package com.rodrigodev.xgen4j.test.generation_options.guavaOptionalClassIsUsedWhenCorrespondingOptionIsSet.e1.e2;

import com.rodrigodev.xgen4j.test.generation_options.guavaOptionalClassIsUsedWhenCorrespondingOptionIsSet.e1.E1Exception;
import com.rodrigodev.xgen4j.test.generation_options.guavaOptionalClassIsUsedWhenCorrespondingOptionIsSet.RootException;
import com.rodrigodev.xgen4j.test.generation_options.guavaOptionalClassIsUsedWhenCorrespondingOptionIsSet.ErrorCode;

/**
 * Autogenerated by XGen4J on January 1, 0001.
 */
public class E2Exception extends E1Exception {

    public static final ExceptionType TYPE = new ExceptionType();

    protected E2Exception(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    protected E2Exception(ErrorCode errorCode, String message, Throwable cause) {
        super(errorCode, message, cause);
    }

    private static class ExceptionType extends RootException.ExceptionType {

        @Override
        protected RootException createException(ErrorCode errorCode, String message) {
            return new E2Exception(errorCode, message);
        }

        @Override
        protected RootException createException(ErrorCode errorCode, String message, Throwable cause) {
            return new E2Exception(errorCode, message, cause);
        }
    }
}

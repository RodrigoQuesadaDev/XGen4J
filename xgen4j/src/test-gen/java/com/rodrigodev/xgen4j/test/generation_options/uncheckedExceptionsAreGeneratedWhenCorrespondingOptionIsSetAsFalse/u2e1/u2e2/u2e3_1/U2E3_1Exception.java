package com.rodrigodev.xgen4j.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsSetAsFalse.u2e1.u2e2.u2e3_1;

import com.rodrigodev.xgen4j.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsSetAsFalse.u2e1.u2e2.U2E2Exception;
import com.rodrigodev.xgen4j.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsSetAsFalse.U2RootException;

/**
 * Autogenerated by XGen on January 1, 0001.
 */
public class U2E3_1Exception extends U2E2Exception {

    public static final ExceptionType TYPE = new ExceptionType();

    private static class ExceptionType extends U2RootException.ExceptionType {

        @Override
        protected U2RootException createException(String message) {
            return new U2E3_1Exception(message);
        }

        @Override
        protected U2RootException createException(String message, Throwable cause) {
            return new U2E3_1Exception(message, cause);
        }
    }

    protected U2E3_1Exception(String message) {
        super(message);
    }

    protected U2E3_1Exception(String message, Throwable cause) {
        super(message, cause);
    }
}

package com.rodrigodev.xgen.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsSetAsFalse.u2e1.u2e2.u2e3_2;

import com.rodrigodev.xgen.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsSetAsFalse.u2e1.u2e2.U2E2Exception;
import com.rodrigodev.xgen.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsSetAsFalse.U2RootException;

/**
 * Autogenerated by XGen on July 12, 2015.
 */
public class U2E3_2Exception extends U2E2Exception {

    public static final ExceptionType TYPE = new ExceptionType();

    private static class ExceptionType extends U2RootException.ExceptionType {

        @Override
        protected U2RootException createException(String message) {
            return new U2E3_2Exception(message);
        }

        @Override
        protected U2RootException createException(String message, Throwable cause) {
            return new U2E3_2Exception(message, cause);
        }
    }

    protected U2E3_2Exception(String message) {
        super(message);
    }

    protected U2E3_2Exception(String message, Throwable cause) {
        super(message, cause);
    }
}
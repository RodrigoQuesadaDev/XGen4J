package com.rodrigodev.xgen4j.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsSetAsFalse.u2_e1.u2_e2.u2_e3_3;

import com.rodrigodev.xgen4j.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsSetAsFalse.u2_e1.u2_e2.U2E2Exception;
import com.rodrigodev.xgen4j.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsSetAsFalse.U2RootException;
import com.rodrigodev.xgen4j.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsSetAsFalse.ErrorCode;

/**
 * Autogenerated by XGen4J on January 1, 0001.
 */
public class U2E3_3Exception extends U2E2Exception {

    public static final ExceptionType TYPE = new ExceptionType();

    protected U2E3_3Exception(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    protected U2E3_3Exception(ErrorCode errorCode, String message, Throwable cause) {
        super(errorCode, message, cause);
    }

    private static class ExceptionType extends U2RootException.ExceptionType {

        @Override
        protected U2RootException createException(ErrorCode errorCode, String message) {
            return new U2E3_3Exception(errorCode, message);
        }

        @Override
        protected U2RootException createException(ErrorCode errorCode, String message, Throwable cause) {
            return new U2E3_3Exception(errorCode, message, cause);
        }
    }
}

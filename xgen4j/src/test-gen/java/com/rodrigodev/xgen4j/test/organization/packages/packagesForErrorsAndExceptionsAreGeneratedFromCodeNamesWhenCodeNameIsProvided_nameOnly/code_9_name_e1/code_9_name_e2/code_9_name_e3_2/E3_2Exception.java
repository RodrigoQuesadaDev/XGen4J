package com.rodrigodev.xgen4j.test.organization.packages.packagesForErrorsAndExceptionsAreGeneratedFromCodeNamesWhenCodeNameIsProvided_nameOnly.code_9_name_e1.code_9_name_e2.code_9_name_e3_2;

import com.rodrigodev.xgen4j.test.organization.packages.packagesForErrorsAndExceptionsAreGeneratedFromCodeNamesWhenCodeNameIsProvided_nameOnly.code_9_name_e1.code_9_name_e2.E2Exception;
import com.rodrigodev.xgen4j.test.organization.packages.packagesForErrorsAndExceptionsAreGeneratedFromCodeNamesWhenCodeNameIsProvided_nameOnly.RootException;
import com.rodrigodev.xgen4j.test.organization.packages.packagesForErrorsAndExceptionsAreGeneratedFromCodeNamesWhenCodeNameIsProvided_nameOnly.ErrorCode;

/**
 * Autogenerated by XGen4J on January 1, 0001.
 */
public class E3_2Exception extends E2Exception {

    public static final ExceptionType TYPE = new ExceptionType();

    protected E3_2Exception(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    protected E3_2Exception(ErrorCode errorCode, String message, Throwable cause) {
        super(errorCode, message, cause);
    }

    private static class ExceptionType extends RootException.ExceptionType {

        @Override
        protected RootException createException(ErrorCode errorCode, String message) {
            return new E3_2Exception(errorCode, message);
        }

        @Override
        protected RootException createException(ErrorCode errorCode, String message, Throwable cause) {
            return new E3_2Exception(errorCode, message, cause);
        }
    }
}
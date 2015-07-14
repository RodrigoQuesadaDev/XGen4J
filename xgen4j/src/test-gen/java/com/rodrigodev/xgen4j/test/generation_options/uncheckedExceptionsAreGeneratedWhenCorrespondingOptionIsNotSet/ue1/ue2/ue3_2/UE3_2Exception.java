package com.rodrigodev.xgen4j.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsNotSet.ue1.ue2.ue3_2;

import com.rodrigodev.xgen4j.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsNotSet.ue1.ue2.UE2Exception;
import com.rodrigodev.xgen4j.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsNotSet.URootException;

/**
 * Autogenerated by XGen on January 1, 0001.
 */
public class UE3_2Exception extends UE2Exception {

    public static final ExceptionType TYPE = new ExceptionType();

    private static class ExceptionType extends URootException.ExceptionType {

        @Override
        protected URootException createException(String message) {
            return new UE3_2Exception(message);
        }

        @Override
        protected URootException createException(String message, Throwable cause) {
            return new UE3_2Exception(message, cause);
        }
    }

    protected UE3_2Exception(String message) {
        super(message);
    }

    protected UE3_2Exception(String message, Throwable cause) {
        super(message, cause);
    }
}

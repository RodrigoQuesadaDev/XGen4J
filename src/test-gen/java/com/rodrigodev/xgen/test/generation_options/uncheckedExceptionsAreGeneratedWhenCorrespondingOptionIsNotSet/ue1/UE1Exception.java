package com.rodrigodev.xgen.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsNotSet.ue1;

import com.rodrigodev.xgen.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsNotSet.URootException;
import com.rodrigodev.xgen.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsNotSet.URootException;

/**
 * Autogenerated by XGen on July 12, 2015.
 */
public class UE1Exception extends URootException {

    public static final ExceptionType TYPE = new ExceptionType();

    private static class ExceptionType extends URootException.ExceptionType {

        @Override
        protected URootException createException(String message) {
            return new UE1Exception(message);
        }

        @Override
        protected URootException createException(String message, Throwable cause) {
            return new UE1Exception(message, cause);
        }
    }

    protected UE1Exception(String message) {
        super(message);
    }

    protected UE1Exception(String message, Throwable cause) {
        super(message, cause);
    }
}

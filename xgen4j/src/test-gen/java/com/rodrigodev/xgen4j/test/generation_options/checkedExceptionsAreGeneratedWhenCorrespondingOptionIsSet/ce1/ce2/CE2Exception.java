package com.rodrigodev.xgen4j.test.generation_options.checkedExceptionsAreGeneratedWhenCorrespondingOptionIsSet.ce1.ce2;

import com.rodrigodev.xgen4j.test.generation_options.checkedExceptionsAreGeneratedWhenCorrespondingOptionIsSet.ce1.CE1Exception;
import com.rodrigodev.xgen4j.test.generation_options.checkedExceptionsAreGeneratedWhenCorrespondingOptionIsSet.CRootException;

/**
 * Autogenerated by XGen4J on January 1, 0001.
 */
public class CE2Exception extends CE1Exception {

    public static final ExceptionType TYPE = new ExceptionType();

    private static class ExceptionType extends CRootException.ExceptionType {

        @Override
        protected CRootException createException(String message) {
            return new CE2Exception(message);
        }

        @Override
        protected CRootException createException(String message, Throwable cause) {
            return new CE2Exception(message, cause);
        }
    }

    protected CE2Exception(String message) {
        super(message);
    }

    protected CE2Exception(String message, Throwable cause) {
        super(message, cause);
    }
}

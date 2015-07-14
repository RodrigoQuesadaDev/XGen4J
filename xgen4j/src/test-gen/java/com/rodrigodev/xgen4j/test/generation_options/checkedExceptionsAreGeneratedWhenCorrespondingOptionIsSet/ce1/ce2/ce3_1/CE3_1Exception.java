package com.rodrigodev.xgen4j.test.generation_options.checkedExceptionsAreGeneratedWhenCorrespondingOptionIsSet.ce1.ce2.ce3_1;

import com.rodrigodev.xgen4j.test.generation_options.checkedExceptionsAreGeneratedWhenCorrespondingOptionIsSet.ce1.ce2.CE2Exception;
import com.rodrigodev.xgen4j.test.generation_options.checkedExceptionsAreGeneratedWhenCorrespondingOptionIsSet.CRootException;

/**
 * Autogenerated by XGen on January 1, 0001.
 */
public class CE3_1Exception extends CE2Exception {

    public static final ExceptionType TYPE = new ExceptionType();

    private static class ExceptionType extends CRootException.ExceptionType {

        @Override
        protected CRootException createException(String message) {
            return new CE3_1Exception(message);
        }

        @Override
        protected CRootException createException(String message, Throwable cause) {
            return new CE3_1Exception(message, cause);
        }
    }

    protected CE3_1Exception(String message) {
        super(message);
    }

    protected CE3_1Exception(String message, Throwable cause) {
        super(message, cause);
    }
}

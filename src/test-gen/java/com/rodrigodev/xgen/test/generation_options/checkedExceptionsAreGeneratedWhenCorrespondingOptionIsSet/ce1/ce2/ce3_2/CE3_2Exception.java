package com.rodrigodev.xgen.test.generation_options.checkedExceptionsAreGeneratedWhenCorrespondingOptionIsSet.ce1.ce2.ce3_2;

import com.rodrigodev.xgen.test.generation_options.checkedExceptionsAreGeneratedWhenCorrespondingOptionIsSet.ce1.ce2.CE2Exception;
import com.rodrigodev.xgen.test.generation_options.checkedExceptionsAreGeneratedWhenCorrespondingOptionIsSet.CRootException;

/**
 * Autogenerated by XGen on July 13, 2015.
 */
public class CE3_2Exception extends CE2Exception {

    public static final ExceptionType TYPE = new ExceptionType();

    private static class ExceptionType extends CRootException.ExceptionType {

        @Override
        protected CRootException createException(String message) {
            return new CE3_2Exception(message);
        }

        @Override
        protected CRootException createException(String message, Throwable cause) {
            return new CE3_2Exception(message, cause);
        }
    }

    protected CE3_2Exception(String message) {
        super(message);
    }

    protected CE3_2Exception(String message, Throwable cause) {
        super(message, cause);
    }
}

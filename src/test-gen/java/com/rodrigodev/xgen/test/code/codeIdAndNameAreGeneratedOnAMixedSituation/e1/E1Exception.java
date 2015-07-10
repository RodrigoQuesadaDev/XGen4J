package com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.e1;

import com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.RootNameException;
import com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.RootNameException;

/**
 * Autogenerated by XGen on July 11, 2015.
 */
public class E1Exception extends RootNameException {

    public static final ExceptionType TYPE = new ExceptionType();

    private static class ExceptionType extends RootNameException.ExceptionType {

        @Override
        protected RootNameException createException(String message) {
            return new E1Exception(message);
        }

        @Override
        protected RootNameException createException(String message, Throwable cause) {
            return new E1Exception(message, cause);
        }
    }

    protected E1Exception(String message) {
        super(message);
    }

    protected E1Exception(String message, Throwable cause) {
        super(message, cause);
    }
}

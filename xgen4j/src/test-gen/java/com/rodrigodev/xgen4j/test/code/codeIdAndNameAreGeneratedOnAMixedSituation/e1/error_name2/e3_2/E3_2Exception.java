package com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.e1.error_name2.e3_2;

import com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.e1.error_name2.ErrorName2Exception;
import com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.RootNameException;

/**
 * Autogenerated by XGen4J on January 1, 0001.
 */
public class E3_2Exception extends ErrorName2Exception {

    public static final ExceptionType TYPE = new ExceptionType();

    private static class ExceptionType extends RootNameException.ExceptionType {

        @Override
        protected RootNameException createException(String message) {
            return new E3_2Exception(message);
        }

        @Override
        protected RootNameException createException(String message, Throwable cause) {
            return new E3_2Exception(message, cause);
        }
    }

    protected E3_2Exception(String message) {
        super(message);
    }

    protected E3_2Exception(String message, Throwable cause) {
        super(message, cause);
    }
}

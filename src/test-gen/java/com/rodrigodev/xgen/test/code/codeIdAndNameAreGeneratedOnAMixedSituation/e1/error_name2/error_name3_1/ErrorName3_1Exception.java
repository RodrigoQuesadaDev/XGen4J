package com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.e1.error_name2.error_name3_1;

import com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.e1.error_name2.ErrorName2Exception;
import com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.RootNameException;

/**
* Autogenerated by XGen on July 8, 2015.
*/
public class ErrorName3_1Exception extends ErrorName2Exception {

    public static final ExceptionType TYPE = new ExceptionType();

    private static class ExceptionType extends RootNameException.ExceptionType {

        @Override
        protected RootNameException createException(String message) {
            return new ErrorName3_1Exception(message);
        }

        @Override
        protected RootNameException createException(String message, Throwable cause) {
            return new ErrorName3_1Exception(message, cause);
        }
    }

    protected ErrorName3_1Exception(String message) {
        super(message);
    }

    protected ErrorName3_1Exception(String message, Throwable cause) {
        super(message, cause);
    }
}

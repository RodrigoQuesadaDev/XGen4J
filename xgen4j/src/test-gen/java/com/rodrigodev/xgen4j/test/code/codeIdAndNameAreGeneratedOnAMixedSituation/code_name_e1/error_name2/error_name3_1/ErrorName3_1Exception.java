package com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.code_name_e1.error_name2.error_name3_1;

import com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.code_name_e1.error_name2.ErrorName2Exception;
import com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.RootNameException;
import com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.ErrorCode;

/**
 * Autogenerated by XGen4J on January 1, 0001.
 */
public class ErrorName3_1Exception extends ErrorName2Exception {

    public static final ExceptionType TYPE = new ExceptionType();

    protected ErrorName3_1Exception(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    protected ErrorName3_1Exception(ErrorCode errorCode, String message, Throwable cause) {
        super(errorCode, message, cause);
    }

    private static class ExceptionType extends RootNameException.ExceptionType {

        @Override
        protected RootNameException createException(ErrorCode errorCode, String message) {
            return new ErrorName3_1Exception(errorCode, message);
        }

        @Override
        protected RootNameException createException(ErrorCode errorCode, String message, Throwable cause) {
            return new ErrorName3_1Exception(errorCode, message, cause);
        }
    }
}

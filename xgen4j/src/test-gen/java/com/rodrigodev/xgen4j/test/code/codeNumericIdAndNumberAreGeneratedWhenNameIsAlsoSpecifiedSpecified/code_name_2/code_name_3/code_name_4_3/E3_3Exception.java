package com.rodrigodev.xgen4j.test.code.codeNumericIdAndNumberAreGeneratedWhenNameIsAlsoSpecifiedSpecified.code_name_2.code_name_3.code_name_4_3;

import com.rodrigodev.xgen4j.test.code.codeNumericIdAndNumberAreGeneratedWhenNameIsAlsoSpecifiedSpecified.code_name_2.code_name_3.E2Exception;
import com.rodrigodev.xgen4j.test.code.codeNumericIdAndNumberAreGeneratedWhenNameIsAlsoSpecifiedSpecified.RootException;
import com.rodrigodev.xgen4j.test.code.codeNumericIdAndNumberAreGeneratedWhenNameIsAlsoSpecifiedSpecified.ErrorCode;

/**
 * Autogenerated by XGen4J on January 1, 0001.
 */
public class E3_3Exception extends E2Exception {

    public static final ExceptionType TYPE = new ExceptionType();

    protected E3_3Exception(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    protected E3_3Exception(ErrorCode errorCode, String message, Throwable cause) {
        super(errorCode, message, cause);
    }

    private static class ExceptionType extends RootException.ExceptionType {

        @Override
        protected RootException createException(ErrorCode errorCode, String message) {
            return new E3_3Exception(errorCode, message);
        }

        @Override
        protected RootException createException(ErrorCode errorCode, String message, Throwable cause) {
            return new E3_3Exception(errorCode, message, cause);
        }
    }
}

package com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedWhenNumberIsAlsoSpecifiedSpecified.code_name_e1;

import com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedWhenNumberIsAlsoSpecifiedSpecified.RootException;
import com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedWhenNumberIsAlsoSpecifiedSpecified.RootException;
import com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedWhenNumberIsAlsoSpecifiedSpecified.ErrorCode;

/**
 * Autogenerated by XGen4J on January 1, 0001.
 */
public class E1Exception extends RootException {

    public static final ExceptionType TYPE = new ExceptionType();

    protected E1Exception(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    protected E1Exception(ErrorCode errorCode, String message, Throwable cause) {
        super(errorCode, message, cause);
    }

    private static class ExceptionType extends RootException.ExceptionType {

        @Override
        protected RootException createException(ErrorCode errorCode, String message) {
            return new E1Exception(errorCode, message);
        }

        @Override
        protected RootException createException(ErrorCode errorCode, String message, Throwable cause) {
            return new E1Exception(errorCode, message, cause);
        }
    }
}

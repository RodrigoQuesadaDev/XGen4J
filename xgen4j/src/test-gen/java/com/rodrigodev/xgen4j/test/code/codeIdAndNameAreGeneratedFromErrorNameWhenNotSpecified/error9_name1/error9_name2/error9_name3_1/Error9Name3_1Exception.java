package com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified.error9_name1.error9_name2.error9_name3_1;

import com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified.error9_name1.error9_name2.Error9Name2Exception;
import com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified.Root9NameException;
import com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified.ErrorCode;

/**
 * Autogenerated by XGen4J on January 1, 0001.
 */
public class Error9Name3_1Exception extends Error9Name2Exception {

    public static final ExceptionType TYPE = new ExceptionType();

    protected Error9Name3_1Exception(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    protected Error9Name3_1Exception(ErrorCode errorCode, String message, Throwable cause) {
        super(errorCode, message, cause);
    }

    private static class ExceptionType extends Root9NameException.ExceptionType {

        @Override
        protected Root9NameException createException(ErrorCode errorCode, String message) {
            return new Error9Name3_1Exception(errorCode, message);
        }

        @Override
        protected Root9NameException createException(ErrorCode errorCode, String message, Throwable cause) {
            return new Error9Name3_1Exception(errorCode, message, cause);
        }
    }
}
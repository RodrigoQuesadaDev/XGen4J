package com.rodrigodev.xgen4j.test.code.codeNameCanBeEqualToRootCodeNameForErrorsThatAreNotChildrenOfRootError_nameOnly.code_name_eb1.code_name_root.code_name_root;

import com.rodrigodev.xgen4j.test.code.codeNameCanBeEqualToRootCodeNameForErrorsThatAreNotChildrenOfRootError_nameOnly.code_name_eb1.code_name_root.EB2Exception;
import com.rodrigodev.xgen4j.test.code.codeNameCanBeEqualToRootCodeNameForErrorsThatAreNotChildrenOfRootError_nameOnly.RootException;
import com.rodrigodev.xgen4j.test.code.codeNameCanBeEqualToRootCodeNameForErrorsThatAreNotChildrenOfRootError_nameOnly.ErrorCode;

/**
 * Autogenerated by XGen4J on January 1, 0001.
 */
public class EB3Exception extends EB2Exception {

    public static final ExceptionType TYPE = new ExceptionType();

    protected EB3Exception(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    protected EB3Exception(ErrorCode errorCode, String message, Throwable cause) {
        super(errorCode, message, cause);
    }

    private static class ExceptionType extends RootException.ExceptionType {

        @Override
        protected RootException createException(ErrorCode errorCode, String message) {
            return new EB3Exception(errorCode, message);
        }

        @Override
        protected RootException createException(ErrorCode errorCode, String message, Throwable cause) {
            return new EB3Exception(errorCode, message, cause);
        }
    }
}
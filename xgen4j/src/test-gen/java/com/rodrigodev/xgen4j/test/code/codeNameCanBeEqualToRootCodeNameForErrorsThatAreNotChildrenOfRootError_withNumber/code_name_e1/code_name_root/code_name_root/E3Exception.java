package com.rodrigodev.xgen4j.test.code.codeNameCanBeEqualToRootCodeNameForErrorsThatAreNotChildrenOfRootError_withNumber.code_name_e1.code_name_root.code_name_root;

import com.rodrigodev.xgen4j.test.code.codeNameCanBeEqualToRootCodeNameForErrorsThatAreNotChildrenOfRootError_withNumber.code_name_e1.code_name_root.E2Exception;
import com.rodrigodev.xgen4j.test.code.codeNameCanBeEqualToRootCodeNameForErrorsThatAreNotChildrenOfRootError_withNumber.RootException;
import com.rodrigodev.xgen4j.test.code.codeNameCanBeEqualToRootCodeNameForErrorsThatAreNotChildrenOfRootError_withNumber.ErrorCode;

/**
 * Autogenerated by XGen4J on January 1, 0001.
 */
public class E3Exception extends E2Exception {

    public static final ExceptionType TYPE = new ExceptionType();

    protected E3Exception(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    protected E3Exception(ErrorCode errorCode, String message, Throwable cause) {
        super(errorCode, message, cause);
    }

    private static class ExceptionType extends RootException.ExceptionType {

        @Override
        protected RootException createException(ErrorCode errorCode, String message) {
            return new E3Exception(errorCode, message);
        }

        @Override
        protected RootException createException(ErrorCode errorCode, String message, Throwable cause) {
            return new E3Exception(errorCode, message, cause);
        }
    }
}

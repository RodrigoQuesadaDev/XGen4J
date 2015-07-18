package com.rodrigodev.xgen4j.test.code.codeNumberCanBeEqualToRootCodeNumberForErrorsThatAreNotChildrenOfRootError.eb1.eb2;

import com.rodrigodev.xgen4j.test.code.codeNumberCanBeEqualToRootCodeNumberForErrorsThatAreNotChildrenOfRootError.eb1.EB1Exception;
import com.rodrigodev.xgen4j.test.code.codeNumberCanBeEqualToRootCodeNumberForErrorsThatAreNotChildrenOfRootError.RootException;
import com.rodrigodev.xgen4j.test.code.codeNumberCanBeEqualToRootCodeNumberForErrorsThatAreNotChildrenOfRootError.ErrorCode;

/**
 * Autogenerated by XGen4J on January 1, 0001.
 */
public class EB2Exception extends EB1Exception {

    public static final ExceptionType TYPE = new ExceptionType();

    protected EB2Exception(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    protected EB2Exception(ErrorCode errorCode, String message, Throwable cause) {
        super(errorCode, message, cause);
    }

    private static class ExceptionType extends RootException.ExceptionType {

        @Override
        protected RootException createException(ErrorCode errorCode, String message) {
            return new EB2Exception(errorCode, message);
        }

        @Override
        protected RootException createException(ErrorCode errorCode, String message, Throwable cause) {
            return new EB2Exception(errorCode, message, cause);
        }
    }
}

package com.rodrigodev.xgen4j.test.code.codeNameCanBeEqualToRootCodeNameForErrorsThatAreNotChildrenOfRootError_withNumber.code_name_eb1;

import com.rodrigodev.xgen4j.test.code.codeNameCanBeEqualToRootCodeNameForErrorsThatAreNotChildrenOfRootError_withNumber.RootException;
import com.rodrigodev.xgen4j.test.code.codeNameCanBeEqualToRootCodeNameForErrorsThatAreNotChildrenOfRootError_withNumber.RootException;

/**
 * Autogenerated by XGen4J on January 1, 0001.
 */
public class EB1Exception extends RootException {

    public static final ExceptionType TYPE = new ExceptionType();

    private static class ExceptionType extends RootException.ExceptionType {

        @Override
        protected RootException createException(String message) {
            return new EB1Exception(message);
        }

        @Override
        protected RootException createException(String message, Throwable cause) {
            return new EB1Exception(message, cause);
        }
    }

    protected EB1Exception(String message) {
        super(message);
    }

    protected EB1Exception(String message, Throwable cause) {
        super(message, cause);
    }
}

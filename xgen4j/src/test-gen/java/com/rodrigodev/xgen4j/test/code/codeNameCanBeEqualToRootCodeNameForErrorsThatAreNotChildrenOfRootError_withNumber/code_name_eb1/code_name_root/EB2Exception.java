package com.rodrigodev.xgen4j.test.code.codeNameCanBeEqualToRootCodeNameForErrorsThatAreNotChildrenOfRootError_withNumber.code_name_eb1.code_name_root;

import com.rodrigodev.xgen4j.test.code.codeNameCanBeEqualToRootCodeNameForErrorsThatAreNotChildrenOfRootError_withNumber.code_name_eb1.EB1Exception;
import com.rodrigodev.xgen4j.test.code.codeNameCanBeEqualToRootCodeNameForErrorsThatAreNotChildrenOfRootError_withNumber.RootException;

/**
 * Autogenerated by XGen4J on January 1, 0001.
 */
public class EB2Exception extends EB1Exception {

    public static final ExceptionType TYPE = new ExceptionType();

    private static class ExceptionType extends RootException.ExceptionType {

        @Override
        protected RootException createException(String message) {
            return new EB2Exception(message);
        }

        @Override
        protected RootException createException(String message, Throwable cause) {
            return new EB2Exception(message, cause);
        }
    }

    protected EB2Exception(String message) {
        super(message);
    }

    protected EB2Exception(String message, Throwable cause) {
        super(message, cause);
    }
}

package com.rodrigodev.xgen4j.test.code.codeNameCanBeEqualToRootCodeNameForErrorsThatAreNotChildrenOfRootError_nameOnly.code_name_e1.code_name_root.code_name_root;

import com.rodrigodev.xgen4j.test.code.codeNameCanBeEqualToRootCodeNameForErrorsThatAreNotChildrenOfRootError_nameOnly.code_name_e1.code_name_root.E2Exception;
import com.rodrigodev.xgen4j.test.code.codeNameCanBeEqualToRootCodeNameForErrorsThatAreNotChildrenOfRootError_nameOnly.RootException;

/**
 * Autogenerated by XGen4J on January 1, 0001.
 */
public class E3Exception extends E2Exception {

    public static final ExceptionType TYPE = new ExceptionType();

    private static class ExceptionType extends RootException.ExceptionType {

        @Override
        protected RootException createException(String message) {
            return new E3Exception(message);
        }

        @Override
        protected RootException createException(String message, Throwable cause) {
            return new E3Exception(message, cause);
        }
    }

    protected E3Exception(String message) {
        super(message);
    }

    protected E3Exception(String message, Throwable cause) {
        super(message, cause);
    }
}

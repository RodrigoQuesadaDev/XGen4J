package com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedWhenNumberIsAlsoSpecifiedSpecified.e1.e2;

import com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedWhenNumberIsAlsoSpecifiedSpecified.e1.E1Exception;
import com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedWhenNumberIsAlsoSpecifiedSpecified.RootException;

/**
* Autogenerated by XGen on July 4, 2015.
*/
public class E2Exception extends E1Exception {

    public static final ExceptionType TYPE = new ExceptionType();

    private static class ExceptionType extends RootException.ExceptionType {

        @Override
        protected RootException createException(String message) {
            return new E2Exception(message);
        }
    }

    protected E2Exception(String message) {
        super(message);
    }
}

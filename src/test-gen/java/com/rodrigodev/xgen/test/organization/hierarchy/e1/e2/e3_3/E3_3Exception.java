package com.rodrigodev.xgen.test.organization.hierarchy.e1.e2.e3_3;

import com.rodrigodev.xgen.test.organization.hierarchy.e1.e2.E2Exception;
import com.rodrigodev.xgen.test.organization.hierarchy.RootException;

/**
* Autogenerated by XGen on July 4, 2015.
*/
public class E3_3Exception extends E2Exception {

    public static final ExceptionType TYPE = new ExceptionType();

    private static class ExceptionType extends RootException.ExceptionType {

        @Override
        protected RootException createException(String message) {
            return new E3_3Exception(message);
        }
    }

    protected E3_3Exception(String message) {
        super(message);
    }
}

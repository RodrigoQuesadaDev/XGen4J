package com.rodrigodev.xgen.test.organization.hierarchy.e1;

import com.rodrigodev.xgen.test.organization.hierarchy.RootException;
import com.rodrigodev.xgen.test.organization.hierarchy.RootException;

/**
* Autogenerated by XGen on July 8, 2015.
*/
public class E1Exception extends RootException {

    public static final ExceptionType TYPE = new ExceptionType();

    private static class ExceptionType extends RootException.ExceptionType {

        @Override
        protected RootException createException(String message) {
            return new E1Exception(message);
        }
    }

    protected E1Exception(String message) {
        super(message);
    }
}

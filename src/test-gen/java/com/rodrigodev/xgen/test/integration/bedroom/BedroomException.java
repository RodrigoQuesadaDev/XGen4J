package com.rodrigodev.xgen.test.integration.bedroom;

import com.rodrigodev.xgen.test.integration.HouseException;
import com.rodrigodev.xgen.test.integration.HouseException;

/**
* Autogenerated by XGen on July 8, 2015.
*/
public class BedroomException extends HouseException {

    public static final ExceptionType TYPE = new ExceptionType();

    private static class ExceptionType extends HouseException.ExceptionType {

        @Override
        protected HouseException createException(String message) {
            return new BedroomException(message);
        }

        @Override
        protected HouseException createException(String message, Throwable cause) {
            return new BedroomException(message, cause);
        }
    }

    protected BedroomException(String message) {
        super(message);
    }

    protected BedroomException(String message, Throwable cause) {
        super(message, cause);
    }
}

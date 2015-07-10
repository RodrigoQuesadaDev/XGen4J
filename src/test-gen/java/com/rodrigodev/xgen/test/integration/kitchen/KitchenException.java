package com.rodrigodev.xgen.test.integration.kitchen;

import com.rodrigodev.xgen.test.integration.HouseException;
import com.rodrigodev.xgen.test.integration.HouseException;

/**
 * Autogenerated by XGen on July 11, 2015.
 */
public class KitchenException extends HouseException {

    public static final ExceptionType TYPE = new ExceptionType();

    private static class ExceptionType extends HouseException.ExceptionType {

        @Override
        protected HouseException createException(String message) {
            return new KitchenException(message);
        }

        @Override
        protected HouseException createException(String message, Throwable cause) {
            return new KitchenException(message, cause);
        }
    }

    protected KitchenException(String message) {
        super(message);
    }

    protected KitchenException(String message, Throwable cause) {
        super(message, cause);
    }
}

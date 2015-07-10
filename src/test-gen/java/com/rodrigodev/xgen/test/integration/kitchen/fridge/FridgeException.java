package com.rodrigodev.xgen.test.integration.kitchen.fridge;

import com.rodrigodev.xgen.test.integration.kitchen.KitchenException;
import com.rodrigodev.xgen.test.integration.HouseException;

/**
 * Autogenerated by XGen on July 11, 2015.
 */
public class FridgeException extends KitchenException {

    public static final ExceptionType TYPE = new ExceptionType();

    private static class ExceptionType extends HouseException.ExceptionType {

        @Override
        protected HouseException createException(String message) {
            return new FridgeException(message);
        }

        @Override
        protected HouseException createException(String message, Throwable cause) {
            return new FridgeException(message, cause);
        }
    }

    protected FridgeException(String message) {
        super(message);
    }

    protected FridgeException(String message, Throwable cause) {
        super(message, cause);
    }
}

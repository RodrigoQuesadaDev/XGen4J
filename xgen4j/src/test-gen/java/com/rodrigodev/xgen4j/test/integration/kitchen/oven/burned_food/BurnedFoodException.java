package com.rodrigodev.xgen4j.test.integration.kitchen.oven.burned_food;

import com.rodrigodev.xgen4j.test.integration.kitchen.oven.OvenException;
import com.rodrigodev.xgen4j.test.integration.HouseException;

/**
 * Autogenerated by XGen4J on January 1, 0001.
 */
public class BurnedFoodException extends OvenException {

    public static final ExceptionType TYPE = new ExceptionType();

    private static class ExceptionType extends HouseException.ExceptionType {

        @Override
        protected HouseException createException(String message) {
            return new BurnedFoodException(message);
        }

        @Override
        protected HouseException createException(String message, Throwable cause) {
            return new BurnedFoodException(message, cause);
        }
    }

    protected BurnedFoodException(String message) {
        super(message);
    }

    protected BurnedFoodException(String message, Throwable cause) {
        super(message, cause);
    }
}

package com.rodrigodev.xgen4j.test.integration.kitchen.fridge.food_not_found;

import com.rodrigodev.xgen4j.test.integration.kitchen.fridge.FridgeException;
import com.rodrigodev.xgen4j.test.integration.HouseException;

/**
 * Autogenerated by XGen on January 1, 0001.
 */
public class FoodNotFoundException extends FridgeException {

    public static final ExceptionType TYPE = new ExceptionType();

    private static class ExceptionType extends HouseException.ExceptionType {

        @Override
        protected HouseException createException(String message) {
            return new FoodNotFoundException(message);
        }

        @Override
        protected HouseException createException(String message, Throwable cause) {
            return new FoodNotFoundException(message, cause);
        }
    }

    protected FoodNotFoundException(String message) {
        super(message);
    }

    protected FoodNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

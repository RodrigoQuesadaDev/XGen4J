package com.rodrigodev.xgen4j.test.integration.kitchen.oven.undercooked;

import com.rodrigodev.xgen4j.test.integration.kitchen.oven.OvenException;
import com.rodrigodev.xgen4j.test.integration.HouseException;

/**
 * Autogenerated by XGen4J on January 1, 0001.
 */
public class UndercookedException extends OvenException {

    public static final ExceptionType TYPE = new ExceptionType();

    private static class ExceptionType extends HouseException.ExceptionType {

        @Override
        protected HouseException createException(String message) {
            return new UndercookedException(message);
        }

        @Override
        protected HouseException createException(String message, Throwable cause) {
            return new UndercookedException(message, cause);
        }
    }

    protected UndercookedException(String message) {
        super(message);
    }

    protected UndercookedException(String message, Throwable cause) {
        super(message, cause);
    }
}

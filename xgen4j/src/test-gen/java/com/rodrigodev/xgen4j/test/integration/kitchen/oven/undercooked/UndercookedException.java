package com.rodrigodev.xgen4j.test.integration.kitchen.oven.undercooked;

import com.rodrigodev.xgen4j.test.integration.kitchen.oven.OvenException;
import com.rodrigodev.xgen4j.test.integration.HouseException;
import com.rodrigodev.xgen4j.test.integration.ErrorCode;

/**
 * Autogenerated by XGen4J on January 1, 0001.
 */
public class UndercookedException extends OvenException {

    public static final ExceptionType TYPE = new ExceptionType();

    protected UndercookedException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    protected UndercookedException(ErrorCode errorCode, String message, Throwable cause) {
        super(errorCode, message, cause);
    }

    private static class ExceptionType extends HouseException.ExceptionType {

        @Override
        protected HouseException createException(ErrorCode errorCode, String message) {
            return new UndercookedException(errorCode, message);
        }

        @Override
        protected HouseException createException(ErrorCode errorCode, String message, Throwable cause) {
            return new UndercookedException(errorCode, message, cause);
        }
    }
}

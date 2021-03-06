package com.rodrigodev.xgen4j.test.integration.kitchen.oven.too_much_smoke;

import com.rodrigodev.xgen4j.test.integration.kitchen.oven.OvenException;
import com.rodrigodev.xgen4j.test.integration.HouseException;
import com.rodrigodev.xgen4j.test.integration.ErrorCode;

/**
 * Autogenerated by XGen4J on January 1, 0001.
 */
public class TooMuchSmokeException extends OvenException {

    public static final ExceptionType TYPE = new ExceptionType();

    protected TooMuchSmokeException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    protected TooMuchSmokeException(ErrorCode errorCode, String message, Throwable cause) {
        super(errorCode, message, cause);
    }

    private static class ExceptionType extends HouseException.ExceptionType {

        @Override
        protected HouseException createException(ErrorCode errorCode, String message) {
            return new TooMuchSmokeException(errorCode, message);
        }

        @Override
        protected HouseException createException(ErrorCode errorCode, String message, Throwable cause) {
            return new TooMuchSmokeException(errorCode, message, cause);
        }
    }
}

package com.rodrigodev.xgen4j.test.integration.kitchen;

import com.rodrigodev.xgen4j.test.integration.HouseException;
import com.rodrigodev.xgen4j.test.integration.HouseException;
import com.rodrigodev.xgen4j.test.integration.ErrorCode;

/**
 * Autogenerated by XGen4J on January 1, 0001.
 */
public class KitchenException extends HouseException {

    public static final ExceptionType TYPE = new ExceptionType();

    protected KitchenException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    protected KitchenException(ErrorCode errorCode, String message, Throwable cause) {
        super(errorCode, message, cause);
    }

    private static class ExceptionType extends HouseException.ExceptionType {

        @Override
        protected HouseException createException(ErrorCode errorCode, String message) {
            return new KitchenException(errorCode, message);
        }

        @Override
        protected HouseException createException(ErrorCode errorCode, String message, Throwable cause) {
            return new KitchenException(errorCode, message, cause);
        }
    }
}

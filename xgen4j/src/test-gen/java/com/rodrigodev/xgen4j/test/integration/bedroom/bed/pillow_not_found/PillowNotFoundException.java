package com.rodrigodev.xgen4j.test.integration.bedroom.bed.pillow_not_found;

import com.rodrigodev.xgen4j.test.integration.bedroom.bed.BedException;
import com.rodrigodev.xgen4j.test.integration.HouseException;

/**
 * Autogenerated by XGen on January 1, 0001.
 */
public class PillowNotFoundException extends BedException {

    public static final ExceptionType TYPE = new ExceptionType();

    private static class ExceptionType extends HouseException.ExceptionType {

        @Override
        protected HouseException createException(String message) {
            return new PillowNotFoundException(message);
        }

        @Override
        protected HouseException createException(String message, Throwable cause) {
            return new PillowNotFoundException(message, cause);
        }
    }

    protected PillowNotFoundException(String message) {
        super(message);
    }

    protected PillowNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
package com.rodrigodev.xgen4j.test.integration.bedroom.alarm_clock.shut_up;

import com.rodrigodev.xgen4j.test.integration.bedroom.alarm_clock.AlarmClockException;
import com.rodrigodev.xgen4j.test.integration.HouseException;

/**
 * Autogenerated by XGen on January 1, 0001.
 */
public class ShutUpException extends AlarmClockException {

    public static final ExceptionType TYPE = new ExceptionType();

    private static class ExceptionType extends HouseException.ExceptionType {

        @Override
        protected HouseException createException(String message) {
            return new ShutUpException(message);
        }

        @Override
        protected HouseException createException(String message, Throwable cause) {
            return new ShutUpException(message, cause);
        }
    }

    protected ShutUpException(String message) {
        super(message);
    }

    protected ShutUpException(String message, Throwable cause) {
        super(message, cause);
    }
}
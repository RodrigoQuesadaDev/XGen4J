package com.rodrigodev.xgen4j.test.integration.bedroom.alarm_clock.too_early;

import com.rodrigodev.xgen4j.test.integration.bedroom.alarm_clock.AlarmClockException;
import com.rodrigodev.xgen4j.test.integration.HouseException;

/**
 * Autogenerated by XGen on January 1, 0001.
 */
public class TooEarlyException extends AlarmClockException {

    public static final ExceptionType TYPE = new ExceptionType();

    private static class ExceptionType extends HouseException.ExceptionType {

        @Override
        protected HouseException createException(String message) {
            return new TooEarlyException(message);
        }

        @Override
        protected HouseException createException(String message, Throwable cause) {
            return new TooEarlyException(message, cause);
        }
    }

    protected TooEarlyException(String message) {
        super(message);
    }

    protected TooEarlyException(String message, Throwable cause) {
        super(message, cause);
    }
}
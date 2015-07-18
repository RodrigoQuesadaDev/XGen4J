package com.rodrigodev.xgen4j.test.integration.bedroom.alarm_clock;

import com.rodrigodev.xgen4j.test.integration.bedroom.BedroomException;
import com.rodrigodev.xgen4j.test.integration.HouseException;
import com.rodrigodev.xgen4j.test.integration.ErrorCode;

/**
 * Autogenerated by XGen4J on January 1, 0001.
 */
public class AlarmClockException extends BedroomException {

    public static final ExceptionType TYPE = new ExceptionType();

    protected AlarmClockException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    protected AlarmClockException(ErrorCode errorCode, String message, Throwable cause) {
        super(errorCode, message, cause);
    }

    private static class ExceptionType extends HouseException.ExceptionType {

        @Override
        protected HouseException createException(ErrorCode errorCode, String message) {
            return new AlarmClockException(errorCode, message);
        }

        @Override
        protected HouseException createException(ErrorCode errorCode, String message, Throwable cause) {
            return new AlarmClockException(errorCode, message, cause);
        }
    }
}

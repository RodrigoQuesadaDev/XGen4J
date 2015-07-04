package com.rodrigodev.xgen.test.integration.bedroom.alarm_clock.too_early;

import com.rodrigodev.xgen.test.integration.bedroom.alarm_clock.AlarmClockException;
import com.rodrigodev.xgen.test.integration.HouseException;

/**
* Autogenerated by XGen on July 4, 2015.
*/
public class TooEarlyException extends AlarmClockException {

    public static final ExceptionType TYPE = new ExceptionType();

    private static class ExceptionType extends HouseException.ExceptionType {

        @Override
        protected HouseException createException(String message) {
            return new TooEarlyException(message);
        }
    }

    protected TooEarlyException(String message) {
        super(message);
    }
}

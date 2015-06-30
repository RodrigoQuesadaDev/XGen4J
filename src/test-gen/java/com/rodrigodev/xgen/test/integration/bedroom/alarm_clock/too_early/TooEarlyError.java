package com.rodrigodev.xgen.test.integration.bedroom.alarm_clock.too_early;

import com.rodrigodev.xgen.test.integration.bedroom.alarm_clock.AlarmClockError;
import com.rodrigodev.xgen.test.integration.ErrorCode;

import java.lang.String;

/**
* Autogenerated by XGen on June 30, 2015.
*/
public abstract class TooEarlyError extends AlarmClockError {

    public static final ErrorCode CODE = new ErrorCode("house.bedroom.alarm-clock.too-early");

    private static String MESSAGE_FORMAT = "It's just %s, still to early to wake up.";

    public static void throwException(String time) {
        throw new TooEarlyException(String.format(MESSAGE_FORMAT, time));
    }
}

package com.rodrigodev.xgen.test.integration.bedroom.alarm_clock.shut_up;

import com.rodrigodev.xgen.test.integration.bedroom.alarm_clock.AlarmClockError;
import com.rodrigodev.xgen.test.integration.ErrorCode;

import java.lang.String;

/**
* Autogenerated by XGen on June 29, 2015.
*/
public abstract class ShutUpError extends AlarmClockError {

    public static final ErrorCode CODE = new ErrorCode("house.bedroom.alarm-clock.shut-up");

    private static String MESSAGE_FORMAT = "Shut up!, I just want to defeat the boss and get %s's legendary sword.";

    public static void throwException(String legendaryHero) {
        throw new ShutUpException(String.format(MESSAGE_FORMAT, legendaryHero));
    }
}

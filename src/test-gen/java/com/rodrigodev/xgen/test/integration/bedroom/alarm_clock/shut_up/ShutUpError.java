package com.rodrigodev.xgen.test.integration.bedroom.alarm_clock.shut_up;

import com.rodrigodev.xgen.test.integration.bedroom.alarm_clock.AlarmClockError;

import java.lang.String;

import com.rodrigodev.xgen.test.integration.ErrorCode;

/**
 * Autogenerated by XGen on July 11, 2015.
 */
public abstract class ShutUpError extends AlarmClockError {

    public static final ErrorCode CODE = new ErrorCode("shut-up", AlarmClockError.CODE);

    private static String MESSAGE_FORMAT = "Shut up!, I just want to defeat the boss and get %s's legendary sword.";

    private static String createMessage(String legendaryHero) {
        if(legendaryHero == null) throw new NullPointerException("legendaryHero");

        return String.format(MESSAGE_FORMAT, legendaryHero);
    }

    public static void throwException(String legendaryHero) {
        throw new ShutUpException(createMessage(legendaryHero));
    }

    public static void throwException(String legendaryHero, Throwable cause) {
        throw new ShutUpException(createMessage(legendaryHero), cause);
    }


}

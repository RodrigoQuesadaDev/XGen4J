package com.rodrigodev.xgen.test.integration.bedroom.alarm_clock.shut_up;

import com.rodrigodev.xgen.test.integration.bedroom.alarm_clock.AlarmClockError;

/**
* Autogenerated by XGen on 12/05/15.
*/
public abstract class ShutUpError extends AlarmClockError {

    private static String MESSAGE_FORMAT = "Shut up!, I just want to defeat the boss and get %s's legendary sword.";

    public static void throwException(String legendaryHero) {
        throw new ShutUpException(String.format(MESSAGE_FORMAT, legendaryHero));
    }
}
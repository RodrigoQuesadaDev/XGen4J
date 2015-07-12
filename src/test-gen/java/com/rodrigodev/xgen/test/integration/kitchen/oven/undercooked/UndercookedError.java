package com.rodrigodev.xgen.test.integration.kitchen.oven.undercooked;

import com.rodrigodev.xgen.test.integration.kitchen.oven.OvenError;

import java.lang.String;

import com.rodrigodev.xgen.test.integration.ErrorCode;

/**
 * Autogenerated by XGen on July 12, 2015.
 */
public abstract class UndercookedError extends OvenError {

    public static final ErrorCode CODE = new ErrorCode("undercooked", OvenError.CODE);

    private static String MESSAGE_FORMAT = "The %s is undercooked my friend, I won't eat that.";

    private static String createMessage(String model) {
        if(model == null) throw new NullPointerException("model");

        return String.format(MESSAGE_FORMAT, model);
    }

    public static void throwException(String model) {
        throw new UndercookedException(createMessage(model));
    }

    public static void throwException(String model, Throwable cause) {
        throw new UndercookedException(createMessage(model), cause);
    }


}

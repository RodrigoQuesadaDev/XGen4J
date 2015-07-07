package com.rodrigodev.xgen.test.integration.kitchen.oven.too_much_smoke;

import com.rodrigodev.xgen.test.integration.kitchen.oven.OvenError;

import java.lang.String;

import com.rodrigodev.xgen.test.integration.ErrorCode;

/**
* Autogenerated by XGen on July 6, 2015.
*/
public abstract class TooMuchSmokeError extends OvenError {

    public static final ErrorCode CODE = new ErrorCode("too-much-smoke", OvenError.CODE);

    private static String MESSAGE_FORMAT = "Wow, there is too much smoke coming out from the oven. Do you think the %s is okay?";

    private static String createMessage(String model) {
        return String.format(MESSAGE_FORMAT, model);
    }

    public static void throwException(String model) {
        if(model == null) throw new NullPointerException("model");

        throw new TooMuchSmokeException(createMessage(model));
    }


}

package com.rodrigodev.xgen.test.integration.kitchen.oven;

import com.rodrigodev.xgen.test.integration.kitchen.KitchenError;
import com.rodrigodev.xgen.test.integration.ErrorCode;

import java.lang.String;

/**
* Autogenerated by XGen on June 30, 2015.
*/
public abstract class OvenError extends KitchenError {

    public static final ErrorCode CODE = new ErrorCode("house.kitchen.oven");

    private static String MESSAGE_FORMAT = "The oven is not working. Model: %s";

    public static void throwException(String model) {
        throw new OvenException(String.format(MESSAGE_FORMAT, model));
    }
}

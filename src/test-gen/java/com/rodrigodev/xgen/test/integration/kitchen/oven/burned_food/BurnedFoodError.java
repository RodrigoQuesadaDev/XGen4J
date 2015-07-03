package com.rodrigodev.xgen.test.integration.kitchen.oven.burned_food;

import com.rodrigodev.xgen.test.integration.kitchen.oven.OvenError;
import com.rodrigodev.xgen.test.integration.ErrorCode;

import java.lang.String;

/**
* Autogenerated by XGen on July 3, 2015.
*/
public abstract class BurnedFoodError extends OvenError {

    public static final ErrorCode CODE = new ErrorCode("burned-food", OvenError.CODE);

    private static String MESSAGE_FORMAT = "Damn, the %s just burned! We better order some pizza.";

    public static void throwException(String model) {
        if(model == null) throw new NullPointerException("model");

        throw new BurnedFoodException(String.format(MESSAGE_FORMAT, model));
    }
}

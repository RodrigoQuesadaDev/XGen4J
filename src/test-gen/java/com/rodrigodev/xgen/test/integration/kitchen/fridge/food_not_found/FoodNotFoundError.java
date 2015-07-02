package com.rodrigodev.xgen.test.integration.kitchen.fridge.food_not_found;

import com.rodrigodev.xgen.test.integration.kitchen.fridge.FridgeError;
import com.rodrigodev.xgen.test.integration.ErrorCode;

import java.lang.String;

/**
* Autogenerated by XGen on July 2, 2015.
*/
public abstract class FoodNotFoundError extends FridgeError {

    public static final ErrorCode CODE = new ErrorCode("food-not-found", FridgeError.CODE);

    private static String MESSAGE_FORMAT = "Food %s not found! I'm starving.";

    public static void throwException(String foodName) {
        throw new FoodNotFoundException(String.format(MESSAGE_FORMAT, foodName));
    }
}

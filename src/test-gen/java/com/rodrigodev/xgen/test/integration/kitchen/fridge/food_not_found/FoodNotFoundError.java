package com.rodrigodev.xgen.test.integration.kitchen.fridge.food_not_found;

import com.rodrigodev.xgen.test.integration.kitchen.fridge.FridgeError;

import java.lang.String;

import com.rodrigodev.xgen.test.integration.ErrorCode;

/**
* Autogenerated by XGen on July 8, 2015.
*/
public abstract class FoodNotFoundError extends FridgeError {

    public static final ErrorCode CODE = new ErrorCode("food-not-found", FridgeError.CODE);

    private static String MESSAGE_FORMAT = "Food %s not found! I'm starving.";

    private static String createMessage(String foodName) {
        if(foodName == null) throw new NullPointerException("foodName");

        return String.format(MESSAGE_FORMAT, foodName);
    }

    public static void throwException(String foodName) {
        throw new FoodNotFoundException(createMessage(foodName));
    }

    public static void throwException(String foodName, Throwable cause) {
        throw new FoodNotFoundException(createMessage(foodName), cause);
    }


}

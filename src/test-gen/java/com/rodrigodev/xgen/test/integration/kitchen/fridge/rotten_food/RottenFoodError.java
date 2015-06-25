package com.rodrigodev.xgen.test.integration.kitchen.fridge.rotten_food;

import com.rodrigodev.xgen.test.integration.kitchen.fridge.FridgeError;

import java.lang.String;

/**
* Autogenerated by XGen on 12/05/15.
*/
public abstract class RottenFoodError extends FridgeError {

    private static String MESSAGE_FORMAT = "The %s is rotten my friend.";

    public static void throwException(String foodName) {
        throw new RottenFoodException(String.format(MESSAGE_FORMAT, foodName));
    }
}

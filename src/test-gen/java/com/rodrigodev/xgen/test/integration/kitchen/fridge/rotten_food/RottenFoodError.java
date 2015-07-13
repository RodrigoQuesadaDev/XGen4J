package com.rodrigodev.xgen.test.integration.kitchen.fridge.rotten_food;

import com.rodrigodev.xgen.test.integration.kitchen.fridge.FridgeError;

import java.lang.String;

import com.rodrigodev.xgen.test.integration.ErrorCode;

/**
 * Autogenerated by XGen on July 13, 2015.
 */
public abstract class RottenFoodError extends FridgeError {

    public static final ErrorCode CODE = new ErrorCode("rotten-food", FridgeError.CODE);

    private static String MESSAGE_FORMAT = "The %s is rotten my friend.";

    private static String createMessage(String foodName) {
        if(foodName == null) throw new NullPointerException("foodName");

        return String.format(MESSAGE_FORMAT, foodName);
    }

    public static void throwException(String foodName) {
        throw new RottenFoodException(createMessage(foodName));
    }

    public static void throwException(String foodName, Throwable cause) {
        throw new RottenFoodException(createMessage(foodName), cause);
    }


}

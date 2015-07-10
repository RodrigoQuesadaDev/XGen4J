package com.rodrigodev.xgen.test.integration.kitchen.fridge.frozen_food;

import com.rodrigodev.xgen.test.integration.kitchen.fridge.FridgeError;

import java.lang.String;

import com.rodrigodev.xgen.test.integration.ErrorCode;

/**
 * Autogenerated by XGen on July 11, 2015.
 */
public abstract class FrozenFoodError extends FridgeError {

    public static final ErrorCode CODE = new ErrorCode("frozen-food", FridgeError.CODE);

    private static String MESSAGE_FORMAT = "The %s is frozen! How could you possibly eat that?";

    private static String createMessage(String foodName) {
        if(foodName == null) throw new NullPointerException("foodName");

        return String.format(MESSAGE_FORMAT, foodName);
    }

    public static void throwException(String foodName) {
        throw new FrozenFoodException(createMessage(foodName));
    }

    public static void throwException(String foodName, Throwable cause) {
        throw new FrozenFoodException(createMessage(foodName), cause);
    }


}

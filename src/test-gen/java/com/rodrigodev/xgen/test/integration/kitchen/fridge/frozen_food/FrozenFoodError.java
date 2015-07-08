package com.rodrigodev.xgen.test.integration.kitchen.fridge.frozen_food;

import com.rodrigodev.xgen.test.integration.kitchen.fridge.FridgeError;

import java.lang.String;

import com.rodrigodev.xgen.test.integration.ErrorCode;

/**
* Autogenerated by XGen on July 8, 2015.
*/
public abstract class FrozenFoodError extends FridgeError {

    public static final ErrorCode CODE = new ErrorCode("frozen-food", FridgeError.CODE);

    private static String MESSAGE_FORMAT = "The %s is frozen! How could you possibly eat that?";

    private static String createMessage(String foodName) {
        return String.format(MESSAGE_FORMAT, foodName);
    }

    public static void throwException(String foodName) {
        if(foodName == null) throw new NullPointerException("foodName");

        throw new FrozenFoodException(createMessage(foodName));
    }


}

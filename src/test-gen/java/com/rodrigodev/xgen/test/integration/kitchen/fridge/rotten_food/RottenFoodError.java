package com.rodrigodev.xgen.test.integration.kitchen.fridge.rotten_food;

import com.rodrigodev.xgen.test.integration.kitchen.fridge.FridgeError;
import com.rodrigodev.xgen.test.integration.ErrorCode;

import java.lang.String;

/**
* Autogenerated by XGen on July 3, 2015.
*/
public abstract class RottenFoodError extends FridgeError {

    public static final ErrorCode CODE = new ErrorCode("rotten-food", FridgeError.CODE);

    private static String MESSAGE_FORMAT = "The %s is rotten my friend.";

    public static void throwException(String foodName) {
        if(foodName == null) throw new NullPointerException("foodName");

        throw new RottenFoodException(String.format(MESSAGE_FORMAT, foodName));
    }
}

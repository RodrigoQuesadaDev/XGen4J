package com.rodrigodev.xgen.test.gen.exceptions_generator.generate;

/**
* Autogenerated by XGen on 12/05/15.
*/
public class FoodNotFoundError {

    private static String MESSAGE_FORMAT = "Food %s not found! I'm starving.";

    public static void throwException(String foodName) {
        throw new FoodNotFoundException(String.format(MESSAGE_FORMAT, foodName));
    }
}

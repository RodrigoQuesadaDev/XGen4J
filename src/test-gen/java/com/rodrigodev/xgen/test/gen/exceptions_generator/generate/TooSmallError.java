package com.rodrigodev.xgen.test.gen.exceptions_generator.generate;

/**
* Autogenerated by XGen on 12/05/15.
*/
public class TooSmallError {

    private static String MESSAGE_FORMAT = "%s is too damn small!";

    public static void throwException(String roomName) {
        throw new TooSmallException(String.format(MESSAGE_FORMAT, roomName));
    }
}

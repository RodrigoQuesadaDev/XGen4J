package com.rodrigodev.xgen.test.gen.exceptions_generator.generate;

/**
* Autogenerated by XGen on 12/05/15.
*/
public class DirtyError {

    private static String MESSAGE_FORMAT = "%s is dirty!";

    public static void throwException(String roomName) {
        throw new DirtyException(String.format(MESSAGE_FORMAT, roomName));
    }
}

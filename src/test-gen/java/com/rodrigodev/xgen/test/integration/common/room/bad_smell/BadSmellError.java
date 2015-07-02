package com.rodrigodev.xgen.test.integration.common.room.bad_smell;

import com.rodrigodev.xgen.test.integration.common.room.RoomError;
import com.rodrigodev.xgen.test.integration.ErrorCode;

import java.lang.String;

/**
* Autogenerated by XGen on July 1, 2015.
*/
public abstract class BadSmellError extends RoomError {

    public static final ErrorCode CODE = new ErrorCode("house.common.room.bad-smell");

    private static String MESSAGE_FORMAT = "The %s smells bad, really bad.";

    public static void throwException(String roomName) {
        throw new BadSmellException(String.format(MESSAGE_FORMAT, roomName));
    }
}

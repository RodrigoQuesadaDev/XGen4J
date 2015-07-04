package com.rodrigodev.xgen.test.integration.common.room.bad_smell;

import com.rodrigodev.xgen.test.integration.common.room.RoomError;

import java.lang.String;

import com.rodrigodev.xgen.test.integration.ErrorCode;
import com.rodrigodev.xgen.test.integration.HouseException.ExceptionType;

/**
* Autogenerated by XGen on July 4, 2015.
*/
public abstract class BadSmellError extends RoomError {

    public static final ErrorCode CODE = new ErrorCode("bad-smell", RoomError.CODE);

    private static String MESSAGE_FORMAT = "The %s smells bad, really bad.";

    private static String createMessage(String roomName) {
        return String.format(MESSAGE_FORMAT, roomName);
    }

    public static void throwException(String roomName) {
        if(roomName == null) throw new NullPointerException("roomName");

        throw new BadSmellException(createMessage(roomName));
    }

    public static void throwException(ExceptionType exceptionType, String roomName) {
        throwExceptionForCommonError(exceptionType, createMessage(roomName));
    }

}

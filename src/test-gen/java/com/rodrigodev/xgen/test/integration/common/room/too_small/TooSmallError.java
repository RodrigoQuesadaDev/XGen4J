package com.rodrigodev.xgen.test.integration.common.room.too_small;

import com.rodrigodev.xgen.test.integration.common.room.RoomError;

import java.lang.String;

import com.rodrigodev.xgen.test.integration.ErrorCode;
import com.rodrigodev.xgen.test.integration.HouseException.ExceptionType;

/**
* Autogenerated by XGen on July 8, 2015.
*/
public abstract class TooSmallError extends RoomError {

    public static final ErrorCode CODE = new ErrorCode("too-small", RoomError.CODE);

    private static String MESSAGE_FORMAT = "%s is too damn small!";

    private static String createMessage(String roomName) {
        return String.format(MESSAGE_FORMAT, roomName);
    }

    public static void throwException(String roomName) {
        if(roomName == null) throw new NullPointerException("roomName");

        throw new TooSmallException(createMessage(roomName));
    }

    public static void throwException(ExceptionType exceptionType, String roomName) {
        if(roomName == null) throw new NullPointerException("roomName");

        throwExceptionForCommonError(exceptionType, createMessage(roomName));
    }

}

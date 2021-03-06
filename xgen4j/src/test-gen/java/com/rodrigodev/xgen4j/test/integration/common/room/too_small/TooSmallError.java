package com.rodrigodev.xgen4j.test.integration.common.room.too_small;

import com.rodrigodev.xgen4j.test.integration.common.room.RoomError;

import java.lang.String;

import com.rodrigodev.xgen4j.test.integration.ErrorCode;
import com.rodrigodev.xgen4j.test.integration.HouseException;
import com.rodrigodev.xgen4j.test.integration.HouseException.ExceptionType;

/**
 * Autogenerated by XGen4J on January 1, 0001.
 */
public abstract class TooSmallError extends RoomError {

    public static final ErrorCode CODE = new ErrorCode("too-small", RoomError.CODE);

    private static String MESSAGE_FORMAT = "%s is too damn small!";

    private static String createMessage(String roomName) {
        if(roomName == null) throw new NullPointerException("roomName");

        return String.format(MESSAGE_FORMAT, roomName);
    }

    public static void throwException(String roomName) {
        throw new TooSmallException(CODE, createMessage(roomName));
    }

    public static void throwException(String roomName, Throwable cause) {
        throw new TooSmallException(CODE, createMessage(roomName), cause);
    }

    public static void throwException(ExceptionType exceptionType, String roomName) {
        throwExceptionForCommonError(CODE, exceptionType, createMessage(roomName));
    }

    public static void throwException(ExceptionType exceptionType, String roomName, Throwable cause) {
        throwExceptionForCommonError(CODE, exceptionType, createMessage(roomName), cause);
    }

}

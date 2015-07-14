package com.rodrigodev.xgen.test.integration.common.room.dirty;

import com.rodrigodev.xgen.test.integration.common.room.RoomError;

import java.lang.String;

import com.rodrigodev.xgen.test.integration.ErrorCode;
import com.rodrigodev.xgen.test.integration.HouseException;
import com.rodrigodev.xgen.test.integration.HouseException.ExceptionType;

/**
 * Autogenerated by XGen on January 1, 0001.
 */
public abstract class DirtyError extends RoomError {

    public static final ErrorCode CODE = new ErrorCode("dirty", RoomError.CODE);

    private static String MESSAGE_FORMAT = "%s is dirty!";

    private static String createMessage(String roomName) {
        if(roomName == null) throw new NullPointerException("roomName");

        return String.format(MESSAGE_FORMAT, roomName);
    }

    public static void throwException(String roomName) {
        throw new DirtyException(createMessage(roomName));
    }

    public static void throwException(String roomName, Throwable cause) {
        throw new DirtyException(createMessage(roomName), cause);
    }

    public static void throwException(ExceptionType exceptionType, String roomName) {
        throwExceptionForCommonError(exceptionType, createMessage(roomName));
    }

    public static void throwException(ExceptionType exceptionType, String roomName, Throwable cause) {
        throwExceptionForCommonError(exceptionType, createMessage(roomName), cause);
    }

}

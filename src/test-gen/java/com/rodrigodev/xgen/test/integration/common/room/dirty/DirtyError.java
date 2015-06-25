package com.rodrigodev.xgen.test.integration.common.room.dirty;

import com.rodrigodev.xgen.test.integration.common.room.RoomError;

import java.lang.String;

/**
* Autogenerated by XGen on 12/05/15.
*/
public abstract class DirtyError extends RoomError {

    private static String MESSAGE_FORMAT = "%s is dirty!";

    public static void throwException(String roomName) {
        throw new DirtyException(String.format(MESSAGE_FORMAT, roomName));
    }
}

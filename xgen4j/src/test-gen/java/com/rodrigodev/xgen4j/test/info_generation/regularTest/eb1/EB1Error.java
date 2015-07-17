package com.rodrigodev.xgen4j.test.info_generation.regularTest.eb1;

import com.rodrigodev.xgen4j.test.info_generation.regularTest.RootError;


import com.rodrigodev.xgen4j.test.info_generation.regularTest.ErrorCode;

/**
 * Autogenerated by XGen4J on January 1, 0001.
 */
public abstract class EB1Error extends RootError {

    public static final ErrorCode CODE = new ErrorCode("e-b-1", 4567);

    private static String MESSAGE_FORMAT = "Message for EB1 error.";

    private static String createMessage() {

        return String.format(MESSAGE_FORMAT);
    }

    public static void throwException() {
        throw new EB1Exception(createMessage());
    }

    public static void throwException(Throwable cause) {
        throw new EB1Exception(createMessage(), cause);
    }


}

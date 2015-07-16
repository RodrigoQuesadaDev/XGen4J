package com.rodrigodev.xgen4j.test.info_generation.regularTest.eb1.eb2.eb3_1;

import com.rodrigodev.xgen4j.test.info_generation.regularTest.eb1.eb2.EB2Error;


import com.rodrigodev.xgen4j.test.info_generation.regularTest.ErrorCode;

/**
 * Autogenerated by XGen4J on January 1, 0001.
 */
public abstract class EB3_1Error extends EB2Error {

    public static final ErrorCode CODE = new ErrorCode("e-b-3-1", 6789, EB2Error.CODE);

    private static String MESSAGE_FORMAT = "Message for EB3_1 error.";

    private static String createMessage() {

        return String.format(MESSAGE_FORMAT);
    }

    public static void throwException() {
        throw new EB3_1Exception(createMessage());
    }

    public static void throwException(Throwable cause) {
        throw new EB3_1Exception(createMessage(), cause);
    }


}

package com.rodrigodev.xgen4j.test.info_generation.ea1.ea2.ea3_1;

import com.rodrigodev.xgen4j.test.info_generation.ea1.ea2.EA2Error;


import com.rodrigodev.xgen4j.test.info_generation.ErrorCode;

/**
 * Autogenerated by XGen on January 1, 0001.
 */
public abstract class EA3_1Error extends EA2Error {

    public static final ErrorCode CODE = new ErrorCode("e-a-3-1", EA2Error.CODE);

    private static String MESSAGE_FORMAT = "Message for EA3_1 error.";

    private static String createMessage() {

        return String.format(MESSAGE_FORMAT);
    }

    public static void throwException() {
        throw new EA3_1Exception(createMessage());
    }

    public static void throwException(Throwable cause) {
        throw new EA3_1Exception(createMessage(), cause);
    }


}

package com.rodrigodev.xgen4j.test.generation_options.guavaOptionalClassIsUsedWhenCorrespondingOptionIsSet.guava_e1.guava_e2.guava_e3_1;

import com.rodrigodev.xgen4j.test.generation_options.guavaOptionalClassIsUsedWhenCorrespondingOptionIsSet.guava_e1.guava_e2.GuavaE2Error;


import com.rodrigodev.xgen4j.test.generation_options.guavaOptionalClassIsUsedWhenCorrespondingOptionIsSet.ErrorCode;

/**
 * Autogenerated by XGen on January 1, 0001.
 */
public abstract class GuavaE3_1Error extends GuavaE2Error {

    public static final ErrorCode CODE = new ErrorCode("guava-e-3-1", GuavaE2Error.CODE);

    private static String MESSAGE_FORMAT = "Message for E3_1 error.";

    private static String createMessage() {

        return String.format(MESSAGE_FORMAT);
    }

    public static void throwException() {
        throw new GuavaE3_1Exception(createMessage());
    }

    public static void throwException(Throwable cause) {
        throw new GuavaE3_1Exception(createMessage(), cause);
    }


}
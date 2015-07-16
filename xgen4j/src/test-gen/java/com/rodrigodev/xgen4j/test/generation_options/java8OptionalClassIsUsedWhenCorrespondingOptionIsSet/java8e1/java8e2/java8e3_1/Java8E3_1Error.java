package com.rodrigodev.xgen4j.test.generation_options.java8OptionalClassIsUsedWhenCorrespondingOptionIsSet.java8e1.java8e2.java8e3_1;

import com.rodrigodev.xgen4j.test.generation_options.java8OptionalClassIsUsedWhenCorrespondingOptionIsSet.java8e1.java8e2.Java8E2Error;


import com.rodrigodev.xgen4j.test.generation_options.java8OptionalClassIsUsedWhenCorrespondingOptionIsSet.ErrorCode;

/**
 * Autogenerated by XGen on January 1, 0001.
 */
public abstract class Java8E3_1Error extends Java8E2Error {

    public static final ErrorCode CODE = new ErrorCode("java-8-e-3-1", Java8E2Error.CODE);

    private static String MESSAGE_FORMAT = "Message for E3_1 error.";

    private static String createMessage() {

        return String.format(MESSAGE_FORMAT);
    }

    public static void throwException() {
        throw new Java8E3_1Exception(createMessage());
    }

    public static void throwException(Throwable cause) {
        throw new Java8E3_1Exception(createMessage(), cause);
    }


}
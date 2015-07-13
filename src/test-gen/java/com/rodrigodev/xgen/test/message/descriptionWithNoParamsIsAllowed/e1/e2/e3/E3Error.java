package com.rodrigodev.xgen.test.message.descriptionWithNoParamsIsAllowed.e1.e2.e3;

import com.rodrigodev.xgen.test.message.descriptionWithNoParamsIsAllowed.e1.e2.E2Error;


import com.rodrigodev.xgen.test.message.descriptionWithNoParamsIsAllowed.ErrorCode;

/**
 * Autogenerated by XGen on July 13, 2015.
 */
public abstract class E3Error extends E2Error {

    public static final ErrorCode CODE = new ErrorCode("e-3", E2Error.CODE);

    private static String MESSAGE_FORMAT = "Some description.";

    private static String createMessage() {

        return String.format(MESSAGE_FORMAT);
    }

    public static void throwException() {
        throw new E3Exception(createMessage());
    }

    public static void throwException(Throwable cause) {
        throw new E3Exception(createMessage(), cause);
    }


}

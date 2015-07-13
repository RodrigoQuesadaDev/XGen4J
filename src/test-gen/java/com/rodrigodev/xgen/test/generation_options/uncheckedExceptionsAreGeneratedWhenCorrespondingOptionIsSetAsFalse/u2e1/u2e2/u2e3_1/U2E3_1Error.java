package com.rodrigodev.xgen.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsSetAsFalse.u2e1.u2e2.u2e3_1;

import com.rodrigodev.xgen.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsSetAsFalse.u2e1.u2e2.U2E2Error;


import com.rodrigodev.xgen.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsSetAsFalse.ErrorCode;

/**
 * Autogenerated by XGen on July 13, 2015.
 */
public abstract class U2E3_1Error extends U2E2Error {

    public static final ErrorCode CODE = new ErrorCode("u-2-e-3-1", U2E2Error.CODE);

    private static String MESSAGE_FORMAT = "Message for E3_1 error.";

    private static String createMessage() {

        return String.format(MESSAGE_FORMAT);
    }

    public static void throwException() {
        throw new U2E3_1Exception(createMessage());
    }

    public static void throwException(Throwable cause) {
        throw new U2E3_1Exception(createMessage(), cause);
    }


}

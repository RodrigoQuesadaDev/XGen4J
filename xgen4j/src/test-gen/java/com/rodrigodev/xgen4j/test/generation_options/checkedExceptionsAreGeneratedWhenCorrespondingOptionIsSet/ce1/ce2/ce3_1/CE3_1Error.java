package com.rodrigodev.xgen4j.test.generation_options.checkedExceptionsAreGeneratedWhenCorrespondingOptionIsSet.ce1.ce2.ce3_1;

import com.rodrigodev.xgen4j.test.generation_options.checkedExceptionsAreGeneratedWhenCorrespondingOptionIsSet.ce1.ce2.CE2Error;


import com.rodrigodev.xgen4j.test.generation_options.checkedExceptionsAreGeneratedWhenCorrespondingOptionIsSet.ErrorCode;

/**
 * Autogenerated by XGen on January 1, 0001.
 */
public abstract class CE3_1Error extends CE2Error {

    public static final ErrorCode CODE = new ErrorCode("c-e-3-1", CE2Error.CODE);

    private static String MESSAGE_FORMAT = "Message for E3_1 error.";

    private static String createMessage() {

        return String.format(MESSAGE_FORMAT);
    }

    public static void throwException() throws CE3_1Exception {
        throw new CE3_1Exception(createMessage());
    }

    public static void throwException(Throwable cause) throws CE3_1Exception {
        throw new CE3_1Exception(createMessage(), cause);
    }


}

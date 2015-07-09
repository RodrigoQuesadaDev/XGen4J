package com.rodrigodev.xgen.test.organization.hierarchy.e1.e2.e3_1;

import com.rodrigodev.xgen.test.organization.hierarchy.e1.e2.E2Error;


import com.rodrigodev.xgen.test.organization.hierarchy.ErrorCode;

/**
* Autogenerated by XGen on July 8, 2015.
*/
public abstract class E3_1Error extends E2Error {

    public static final ErrorCode CODE = new ErrorCode("e-3-1", E2Error.CODE);

    private static String MESSAGE_FORMAT = "ABCDE";

    private static String createMessage() {

        return String.format(MESSAGE_FORMAT);
    }

    public static void throwException() {
        throw new E3_1Exception(createMessage());
    }

    public static void throwException(Throwable cause) {
        throw new E3_1Exception(createMessage(), cause);
    }


}

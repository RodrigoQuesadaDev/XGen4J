package com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedWhenSpecified.e1.e2.e3_2;

import com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedWhenSpecified.e1.e2.E2Error;


import com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedWhenSpecified.ErrorCode;

/**
 * Autogenerated by XGen on July 11, 2015.
 */
public abstract class E3_2Error extends E2Error {

    public static final ErrorCode CODE = new ErrorCode("code-name-e3-2", E2Error.CODE);

    private static String MESSAGE_FORMAT = "ABCDE";

    private static String createMessage() {

        return String.format(MESSAGE_FORMAT);
    }

    public static void throwException() {
        throw new E3_2Exception(createMessage());
    }

    public static void throwException(Throwable cause) {
        throw new E3_2Exception(createMessage(), cause);
    }


}

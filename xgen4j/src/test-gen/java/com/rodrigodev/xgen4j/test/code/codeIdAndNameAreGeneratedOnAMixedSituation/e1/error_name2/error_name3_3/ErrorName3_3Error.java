package com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.e1.error_name2.error_name3_3;

import com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.e1.error_name2.ErrorName2Error;


import com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.ErrorCode;

/**
 * Autogenerated by XGen on January 1, 0001.
 */
public abstract class ErrorName3_3Error extends ErrorName2Error {

    public static final ErrorCode CODE = new ErrorCode("error-name-3-3", ErrorName2Error.CODE);

    private static String MESSAGE_FORMAT = "ABCDE";

    private static String createMessage() {

        return String.format(MESSAGE_FORMAT);
    }

    public static void throwException() {
        throw new ErrorName3_3Exception(createMessage());
    }

    public static void throwException(Throwable cause) {
        throw new ErrorName3_3Exception(createMessage(), cause);
    }


}

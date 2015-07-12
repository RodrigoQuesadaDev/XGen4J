package com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified.error_name1.error_name2.error_name3_1;

import com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified.error_name1.error_name2.ErrorName2Error;


import com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified.ErrorCode;

/**
 * Autogenerated by XGen on July 12, 2015.
 */
public abstract class ErrorName3_1Error extends ErrorName2Error {

    public static final ErrorCode CODE = new ErrorCode("error-name-3-1", ErrorName2Error.CODE);

    private static String MESSAGE_FORMAT = "ABCDE";

    private static String createMessage() {

        return String.format(MESSAGE_FORMAT);
    }

    public static void throwException() {
        throw new ErrorName3_1Exception(createMessage());
    }

    public static void throwException(Throwable cause) {
        throw new ErrorName3_1Exception(createMessage(), cause);
    }


}

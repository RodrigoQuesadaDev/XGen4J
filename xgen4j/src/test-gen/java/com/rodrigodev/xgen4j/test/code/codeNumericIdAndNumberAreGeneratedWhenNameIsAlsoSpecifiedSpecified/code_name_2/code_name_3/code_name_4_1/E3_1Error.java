package com.rodrigodev.xgen4j.test.code.codeNumericIdAndNumberAreGeneratedWhenNameIsAlsoSpecifiedSpecified.code_name_2.code_name_3.code_name_4_1;

import com.rodrigodev.xgen4j.test.code.codeNumericIdAndNumberAreGeneratedWhenNameIsAlsoSpecifiedSpecified.code_name_2.code_name_3.E2Error;


import com.rodrigodev.xgen4j.test.code.codeNumericIdAndNumberAreGeneratedWhenNameIsAlsoSpecifiedSpecified.ErrorCode;

/**
 * Autogenerated by XGen4J on January 1, 0001.
 */
public abstract class E3_1Error extends E2Error {

    public static final ErrorCode CODE = new ErrorCode("code-name-4-1", 456, E2Error.CODE);

    private static String MESSAGE_FORMAT = "ABCDE";

    private static String createMessage() {

        return String.format(MESSAGE_FORMAT);
    }

    public static void throwException() {
        throw new E3_1Exception(CODE, createMessage());
    }

    public static void throwException(Throwable cause) {
        throw new E3_1Exception(CODE, createMessage(), cause);
    }


}
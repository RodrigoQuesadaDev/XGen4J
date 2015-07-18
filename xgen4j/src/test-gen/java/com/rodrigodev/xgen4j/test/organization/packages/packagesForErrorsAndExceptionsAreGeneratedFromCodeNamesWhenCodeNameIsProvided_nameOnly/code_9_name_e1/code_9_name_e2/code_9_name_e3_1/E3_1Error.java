package com.rodrigodev.xgen4j.test.organization.packages.packagesForErrorsAndExceptionsAreGeneratedFromCodeNamesWhenCodeNameIsProvided_nameOnly.code_9_name_e1.code_9_name_e2.code_9_name_e3_1;

import com.rodrigodev.xgen4j.test.organization.packages.packagesForErrorsAndExceptionsAreGeneratedFromCodeNamesWhenCodeNameIsProvided_nameOnly.code_9_name_e1.code_9_name_e2.E2Error;


import com.rodrigodev.xgen4j.test.organization.packages.packagesForErrorsAndExceptionsAreGeneratedFromCodeNamesWhenCodeNameIsProvided_nameOnly.ErrorCode;

/**
 * Autogenerated by XGen4J on January 1, 0001.
 */
public abstract class E3_1Error extends E2Error {

    public static final ErrorCode CODE = new ErrorCode("code-9-name-e3-1", E2Error.CODE);

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

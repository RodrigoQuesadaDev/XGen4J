package com.rodrigodev.xgen4j.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames.error9_name1.error9_name2.error9_name3_2;

import com.rodrigodev.xgen4j.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames.error9_name1.error9_name2.Error9Name2Error;


import com.rodrigodev.xgen4j.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames.ErrorCode;

/**
 * Autogenerated by XGen4J on January 1, 0001.
 */
public abstract class Error9Name3_2Error extends Error9Name2Error {

    public static final ErrorCode CODE = new ErrorCode("error-9-name-3-2", Error9Name2Error.CODE);

    private static String MESSAGE_FORMAT = "ABCDE";

    private static String createMessage() {

        return String.format(MESSAGE_FORMAT);
    }

    public static void throwException() {
        throw new Error9Name3_2Exception(CODE, createMessage());
    }

    public static void throwException(Throwable cause) {
        throw new Error9Name3_2Exception(CODE, createMessage(), cause);
    }


}

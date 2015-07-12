package com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.c1.common_name2.common_name3_1;

import com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.c1.common_name2.CommonName2Error;


import com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.ErrorCode;
import com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.RootNameException.ExceptionType;

/**
 * Autogenerated by XGen on July 12, 2015.
 */
public abstract class CommonName3_1Error extends CommonName2Error {

    public static final ErrorCode CODE = new ErrorCode("common-name-3-1", CommonName2Error.CODE);

    private static String MESSAGE_FORMAT = "ABCDE";

    private static String createMessage() {

        return String.format(MESSAGE_FORMAT);
    }

    public static void throwException() {
        throw new CommonName3_1Exception(createMessage());
    }

    public static void throwException(Throwable cause) {
        throw new CommonName3_1Exception(createMessage(), cause);
    }

    public static void throwException(ExceptionType exceptionType) {
        throwExceptionForCommonError(exceptionType, createMessage());
    }

    public static void throwException(ExceptionType exceptionType, Throwable cause) {
        throwExceptionForCommonError(exceptionType, createMessage(), cause);
    }

}

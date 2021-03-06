package com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.code_name_c1.common_name2.common_name3_3;

import com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.code_name_c1.common_name2.CommonName2Error;


import com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.ErrorCode;
import com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.RootNameException;
import com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.RootNameException.ExceptionType;

/**
 * Autogenerated by XGen4J on January 1, 0001.
 */
public abstract class CommonName3_3Error extends CommonName2Error {

    public static final ErrorCode CODE = new ErrorCode("common-name-3-3", CommonName2Error.CODE);

    private static String MESSAGE_FORMAT = "ABCDE";

    private static String createMessage() {

        return String.format(MESSAGE_FORMAT);
    }

    public static void throwException() {
        throw new CommonName3_3Exception(CODE, createMessage());
    }

    public static void throwException(Throwable cause) {
        throw new CommonName3_3Exception(CODE, createMessage(), cause);
    }

    public static void throwException(ExceptionType exceptionType) {
        throwExceptionForCommonError(CODE, exceptionType, createMessage());
    }

    public static void throwException(ExceptionType exceptionType, Throwable cause) {
        throwExceptionForCommonError(CODE, exceptionType, createMessage(), cause);
    }

}

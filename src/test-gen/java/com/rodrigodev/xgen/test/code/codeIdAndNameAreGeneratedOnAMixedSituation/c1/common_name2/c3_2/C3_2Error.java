package com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.c1.common_name2.c3_2;

import com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.c1.common_name2.CommonName2Error;


import com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.ErrorCode;
import com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.RootNameException.ExceptionType;

/**
* Autogenerated by XGen on July 8, 2015.
*/
public abstract class C3_2Error extends CommonName2Error {

    public static final ErrorCode CODE = new ErrorCode("code-name-c3-2", CommonName2Error.CODE);

    private static String MESSAGE_FORMAT = "ABCDE";

    private static String createMessage() {

        return String.format(MESSAGE_FORMAT);
    }

    public static void throwException() {
        throw new C3_2Exception(createMessage());
    }

    public static void throwException(Throwable cause) {
        throw new C3_2Exception(createMessage(), cause);
    }

    public static void throwException(ExceptionType exceptionType) {
        throwExceptionForCommonError(exceptionType, createMessage());
    }

    public static void throwException(ExceptionType exceptionType, Throwable cause) {
        throwExceptionForCommonError(exceptionType, createMessage(), cause);
    }

}

package com.rodrigodev.xgen.test.code.codeNumericIdAndNumberAreGeneratedWhenSpecified.c1.c2.c3_2;

import com.rodrigodev.xgen.test.code.codeNumericIdAndNumberAreGeneratedWhenSpecified.c1.c2.C2Error;


import com.rodrigodev.xgen.test.code.codeNumericIdAndNumberAreGeneratedWhenSpecified.ErrorCode;
import com.rodrigodev.xgen.test.code.codeNumericIdAndNumberAreGeneratedWhenSpecified.RootException.ExceptionType;

/**
* Autogenerated by XGen on July 8, 2015.
*/
public abstract class C3_2Error extends C2Error {

    public static final ErrorCode CODE = new ErrorCode("c-3-2", 567, C2Error.CODE);

    private static String MESSAGE_FORMAT = "ABCDE";

    private static String createMessage() {
        return String.format(MESSAGE_FORMAT);
    }

    public static void throwException() {

        throw new C3_2Exception(createMessage());
    }

    public static void throwException(ExceptionType exceptionType) {

        throwExceptionForCommonError(exceptionType, createMessage());
    }

}

package com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedWhenSpecified.c1.c2.c3_1;

import com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedWhenSpecified.c1.c2.C2Error;


import com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedWhenSpecified.ErrorCode;
import com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedWhenSpecified.RootException;
import com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedWhenSpecified.RootException.ExceptionType;

/**
 * Autogenerated by XGen on January 1, 0001.
 */
public abstract class C3_1Error extends C2Error {

    public static final ErrorCode CODE = new ErrorCode("code-name-c3-1", C2Error.CODE);

    private static String MESSAGE_FORMAT = "ABCDE";

    private static String createMessage() {

        return String.format(MESSAGE_FORMAT);
    }

    public static void throwException() {
        throw new C3_1Exception(createMessage());
    }

    public static void throwException(Throwable cause) {
        throw new C3_1Exception(createMessage(), cause);
    }

    public static void throwException(ExceptionType exceptionType) {
        throwExceptionForCommonError(exceptionType, createMessage());
    }

    public static void throwException(ExceptionType exceptionType, Throwable cause) {
        throwExceptionForCommonError(exceptionType, createMessage(), cause);
    }

}

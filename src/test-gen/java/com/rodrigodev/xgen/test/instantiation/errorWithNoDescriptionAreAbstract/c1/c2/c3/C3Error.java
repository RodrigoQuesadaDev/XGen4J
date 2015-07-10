package com.rodrigodev.xgen.test.instantiation.errorWithNoDescriptionAreAbstract.c1.c2.c3;

import com.rodrigodev.xgen.test.instantiation.errorWithNoDescriptionAreAbstract.c1.c2.C2Error;


import com.rodrigodev.xgen.test.instantiation.errorWithNoDescriptionAreAbstract.ErrorCode;
import com.rodrigodev.xgen.test.instantiation.errorWithNoDescriptionAreAbstract.RootException.ExceptionType;

/**
 * Autogenerated by XGen on July 11, 2015.
 */
public abstract class C3Error extends C2Error {

    public static final ErrorCode CODE = new ErrorCode("c-3", C2Error.CODE);

    private static String MESSAGE_FORMAT = "ABCDE";

    private static String createMessage() {

        return String.format(MESSAGE_FORMAT);
    }

    public static void throwException() {
        throw new C3Exception(createMessage());
    }

    public static void throwException(Throwable cause) {
        throw new C3Exception(createMessage(), cause);
    }

    public static void throwException(ExceptionType exceptionType) {
        throwExceptionForCommonError(exceptionType, createMessage());
    }

    public static void throwException(ExceptionType exceptionType, Throwable cause) {
        throwExceptionForCommonError(exceptionType, createMessage(), cause);
    }

}

package com.rodrigodev.xgen4j.test.info_generation.regularTest.c1.c2.c3_1;

import com.rodrigodev.xgen4j.test.info_generation.regularTest.c1.c2.C2Error;


import com.rodrigodev.xgen4j.test.info_generation.regularTest.ErrorCode;
import com.rodrigodev.xgen4j.test.info_generation.regularTest.RootException;
import com.rodrigodev.xgen4j.test.info_generation.regularTest.RootException.ExceptionType;

/**
 * Autogenerated by XGen4J on January 1, 0001.
 */
public abstract class C3_1Error extends C2Error {

    public static final ErrorCode CODE = new ErrorCode("c-3-1", 456, C2Error.CODE);

    private static String MESSAGE_FORMAT = "Message for C3_1 error.";

    private static String createMessage() {

        return String.format(MESSAGE_FORMAT);
    }

    public static void throwException() {
        throw new C3_1Exception(CODE, createMessage());
    }

    public static void throwException(Throwable cause) {
        throw new C3_1Exception(CODE, createMessage(), cause);
    }

    public static void throwException(ExceptionType exceptionType) {
        throwExceptionForCommonError(CODE, exceptionType, createMessage());
    }

    public static void throwException(ExceptionType exceptionType, Throwable cause) {
        throwExceptionForCommonError(CODE, exceptionType, createMessage(), cause);
    }

}

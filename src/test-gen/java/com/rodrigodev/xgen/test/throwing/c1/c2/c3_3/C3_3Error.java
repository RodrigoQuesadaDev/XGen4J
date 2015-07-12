package com.rodrigodev.xgen.test.throwing.c1.c2.c3_3;

import com.rodrigodev.xgen.test.throwing.c1.c2.C2Error;

import com.rodrigodev.xgen.test.common.doubles.error.message.TestMessageGeneratorObject;

import com.rodrigodev.xgen.test.throwing.ErrorCode;
import com.rodrigodev.xgen.test.throwing.RootException;
import com.rodrigodev.xgen.test.throwing.RootException.ExceptionType;

/**
 * Autogenerated by XGen on July 12, 2015.
 */
public abstract class C3_3Error extends C2Error {

    public static final ErrorCode CODE = new ErrorCode("c-3-3", C2Error.CODE);

    private static String createMessage(TestMessageGeneratorObject generator) {
        if(generator == null) throw new NullPointerException("generator");

        return generator.message();
    }

    public static void throwException(TestMessageGeneratorObject generator) {
        throw new C3_3Exception(createMessage(generator));
    }

    public static void throwException(TestMessageGeneratorObject generator, Throwable cause) {
        throw new C3_3Exception(createMessage(generator), cause);
    }

    public static void throwException(ExceptionType exceptionType, TestMessageGeneratorObject generator) {
        throwExceptionForCommonError(exceptionType, createMessage(generator));
    }

    public static void throwException(ExceptionType exceptionType, TestMessageGeneratorObject generator, Throwable cause) {
        throwExceptionForCommonError(exceptionType, createMessage(generator), cause);
    }

}

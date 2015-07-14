package com.rodrigodev.xgen4j.test.info_generation.c1.c2.c3_3;

import com.rodrigodev.xgen4j.test.info_generation.c1.c2.C2Error;

import com.rodrigodev.xgen4j.test.info_generation.InfoGenerationTests.TestMessageGeneratorObject1;

import com.rodrigodev.xgen4j.test.info_generation.ErrorCode;
import com.rodrigodev.xgen4j.test.info_generation.RootException;
import com.rodrigodev.xgen4j.test.info_generation.RootException.ExceptionType;

/**
 * Autogenerated by XGen on January 1, 0001.
 */
public abstract class C3_3Error extends C2Error {

    public static final ErrorCode CODE = new ErrorCode("c-3-3", C2Error.CODE);

    private static String createMessage(TestMessageGeneratorObject1 generator) {
        if(generator == null) throw new NullPointerException("generator");

        return generator.message();
    }

    public static void throwException(TestMessageGeneratorObject1 generator) {
        throw new C3_3Exception(createMessage(generator));
    }

    public static void throwException(TestMessageGeneratorObject1 generator, Throwable cause) {
        throw new C3_3Exception(createMessage(generator), cause);
    }

    public static void throwException(ExceptionType exceptionType, TestMessageGeneratorObject1 generator) {
        throwExceptionForCommonError(exceptionType, createMessage(generator));
    }

    public static void throwException(ExceptionType exceptionType, TestMessageGeneratorObject1 generator, Throwable cause) {
        throwExceptionForCommonError(exceptionType, createMessage(generator), cause);
    }

}

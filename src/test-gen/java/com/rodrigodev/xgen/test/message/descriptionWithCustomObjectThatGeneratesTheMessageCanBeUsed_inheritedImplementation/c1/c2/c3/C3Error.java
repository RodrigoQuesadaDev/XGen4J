package com.rodrigodev.xgen.test.message.descriptionWithCustomObjectThatGeneratesTheMessageCanBeUsed_inheritedImplementation.c1.c2.c3;

import com.rodrigodev.xgen.test.message.descriptionWithCustomObjectThatGeneratesTheMessageCanBeUsed_inheritedImplementation.c1.c2.C2Error;

import com.rodrigodev.xgen.test.message.MessageTests.TestMessageGeneratorObjectChild;

import com.rodrigodev.xgen.test.message.descriptionWithCustomObjectThatGeneratesTheMessageCanBeUsed_inheritedImplementation.ErrorCode;
import com.rodrigodev.xgen.test.message.descriptionWithCustomObjectThatGeneratesTheMessageCanBeUsed_inheritedImplementation.RootException.ExceptionType;

/**
 * Autogenerated by XGen on July 11, 2015.
 */
public abstract class C3Error extends C2Error {

    public static final ErrorCode CODE = new ErrorCode("c-3", C2Error.CODE);

    private static String createMessage(TestMessageGeneratorObjectChild generator) {
        if(generator == null) throw new NullPointerException("generator");

        return generator.message();
    }

    public static void throwException(TestMessageGeneratorObjectChild generator) {
        throw new C3Exception(createMessage(generator));
    }

    public static void throwException(TestMessageGeneratorObjectChild generator, Throwable cause) {
        throw new C3Exception(createMessage(generator), cause);
    }

    public static void throwException(ExceptionType exceptionType, TestMessageGeneratorObjectChild generator) {
        throwExceptionForCommonError(exceptionType, createMessage(generator));
    }

    public static void throwException(ExceptionType exceptionType, TestMessageGeneratorObjectChild generator, Throwable cause) {
        throwExceptionForCommonError(exceptionType, createMessage(generator), cause);
    }

}
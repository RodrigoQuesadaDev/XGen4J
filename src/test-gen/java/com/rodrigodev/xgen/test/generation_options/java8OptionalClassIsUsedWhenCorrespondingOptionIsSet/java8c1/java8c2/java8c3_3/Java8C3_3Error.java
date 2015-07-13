package com.rodrigodev.xgen.test.generation_options.java8OptionalClassIsUsedWhenCorrespondingOptionIsSet.java8c1.java8c2.java8c3_3;

import com.rodrigodev.xgen.test.generation_options.java8OptionalClassIsUsedWhenCorrespondingOptionIsSet.java8c1.java8c2.Java8C2Error;

import com.rodrigodev.xgen.test.common.doubles.error.message.TestMessageGeneratorObject;

import com.rodrigodev.xgen.test.generation_options.java8OptionalClassIsUsedWhenCorrespondingOptionIsSet.ErrorCode;
import com.rodrigodev.xgen.test.generation_options.java8OptionalClassIsUsedWhenCorrespondingOptionIsSet.Java8RootException;
import com.rodrigodev.xgen.test.generation_options.java8OptionalClassIsUsedWhenCorrespondingOptionIsSet.Java8RootException.ExceptionType;

/**
 * Autogenerated by XGen on July 13, 2015.
 */
public abstract class Java8C3_3Error extends Java8C2Error {

    public static final ErrorCode CODE = new ErrorCode("java-8-c-3-3", Java8C2Error.CODE);

    private static String createMessage(TestMessageGeneratorObject generator) {
        if(generator == null) throw new NullPointerException("generator");

        return generator.message();
    }

    public static void throwException(TestMessageGeneratorObject generator) {
        throw new Java8C3_3Exception(createMessage(generator));
    }

    public static void throwException(TestMessageGeneratorObject generator, Throwable cause) {
        throw new Java8C3_3Exception(createMessage(generator), cause);
    }

    public static void throwException(ExceptionType exceptionType, TestMessageGeneratorObject generator) {
        throwExceptionForCommonError(exceptionType, createMessage(generator));
    }

    public static void throwException(ExceptionType exceptionType, TestMessageGeneratorObject generator, Throwable cause) {
        throwExceptionForCommonError(exceptionType, createMessage(generator), cause);
    }

}

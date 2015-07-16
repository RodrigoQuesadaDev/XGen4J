package com.rodrigodev.xgen4j.test.generation_options.java8OptionalClassIsUsedWhenCorrespondingOptionIsSet.java8e1.java8e2.java8e3_3;

import com.rodrigodev.xgen4j.test.generation_options.java8OptionalClassIsUsedWhenCorrespondingOptionIsSet.java8e1.java8e2.Java8E2Error;

import com.rodrigodev.xgen4j.test.common.doubles.error.message.TestMessageGeneratorObject;

import com.rodrigodev.xgen4j.test.generation_options.java8OptionalClassIsUsedWhenCorrespondingOptionIsSet.ErrorCode;

/**
 * Autogenerated by XGen4J on January 1, 0001.
 */
public abstract class Java8E3_3Error extends Java8E2Error {

    public static final ErrorCode CODE = new ErrorCode("java-8-e-3-3", Java8E2Error.CODE);

    private static String createMessage(TestMessageGeneratorObject generator) {
        if(generator == null) throw new NullPointerException("generator");

        return generator.message();
    }

    public static void throwException(TestMessageGeneratorObject generator) {
        throw new Java8E3_3Exception(createMessage(generator));
    }

    public static void throwException(TestMessageGeneratorObject generator, Throwable cause) {
        throw new Java8E3_3Exception(createMessage(generator), cause);
    }


}

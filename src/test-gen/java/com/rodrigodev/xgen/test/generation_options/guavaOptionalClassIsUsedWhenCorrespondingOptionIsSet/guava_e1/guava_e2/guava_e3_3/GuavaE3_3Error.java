package com.rodrigodev.xgen.test.generation_options.guavaOptionalClassIsUsedWhenCorrespondingOptionIsSet.guava_e1.guava_e2.guava_e3_3;

import com.rodrigodev.xgen.test.generation_options.guavaOptionalClassIsUsedWhenCorrespondingOptionIsSet.guava_e1.guava_e2.GuavaE2Error;

import com.rodrigodev.xgen.test.common.doubles.error.message.TestMessageGeneratorObject;

import com.rodrigodev.xgen.test.generation_options.guavaOptionalClassIsUsedWhenCorrespondingOptionIsSet.ErrorCode;

/**
 * Autogenerated by XGen on January 1, 0001.
 */
public abstract class GuavaE3_3Error extends GuavaE2Error {

    public static final ErrorCode CODE = new ErrorCode("guava-e-3-3", GuavaE2Error.CODE);

    private static String createMessage(TestMessageGeneratorObject generator) {
        if(generator == null) throw new NullPointerException("generator");

        return generator.message();
    }

    public static void throwException(TestMessageGeneratorObject generator) {
        throw new GuavaE3_3Exception(createMessage(generator));
    }

    public static void throwException(TestMessageGeneratorObject generator, Throwable cause) {
        throw new GuavaE3_3Exception(createMessage(generator), cause);
    }


}

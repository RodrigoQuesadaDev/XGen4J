package com.rodrigodev.xgen4j.test.info_generation.ea1.ea2.ea3_3;

import com.rodrigodev.xgen4j.test.info_generation.ea1.ea2.EA2Error;

import com.rodrigodev.xgen4j.test.info_generation.InfoGenerationTests.TestMessageGeneratorObject2;

import com.rodrigodev.xgen4j.test.info_generation.ErrorCode;

/**
 * Autogenerated by XGen on January 1, 0001.
 */
public abstract class EA3_3Error extends EA2Error {

    public static final ErrorCode CODE = new ErrorCode("e-a-3-3", EA2Error.CODE);

    private static String createMessage(TestMessageGeneratorObject2 generator) {
        if(generator == null) throw new NullPointerException("generator");

        return generator.message();
    }

    public static void throwException(TestMessageGeneratorObject2 generator) {
        throw new EA3_3Exception(createMessage(generator));
    }

    public static void throwException(TestMessageGeneratorObject2 generator, Throwable cause) {
        throw new EA3_3Exception(createMessage(generator), cause);
    }


}

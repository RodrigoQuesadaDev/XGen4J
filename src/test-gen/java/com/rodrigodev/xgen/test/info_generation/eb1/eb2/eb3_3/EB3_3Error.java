package com.rodrigodev.xgen.test.info_generation.eb1.eb2.eb3_3;

import com.rodrigodev.xgen.test.info_generation.eb1.eb2.EB2Error;

import com.rodrigodev.xgen.test.info_generation.InfoGenerationTests.TestMessageGeneratorObject3;

import com.rodrigodev.xgen.test.info_generation.ErrorCode;

/**
 * Autogenerated by XGen on July 12, 2015.
 */
public abstract class EB3_3Error extends EB2Error {

    public static final ErrorCode CODE = new ErrorCode("e-b-3-3", EB2Error.CODE);

    private static String createMessage(TestMessageGeneratorObject3 generator) {
        if(generator == null) throw new NullPointerException("generator");

        return generator.message();
    }

    public static void throwException(TestMessageGeneratorObject3 generator) {
        throw new EB3_3Exception(createMessage(generator));
    }

    public static void throwException(TestMessageGeneratorObject3 generator, Throwable cause) {
        throw new EB3_3Exception(createMessage(generator), cause);
    }


}

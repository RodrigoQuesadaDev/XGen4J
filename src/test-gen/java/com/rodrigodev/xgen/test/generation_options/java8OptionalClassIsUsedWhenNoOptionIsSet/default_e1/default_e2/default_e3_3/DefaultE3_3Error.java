package com.rodrigodev.xgen.test.generation_options.java8OptionalClassIsUsedWhenNoOptionIsSet.default_e1.default_e2.default_e3_3;

import com.rodrigodev.xgen.test.generation_options.java8OptionalClassIsUsedWhenNoOptionIsSet.default_e1.default_e2.DefaultE2Error;

import com.rodrigodev.xgen.test.common.doubles.error.message.TestMessageGeneratorObject;

import com.rodrigodev.xgen.test.generation_options.java8OptionalClassIsUsedWhenNoOptionIsSet.ErrorCode;

/**
 * Autogenerated by XGen on July 13, 2015.
 */
public abstract class DefaultE3_3Error extends DefaultE2Error {

    public static final ErrorCode CODE = new ErrorCode("default-e-3-3", DefaultE2Error.CODE);

    private static String createMessage(TestMessageGeneratorObject generator) {
        if(generator == null) throw new NullPointerException("generator");

        return generator.message();
    }

    public static void throwException(TestMessageGeneratorObject generator) {
        throw new DefaultE3_3Exception(createMessage(generator));
    }

    public static void throwException(TestMessageGeneratorObject generator, Throwable cause) {
        throw new DefaultE3_3Exception(createMessage(generator), cause);
    }


}

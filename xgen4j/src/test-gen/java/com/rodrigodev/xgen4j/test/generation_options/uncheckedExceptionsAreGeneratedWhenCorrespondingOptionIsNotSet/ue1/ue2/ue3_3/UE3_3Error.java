package com.rodrigodev.xgen4j.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsNotSet.ue1.ue2.ue3_3;

import com.rodrigodev.xgen4j.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsNotSet.ue1.ue2.UE2Error;

import com.rodrigodev.xgen4j.test.common.doubles.error.message.TestMessageGeneratorObject;

import com.rodrigodev.xgen4j.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsNotSet.ErrorCode;

/**
 * Autogenerated by XGen4J on January 1, 0001.
 */
public abstract class UE3_3Error extends UE2Error {

    public static final ErrorCode CODE = new ErrorCode("u-e-3-3", UE2Error.CODE);

    private static String createMessage(TestMessageGeneratorObject generator) {
        if(generator == null) throw new NullPointerException("generator");

        return generator.message();
    }

    public static void throwException(TestMessageGeneratorObject generator) {
        throw new UE3_3Exception(CODE, createMessage(generator));
    }

    public static void throwException(TestMessageGeneratorObject generator, Throwable cause) {
        throw new UE3_3Exception(CODE, createMessage(generator), cause);
    }


}

package com.rodrigodev.xgen.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsSetAsFalse.u2e1.u2e2.u2e3_3;

import com.rodrigodev.xgen.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsSetAsFalse.u2e1.u2e2.U2E2Error;

import com.rodrigodev.xgen.test.common.doubles.error.message.TestMessageGeneratorObject;

import com.rodrigodev.xgen.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsSetAsFalse.ErrorCode;

/**
 * Autogenerated by XGen on July 13, 2015.
 */
public abstract class U2E3_3Error extends U2E2Error {

    public static final ErrorCode CODE = new ErrorCode("u-2-e-3-3", U2E2Error.CODE);

    private static String createMessage(TestMessageGeneratorObject generator) {
        if(generator == null) throw new NullPointerException("generator");

        return generator.message();
    }

    public static void throwException(TestMessageGeneratorObject generator) {
        throw new U2E3_3Exception(createMessage(generator));
    }

    public static void throwException(TestMessageGeneratorObject generator, Throwable cause) {
        throw new U2E3_3Exception(createMessage(generator), cause);
    }


}

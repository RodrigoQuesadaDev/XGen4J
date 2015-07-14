package com.rodrigodev.xgen.test.generation_options.guavaOptionalClassIsUsedWhenCorrespondingOptionIsSet.guava_c1.guava_c2.guava_c3_3;

import com.rodrigodev.xgen.test.generation_options.guavaOptionalClassIsUsedWhenCorrespondingOptionIsSet.guava_c1.guava_c2.GuavaC2Error;

import com.rodrigodev.xgen.test.common.doubles.error.message.TestMessageGeneratorObject;

import com.rodrigodev.xgen.test.generation_options.guavaOptionalClassIsUsedWhenCorrespondingOptionIsSet.ErrorCode;
import com.rodrigodev.xgen.test.generation_options.guavaOptionalClassIsUsedWhenCorrespondingOptionIsSet.GuavaRootException;
import com.rodrigodev.xgen.test.generation_options.guavaOptionalClassIsUsedWhenCorrespondingOptionIsSet.GuavaRootException.ExceptionType;

/**
 * Autogenerated by XGen on January 1, 0001.
 */
public abstract class GuavaC3_3Error extends GuavaC2Error {

    public static final ErrorCode CODE = new ErrorCode("guava-c-3-3", GuavaC2Error.CODE);

    private static String createMessage(TestMessageGeneratorObject generator) {
        if(generator == null) throw new NullPointerException("generator");

        return generator.message();
    }

    public static void throwException(TestMessageGeneratorObject generator) {
        throw new GuavaC3_3Exception(createMessage(generator));
    }

    public static void throwException(TestMessageGeneratorObject generator, Throwable cause) {
        throw new GuavaC3_3Exception(createMessage(generator), cause);
    }

    public static void throwException(ExceptionType exceptionType, TestMessageGeneratorObject generator) {
        throwExceptionForCommonError(exceptionType, createMessage(generator));
    }

    public static void throwException(ExceptionType exceptionType, TestMessageGeneratorObject generator, Throwable cause) {
        throwExceptionForCommonError(exceptionType, createMessage(generator), cause);
    }

}

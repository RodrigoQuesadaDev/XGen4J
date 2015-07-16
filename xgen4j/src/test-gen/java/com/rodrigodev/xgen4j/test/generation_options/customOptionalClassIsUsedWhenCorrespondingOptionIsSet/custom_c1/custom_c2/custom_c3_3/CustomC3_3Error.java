package com.rodrigodev.xgen4j.test.generation_options.customOptionalClassIsUsedWhenCorrespondingOptionIsSet.custom_c1.custom_c2.custom_c3_3;

import com.rodrigodev.xgen4j.test.generation_options.customOptionalClassIsUsedWhenCorrespondingOptionIsSet.custom_c1.custom_c2.CustomC2Error;

import com.rodrigodev.xgen4j.test.common.doubles.error.message.TestMessageGeneratorObject;

import com.rodrigodev.xgen4j.test.generation_options.customOptionalClassIsUsedWhenCorrespondingOptionIsSet.ErrorCode;
import com.rodrigodev.xgen4j.test.generation_options.customOptionalClassIsUsedWhenCorrespondingOptionIsSet.CustomRootException;
import com.rodrigodev.xgen4j.test.generation_options.customOptionalClassIsUsedWhenCorrespondingOptionIsSet.CustomRootException.ExceptionType;

/**
 * Autogenerated by XGen on January 1, 0001.
 */
public abstract class CustomC3_3Error extends CustomC2Error {

    public static final ErrorCode CODE = new ErrorCode("custom-c-3-3", CustomC2Error.CODE);

    private static String createMessage(TestMessageGeneratorObject generator) {
        if(generator == null) throw new NullPointerException("generator");

        return generator.message();
    }

    public static void throwException(TestMessageGeneratorObject generator) {
        throw new CustomC3_3Exception(createMessage(generator));
    }

    public static void throwException(TestMessageGeneratorObject generator, Throwable cause) {
        throw new CustomC3_3Exception(createMessage(generator), cause);
    }

    public static void throwException(ExceptionType exceptionType, TestMessageGeneratorObject generator) {
        throwExceptionForCommonError(exceptionType, createMessage(generator));
    }

    public static void throwException(ExceptionType exceptionType, TestMessageGeneratorObject generator, Throwable cause) {
        throwExceptionForCommonError(exceptionType, createMessage(generator), cause);
    }

}
package com.rodrigodev.xgen4j.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsNotSet.uc1.uc2.uc3_3;

import com.rodrigodev.xgen4j.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsNotSet.uc1.uc2.UC2Error;

import com.rodrigodev.xgen4j.test.common.doubles.error.message.TestMessageGeneratorObject;

import com.rodrigodev.xgen4j.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsNotSet.ErrorCode;
import com.rodrigodev.xgen4j.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsNotSet.URootException;
import com.rodrigodev.xgen4j.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsNotSet.URootException.ExceptionType;

/**
 * Autogenerated by XGen4J on January 1, 0001.
 */
public abstract class UC3_3Error extends UC2Error {

    public static final ErrorCode CODE = new ErrorCode("u-c-3-3", UC2Error.CODE);

    private static String createMessage(TestMessageGeneratorObject generator) {
        if(generator == null) throw new NullPointerException("generator");

        return generator.message();
    }

    public static void throwException(TestMessageGeneratorObject generator) {
        throw new UC3_3Exception(CODE, createMessage(generator));
    }

    public static void throwException(TestMessageGeneratorObject generator, Throwable cause) {
        throw new UC3_3Exception(CODE, createMessage(generator), cause);
    }

    public static void throwException(ExceptionType exceptionType, TestMessageGeneratorObject generator) {
        throwExceptionForCommonError(CODE, exceptionType, createMessage(generator));
    }

    public static void throwException(ExceptionType exceptionType, TestMessageGeneratorObject generator, Throwable cause) {
        throwExceptionForCommonError(CODE, exceptionType, createMessage(generator), cause);
    }

}

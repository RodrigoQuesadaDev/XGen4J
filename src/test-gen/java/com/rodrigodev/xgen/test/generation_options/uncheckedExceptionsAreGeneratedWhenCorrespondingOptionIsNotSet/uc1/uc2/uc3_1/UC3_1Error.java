package com.rodrigodev.xgen.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsNotSet.uc1.uc2.uc3_1;

import com.rodrigodev.xgen.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsNotSet.uc1.uc2.UC2Error;


import com.rodrigodev.xgen.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsNotSet.ErrorCode;
import com.rodrigodev.xgen.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsNotSet.URootException;
import com.rodrigodev.xgen.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsNotSet.URootException.ExceptionType;

/**
 * Autogenerated by XGen on January 1, 0001.
 */
public abstract class UC3_1Error extends UC2Error {

    public static final ErrorCode CODE = new ErrorCode("u-c-3-1", UC2Error.CODE);

    private static String MESSAGE_FORMAT = "Message for C3_1 error.";

    private static String createMessage() {

        return String.format(MESSAGE_FORMAT);
    }

    public static void throwException() {
        throw new UC3_1Exception(createMessage());
    }

    public static void throwException(Throwable cause) {
        throw new UC3_1Exception(createMessage(), cause);
    }

    public static void throwException(ExceptionType exceptionType) {
        throwExceptionForCommonError(exceptionType, createMessage());
    }

    public static void throwException(ExceptionType exceptionType, Throwable cause) {
        throwExceptionForCommonError(exceptionType, createMessage(), cause);
    }

}

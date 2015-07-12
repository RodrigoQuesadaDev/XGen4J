package com.rodrigodev.xgen.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsNotSet.uc1.uc2.uc3_2;

import com.rodrigodev.xgen.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsNotSet.uc1.uc2.UC2Error;

import java.lang.String;
import java.lang.Integer;
import com.rodrigodev.xgen.test.common.doubles.error.message.TestObject;

import com.rodrigodev.xgen.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsNotSet.ErrorCode;
import com.rodrigodev.xgen.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsNotSet.URootException;
import com.rodrigodev.xgen.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsNotSet.URootException.ExceptionType;

/**
 * Autogenerated by XGen on July 12, 2015.
 */
public abstract class UC3_2Error extends UC2Error {

    public static final ErrorCode CODE = new ErrorCode("u-c-3-2", UC2Error.CODE);

    private static String MESSAGE_FORMAT = "{param1: '%s', param2: %d, param3: '%s'}";

    private static String createMessage(String param1, Integer param2, TestObject param3) {
        if(param1 == null) throw new NullPointerException("param1");
        if(param2 == null) throw new NullPointerException("param2");
        if(param3 == null) throw new NullPointerException("param3");

        return String.format(MESSAGE_FORMAT, param1, param2, param3);
    }

    public static void throwException(String param1, Integer param2, TestObject param3) {
        throw new UC3_2Exception(createMessage(param1, param2, param3));
    }

    public static void throwException(String param1, Integer param2, TestObject param3, Throwable cause) {
        throw new UC3_2Exception(createMessage(param1, param2, param3), cause);
    }

    public static void throwException(ExceptionType exceptionType, String param1, Integer param2, TestObject param3) {
        throwExceptionForCommonError(exceptionType, createMessage(param1, param2, param3));
    }

    public static void throwException(ExceptionType exceptionType, String param1, Integer param2, TestObject param3, Throwable cause) {
        throwExceptionForCommonError(exceptionType, createMessage(param1, param2, param3), cause);
    }

}

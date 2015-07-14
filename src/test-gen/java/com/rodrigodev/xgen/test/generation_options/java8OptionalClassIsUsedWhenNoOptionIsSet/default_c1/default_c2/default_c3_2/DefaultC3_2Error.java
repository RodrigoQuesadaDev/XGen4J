package com.rodrigodev.xgen.test.generation_options.java8OptionalClassIsUsedWhenNoOptionIsSet.default_c1.default_c2.default_c3_2;

import com.rodrigodev.xgen.test.generation_options.java8OptionalClassIsUsedWhenNoOptionIsSet.default_c1.default_c2.DefaultC2Error;

import java.lang.String;
import java.lang.Integer;
import com.rodrigodev.xgen.test.common.doubles.error.message.TestObject;

import com.rodrigodev.xgen.test.generation_options.java8OptionalClassIsUsedWhenNoOptionIsSet.ErrorCode;
import com.rodrigodev.xgen.test.generation_options.java8OptionalClassIsUsedWhenNoOptionIsSet.DefaultRootException;
import com.rodrigodev.xgen.test.generation_options.java8OptionalClassIsUsedWhenNoOptionIsSet.DefaultRootException.ExceptionType;

/**
 * Autogenerated by XGen on January 1, 0001.
 */
public abstract class DefaultC3_2Error extends DefaultC2Error {

    public static final ErrorCode CODE = new ErrorCode("default-c-3-2", DefaultC2Error.CODE);

    private static String MESSAGE_FORMAT = "{param1: '%s', param2: %d, param3: '%s'}";

    private static String createMessage(String param1, Integer param2, TestObject param3) {
        if(param1 == null) throw new NullPointerException("param1");
        if(param2 == null) throw new NullPointerException("param2");
        if(param3 == null) throw new NullPointerException("param3");

        return String.format(MESSAGE_FORMAT, param1, param2, param3);
    }

    public static void throwException(String param1, Integer param2, TestObject param3) {
        throw new DefaultC3_2Exception(createMessage(param1, param2, param3));
    }

    public static void throwException(String param1, Integer param2, TestObject param3, Throwable cause) {
        throw new DefaultC3_2Exception(createMessage(param1, param2, param3), cause);
    }

    public static void throwException(ExceptionType exceptionType, String param1, Integer param2, TestObject param3) {
        throwExceptionForCommonError(exceptionType, createMessage(param1, param2, param3));
    }

    public static void throwException(ExceptionType exceptionType, String param1, Integer param2, TestObject param3, Throwable cause) {
        throwExceptionForCommonError(exceptionType, createMessage(param1, param2, param3), cause);
    }

}

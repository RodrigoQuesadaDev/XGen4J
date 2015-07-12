package com.rodrigodev.xgen.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsNotSet.ue1.ue2.ue3_2;

import com.rodrigodev.xgen.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsNotSet.ue1.ue2.UE2Error;

import java.lang.String;
import java.lang.Integer;
import com.rodrigodev.xgen.test.common.doubles.error.message.TestObject;

import com.rodrigodev.xgen.test.generation_options.uncheckedExceptionsAreGeneratedWhenCorrespondingOptionIsNotSet.ErrorCode;

/**
 * Autogenerated by XGen on July 12, 2015.
 */
public abstract class UE3_2Error extends UE2Error {

    public static final ErrorCode CODE = new ErrorCode("u-e-3-2", UE2Error.CODE);

    private static String MESSAGE_FORMAT = "{param1: '%s', param2: %d, param3: '%s'}";

    private static String createMessage(String param1, Integer param2, TestObject param3) {
        if(param1 == null) throw new NullPointerException("param1");
        if(param2 == null) throw new NullPointerException("param2");
        if(param3 == null) throw new NullPointerException("param3");

        return String.format(MESSAGE_FORMAT, param1, param2, param3);
    }

    public static void throwException(String param1, Integer param2, TestObject param3) {
        throw new UE3_2Exception(createMessage(param1, param2, param3));
    }

    public static void throwException(String param1, Integer param2, TestObject param3, Throwable cause) {
        throw new UE3_2Exception(createMessage(param1, param2, param3), cause);
    }


}
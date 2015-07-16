package com.rodrigodev.xgen4j.test.info_generation.regularTest.eb1.eb2.eb3_2;

import com.rodrigodev.xgen4j.test.info_generation.regularTest.eb1.eb2.EB2Error;

import java.lang.String;
import java.lang.Integer;
import com.rodrigodev.xgen4j.test.common.doubles.error.message.TestObject;

import com.rodrigodev.xgen4j.test.info_generation.regularTest.ErrorCode;

/**
 * Autogenerated by XGen4J on January 1, 0001.
 */
public abstract class EB3_2Error extends EB2Error {

    public static final ErrorCode CODE = new ErrorCode("e-b-3-2", 7890, EB2Error.CODE);

    private static String MESSAGE_FORMAT = "EB3_2: {param1: '%s', param2: %d, param3: '%s'}";

    private static String createMessage(String param1, Integer param2, TestObject param3) {
        if(param1 == null) throw new NullPointerException("param1");
        if(param2 == null) throw new NullPointerException("param2");
        if(param3 == null) throw new NullPointerException("param3");

        return String.format(MESSAGE_FORMAT, param1, param2, param3);
    }

    public static void throwException(String param1, Integer param2, TestObject param3) {
        throw new EB3_2Exception(createMessage(param1, param2, param3));
    }

    public static void throwException(String param1, Integer param2, TestObject param3, Throwable cause) {
        throw new EB3_2Exception(createMessage(param1, param2, param3), cause);
    }


}

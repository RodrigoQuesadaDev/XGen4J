package com.rodrigodev.xgen.test.throwing.e1.e2.e3_2;

import com.rodrigodev.xgen.test.throwing.e1.e2.E2Error;

import java.lang.String;
import java.lang.Integer;
import com.rodrigodev.xgen.test.throwing.ThrowTests.TestObject;

import com.rodrigodev.xgen.test.throwing.ErrorCode;

/**
* Autogenerated by XGen on July 8, 2015.
*/
public abstract class E3_2Error extends E2Error {

    public static final ErrorCode CODE = new ErrorCode("e-3-2", E2Error.CODE);

    private static String MESSAGE_FORMAT = "{param1: '%s', param2: %d, param3: '%s'}";

    private static String createMessage(String param1, Integer param2, TestObject param3) {
        if(param1 == null) throw new NullPointerException("param1");
        if(param2 == null) throw new NullPointerException("param2");
        if(param3 == null) throw new NullPointerException("param3");

        return String.format(MESSAGE_FORMAT, param1, param2, param3);
    }

    public static void throwException(String param1, Integer param2, TestObject param3) {
        throw new E3_2Exception(createMessage(param1, param2, param3));
    }

    public static void throwException(String param1, Integer param2, TestObject param3, Throwable cause) {
        throw new E3_2Exception(createMessage(param1, param2, param3), cause);
    }


}

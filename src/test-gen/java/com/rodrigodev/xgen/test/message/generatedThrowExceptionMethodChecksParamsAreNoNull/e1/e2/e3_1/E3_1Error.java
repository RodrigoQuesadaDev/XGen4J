package com.rodrigodev.xgen.test.message.generatedThrowExceptionMethodChecksParamsAreNoNull.e1.e2.e3_1;

import com.rodrigodev.xgen.test.message.generatedThrowExceptionMethodChecksParamsAreNoNull.e1.e2.E2Error;

import java.lang.String;
import java.lang.Double;
import com.rodrigodev.xgen.test.message.MessageTests.TestObject;

import com.rodrigodev.xgen.test.message.generatedThrowExceptionMethodChecksParamsAreNoNull.ErrorCode;

/**
* Autogenerated by XGen on July 4, 2015.
*/
public abstract class E3_1Error extends E2Error {

    public static final ErrorCode CODE = new ErrorCode("e-3-1", E2Error.CODE);

    private static String MESSAGE_FORMAT = "{param1: '%s', param2: %.3f, param3: '%s'}";

    private static String createMessage(String param1, Double param2, TestObject param3) {
        return String.format(MESSAGE_FORMAT, param1, param2, param3);
    }

    public static void throwException(String param1, Double param2, TestObject param3) {
        if(param1 == null) throw new NullPointerException("param1");
        if(param2 == null) throw new NullPointerException("param2");
        if(param3 == null) throw new NullPointerException("param3");

        throw new E3_1Exception(createMessage(param1, param2, param3));
    }


}

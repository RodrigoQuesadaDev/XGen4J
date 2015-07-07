package com.rodrigodev.xgen.test.throwing.c1.c2.c3_2;

import com.rodrigodev.xgen.test.throwing.c1.c2.C2Error;

import java.lang.String;
import java.lang.Integer;
import com.rodrigodev.xgen.test.throwing.ThrowTests.TestObject;

import com.rodrigodev.xgen.test.throwing.ErrorCode;
import com.rodrigodev.xgen.test.throwing.RootException.ExceptionType;

/**
* Autogenerated by XGen on July 6, 2015.
*/
public abstract class C3_2Error extends C2Error {

    public static final ErrorCode CODE = new ErrorCode("c-3-2", C2Error.CODE);

    private static String MESSAGE_FORMAT = "{param1: '%s', param2: %d, param3: '%s'}";

    private static String createMessage(String param1, Integer param2, TestObject param3) {
        return String.format(MESSAGE_FORMAT, param1, param2, param3);
    }

    public static void throwException(String param1, Integer param2, TestObject param3) {
        if(param1 == null) throw new NullPointerException("param1");
        if(param2 == null) throw new NullPointerException("param2");
        if(param3 == null) throw new NullPointerException("param3");

        throw new C3_2Exception(createMessage(param1, param2, param3));
    }

    public static void throwException(ExceptionType exceptionType, String param1, Integer param2, TestObject param3) {
        if(param1 == null) throw new NullPointerException("param1");
        if(param2 == null) throw new NullPointerException("param2");
        if(param3 == null) throw new NullPointerException("param3");

        throwExceptionForCommonError(exceptionType, createMessage(param1, param2, param3));
    }

}
package com.rodrigodev.xgen.test.message.generatedThrowExceptionMethodChecksParamsAreNoNull.e1.e2.e3_2;

import com.rodrigodev.xgen.test.message.generatedThrowExceptionMethodChecksParamsAreNoNull.e1.e2.E2Error;

import com.rodrigodev.xgen.test.message.MessageTests.TestMessageGeneratorObject;

import com.rodrigodev.xgen.test.message.generatedThrowExceptionMethodChecksParamsAreNoNull.ErrorCode;

/**
* Autogenerated by XGen on July 6, 2015.
*/
public abstract class E3_2Error extends E2Error {

    public static final ErrorCode CODE = new ErrorCode("e-3-2", E2Error.CODE);

    private static String createMessage(TestMessageGeneratorObject generator) {
        return generator.message();
    }

    public static void throwException(TestMessageGeneratorObject generator) {
        if(generator == null) throw new NullPointerException("generator");

        throw new E3_2Exception(createMessage(generator));
    }


}

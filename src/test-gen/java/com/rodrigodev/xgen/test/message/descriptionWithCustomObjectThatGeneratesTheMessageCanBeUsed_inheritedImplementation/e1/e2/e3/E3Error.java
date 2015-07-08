package com.rodrigodev.xgen.test.message.descriptionWithCustomObjectThatGeneratesTheMessageCanBeUsed_inheritedImplementation.e1.e2.e3;

import com.rodrigodev.xgen.test.message.descriptionWithCustomObjectThatGeneratesTheMessageCanBeUsed_inheritedImplementation.e1.e2.E2Error;

import com.rodrigodev.xgen.test.message.MessageTests.TestMessageGeneratorObjectChild;

import com.rodrigodev.xgen.test.message.descriptionWithCustomObjectThatGeneratesTheMessageCanBeUsed_inheritedImplementation.ErrorCode;

/**
* Autogenerated by XGen on July 8, 2015.
*/
public abstract class E3Error extends E2Error {

    public static final ErrorCode CODE = new ErrorCode("e-3", E2Error.CODE);

    private static String createMessage(TestMessageGeneratorObjectChild generator) {
        return generator.message();
    }

    public static void throwException(TestMessageGeneratorObjectChild generator) {
        if(generator == null) throw new NullPointerException("generator");

        throw new E3Exception(createMessage(generator));
    }


}

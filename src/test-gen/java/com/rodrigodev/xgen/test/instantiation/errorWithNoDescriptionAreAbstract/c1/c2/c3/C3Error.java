package com.rodrigodev.xgen.test.instantiation.errorWithNoDescriptionAreAbstract.c1.c2.c3;

import com.rodrigodev.xgen.test.instantiation.errorWithNoDescriptionAreAbstract.c1.c2.C2Error;
import com.rodrigodev.xgen.test.instantiation.errorWithNoDescriptionAreAbstract.ErrorCode;


/**
* Autogenerated by XGen on July 3, 2015.
*/
public abstract class C3Error extends C2Error {

    public static final ErrorCode CODE = new ErrorCode("c-3", C2Error.CODE);

    private static String MESSAGE_FORMAT = "ABCDE";

    public static void throwException() {

        throw new C3Exception(String.format(MESSAGE_FORMAT));
    }
}

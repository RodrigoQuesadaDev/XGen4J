package com.rodrigodev.xgen.test.instantiation.errorWithNoDescriptionAreAbstract.c1.c2.c3;

import com.rodrigodev.xgen.test.instantiation.errorWithNoDescriptionAreAbstract.c1.c2.C2Error;


/**
* Autogenerated by XGen on 12/05/15.
*/
public abstract class C3Error extends C2Error {

    private static String MESSAGE_FORMAT = "ABCDE";

    public static void throwException() {
        throw new C3Exception(String.format(MESSAGE_FORMAT));
    }
}

package com.rodrigodev.xgen.test.hierarchy;

/**
* Autogenerated by XGen on 12/05/15.
*/
public abstract class C3_1Error extends C2Error {

    private static String MESSAGE_FORMAT = "ABCDE";

    public static void throwException() {
        throw new C3_1Exception(String.format(MESSAGE_FORMAT));
    }
}

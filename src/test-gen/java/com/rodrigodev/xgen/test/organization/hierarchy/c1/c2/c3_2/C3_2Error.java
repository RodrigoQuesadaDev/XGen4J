package com.rodrigodev.xgen.test.organization.hierarchy.c1.c2.c3_2;

import com.rodrigodev.xgen.test.organization.hierarchy.c1.c2.C2Error;
import com.rodrigodev.xgen.test.organization.hierarchy.ErrorCode;


/**
* Autogenerated by XGen on June 30, 2015.
*/
public abstract class C3_2Error extends C2Error {

    public static final ErrorCode CODE = new ErrorCode("root.c-1.c-2.c-3-2");

    private static String MESSAGE_FORMAT = "ABCDE";

    public static void throwException() {
        throw new C3_2Exception(String.format(MESSAGE_FORMAT));
    }
}

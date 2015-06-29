package com.rodrigodev.xgen.test.organization.hierarchy.e1.e2.e3_2;

import com.rodrigodev.xgen.test.organization.hierarchy.e1.e2.E2Error;
import com.rodrigodev.xgen.test.organization.hierarchy.ErrorCode;


/**
* Autogenerated by XGen on June 29, 2015.
*/
public abstract class E3_2Error extends E2Error {

    public static final ErrorCode CODE = new ErrorCode("root.e-1.e-2.e-3-2");

    private static String MESSAGE_FORMAT = "ABCDE";

    public static void throwException() {
        throw new E3_2Exception(String.format(MESSAGE_FORMAT));
    }
}

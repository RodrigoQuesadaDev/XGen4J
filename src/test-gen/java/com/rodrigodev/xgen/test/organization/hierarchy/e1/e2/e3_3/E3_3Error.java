package com.rodrigodev.xgen.test.organization.hierarchy.e1.e2.e3_3;

import com.rodrigodev.xgen.test.organization.hierarchy.e1.e2.E2Error;
import com.rodrigodev.xgen.test.organization.hierarchy.ErrorCode;


/**
* Autogenerated by XGen on July 2, 2015.
*/
public abstract class E3_3Error extends E2Error {

    public static final ErrorCode CODE = new ErrorCode("e-3-3", E2Error.CODE);

    private static String MESSAGE_FORMAT = "ABCDE";

    public static void throwException() {
        throw new E3_3Exception(String.format(MESSAGE_FORMAT));
    }
}

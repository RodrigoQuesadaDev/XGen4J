package com.rodrigodev.xgen.test.code.codeIdIsGenerated.c1.c2.c3_2;

import com.rodrigodev.xgen.test.code.codeIdIsGenerated.c1.c2.C2Error;
import com.rodrigodev.xgen.test.code.codeIdIsGenerated.ErrorCode;


/**
* Autogenerated by XGen on July 1, 2015.
*/
public abstract class C3_2Error extends C2Error {

    public static final ErrorCode CODE = new ErrorCode("code-name-c3-2", C2Error.CODE);

    private static String MESSAGE_FORMAT = "ABCDE";

    public static void throwException() {
        throw new C3_2Exception(String.format(MESSAGE_FORMAT));
    }
}

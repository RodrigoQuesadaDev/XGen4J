package com.rodrigodev.xgen.test.code.codeNameIsGenerated.c1.c2.c3_1;

import com.rodrigodev.xgen.test.code.codeNameIsGenerated.c1.c2.C2Error;
import com.rodrigodev.xgen.test.code.codeNameIsGenerated.ErrorCode;


/**
* Autogenerated by XGen on June 29, 2015.
*/
public abstract class C3_1Error extends C2Error {

    public static final ErrorCode CODE = new ErrorCode("code-name-root.code-name-c1.code-name-c2.code-name-c3-1");

    private static String MESSAGE_FORMAT = "ABCDE";

    public static void throwException() {
        throw new C3_1Exception(String.format(MESSAGE_FORMAT));
    }
}

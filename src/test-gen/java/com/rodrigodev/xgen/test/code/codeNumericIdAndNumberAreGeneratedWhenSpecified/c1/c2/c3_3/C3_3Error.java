package com.rodrigodev.xgen.test.code.codeNumericIdAndNumberAreGeneratedWhenSpecified.c1.c2.c3_3;

import com.rodrigodev.xgen.test.code.codeNumericIdAndNumberAreGeneratedWhenSpecified.c1.c2.C2Error;
import com.rodrigodev.xgen.test.code.codeNumericIdAndNumberAreGeneratedWhenSpecified.ErrorCode;


/**
* Autogenerated by XGen on July 3, 2015.
*/
public abstract class C3_3Error extends C2Error {

    public static final ErrorCode CODE = new ErrorCode("c-3-3", 678, C2Error.CODE);

    private static String MESSAGE_FORMAT = "ABCDE";

    public static void throwException() {

        throw new C3_3Exception(String.format(MESSAGE_FORMAT));
    }
}

package com.rodrigodev.xgen.test.code.codeNumericIdAndNumberAreGeneratedWhenSpecified.e1.e2.e3_2;

import com.rodrigodev.xgen.test.code.codeNumericIdAndNumberAreGeneratedWhenSpecified.e1.e2.E2Error;
import com.rodrigodev.xgen.test.code.codeNumericIdAndNumberAreGeneratedWhenSpecified.ErrorCode;


/**
* Autogenerated by XGen on July 3, 2015.
*/
public abstract class E3_2Error extends E2Error {

    public static final ErrorCode CODE = new ErrorCode("e-3-2", 765, E2Error.CODE);

    private static String MESSAGE_FORMAT = "ABCDE";

    public static void throwException() {

        throw new E3_2Exception(String.format(MESSAGE_FORMAT));
    }
}

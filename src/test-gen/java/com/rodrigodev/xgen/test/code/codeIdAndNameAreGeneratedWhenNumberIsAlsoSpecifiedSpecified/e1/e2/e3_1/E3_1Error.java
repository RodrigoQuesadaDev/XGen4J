package com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedWhenNumberIsAlsoSpecifiedSpecified.e1.e2.e3_1;

import com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedWhenNumberIsAlsoSpecifiedSpecified.e1.e2.E2Error;
import com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedWhenNumberIsAlsoSpecifiedSpecified.ErrorCode;


/**
* Autogenerated by XGen on July 2, 2015.
*/
public abstract class E3_1Error extends E2Error {

    public static final ErrorCode CODE = new ErrorCode("code-name-e3-1", 4, E2Error.CODE);

    private static String MESSAGE_FORMAT = "ABCDE";

    public static void throwException() {
        throw new E3_1Exception(String.format(MESSAGE_FORMAT));
    }
}

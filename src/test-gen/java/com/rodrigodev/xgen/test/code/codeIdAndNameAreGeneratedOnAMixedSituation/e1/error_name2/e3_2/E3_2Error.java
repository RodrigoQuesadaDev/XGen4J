package com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.e1.error_name2.e3_2;

import com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.e1.error_name2.ErrorName2Error;
import com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedOnAMixedSituation.ErrorCode;


/**
* Autogenerated by XGen on July 3, 2015.
*/
public abstract class E3_2Error extends ErrorName2Error {

    public static final ErrorCode CODE = new ErrorCode("code-name-e3-2", ErrorName2Error.CODE);

    private static String MESSAGE_FORMAT = "ABCDE";

    public static void throwException() {

        throw new E3_2Exception(String.format(MESSAGE_FORMAT));
    }
}

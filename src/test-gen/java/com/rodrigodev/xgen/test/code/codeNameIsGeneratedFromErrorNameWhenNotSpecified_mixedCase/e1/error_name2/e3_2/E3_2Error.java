package com.rodrigodev.xgen.test.code.codeNameIsGeneratedFromErrorNameWhenNotSpecified_mixedCase.e1.error_name2.e3_2;

import com.rodrigodev.xgen.test.code.codeNameIsGeneratedFromErrorNameWhenNotSpecified_mixedCase.e1.error_name2.ErrorName2Error;
import com.rodrigodev.xgen.test.code.codeNameIsGeneratedFromErrorNameWhenNotSpecified_mixedCase.ErrorCode;


/**
* Autogenerated by XGen on June 28, 2015.
*/
public abstract class E3_2Error extends ErrorName2Error {

    public static final ErrorCode CODE = new ErrorCode("root-name.code-name-e1.error-name-2.code-name-e3-2");

    private static String MESSAGE_FORMAT = "ABCDE";

    public static void throwException() {
        throw new E3_2Exception(String.format(MESSAGE_FORMAT));
    }
}

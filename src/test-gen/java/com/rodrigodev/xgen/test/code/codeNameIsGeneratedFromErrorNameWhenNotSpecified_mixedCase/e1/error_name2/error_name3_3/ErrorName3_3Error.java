package com.rodrigodev.xgen.test.code.codeNameIsGeneratedFromErrorNameWhenNotSpecified_mixedCase.e1.error_name2.error_name3_3;

import com.rodrigodev.xgen.test.code.codeNameIsGeneratedFromErrorNameWhenNotSpecified_mixedCase.e1.error_name2.ErrorName2Error;
import com.rodrigodev.xgen.test.code.codeNameIsGeneratedFromErrorNameWhenNotSpecified_mixedCase.ErrorCode;


/**
* Autogenerated by XGen on June 28, 2015.
*/
public abstract class ErrorName3_3Error extends ErrorName2Error {

    public static final ErrorCode CODE = new ErrorCode("root-name.code-name-e1.error-name-2.error-name-3-3");

    private static String MESSAGE_FORMAT = "ABCDE";

    public static void throwException() {
        throw new ErrorName3_3Exception(String.format(MESSAGE_FORMAT));
    }
}

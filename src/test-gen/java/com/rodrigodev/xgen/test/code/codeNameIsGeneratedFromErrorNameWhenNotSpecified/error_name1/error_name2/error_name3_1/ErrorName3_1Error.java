package com.rodrigodev.xgen.test.code.codeNameIsGeneratedFromErrorNameWhenNotSpecified.error_name1.error_name2.error_name3_1;

import com.rodrigodev.xgen.test.code.codeNameIsGeneratedFromErrorNameWhenNotSpecified.error_name1.error_name2.ErrorName2Error;
import com.rodrigodev.xgen.test.code.codeNameIsGeneratedFromErrorNameWhenNotSpecified.ErrorCode;


/**
* Autogenerated by XGen on June 28, 2015.
*/
public abstract class ErrorName3_1Error extends ErrorName2Error {

    public static final ErrorCode CODE = new ErrorCode("root-name.error-name-1.error-name-2.error-name-3-1");

    private static String MESSAGE_FORMAT = "ABCDE";

    public static void throwException() {
        throw new ErrorName3_1Exception(String.format(MESSAGE_FORMAT));
    }
}

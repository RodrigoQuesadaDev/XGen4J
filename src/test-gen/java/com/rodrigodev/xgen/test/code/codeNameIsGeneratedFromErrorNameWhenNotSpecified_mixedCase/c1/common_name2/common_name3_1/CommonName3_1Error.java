package com.rodrigodev.xgen.test.code.codeNameIsGeneratedFromErrorNameWhenNotSpecified_mixedCase.c1.common_name2.common_name3_1;

import com.rodrigodev.xgen.test.code.codeNameIsGeneratedFromErrorNameWhenNotSpecified_mixedCase.c1.common_name2.CommonName2Error;
import com.rodrigodev.xgen.test.code.codeNameIsGeneratedFromErrorNameWhenNotSpecified_mixedCase.ErrorCode;


/**
* Autogenerated by XGen on June 28, 2015.
*/
public abstract class CommonName3_1Error extends CommonName2Error {

    public static final ErrorCode CODE = new ErrorCode("root-name.code-name-c1.common-name-2.common-name-3-1");

    private static String MESSAGE_FORMAT = "ABCDE";

    public static void throwException() {
        throw new CommonName3_1Exception(String.format(MESSAGE_FORMAT));
    }
}

package com.rodrigodev.xgen.test.code.codeNameIsGeneratedFromErrorNameWhenNotSpecified.common_name1.common_name2.common_name3_2;

import com.rodrigodev.xgen.test.code.codeNameIsGeneratedFromErrorNameWhenNotSpecified.common_name1.common_name2.CommonName2Error;
import com.rodrigodev.xgen.test.code.codeNameIsGeneratedFromErrorNameWhenNotSpecified.ErrorCode;


/**
* Autogenerated by XGen on June 30, 2015.
*/
public abstract class CommonName3_2Error extends CommonName2Error {

    public static final ErrorCode CODE = new ErrorCode("root-name.common-name-1.common-name-2.common-name-3-2");

    private static String MESSAGE_FORMAT = "ABCDE";

    public static void throwException() {
        throw new CommonName3_2Exception(String.format(MESSAGE_FORMAT));
    }
}

package com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified.error_name1.error_name2.error_name3_3;

import com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified.error_name1.error_name2.ErrorName2Error;
import com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified.ErrorCode;


/**
* Autogenerated by XGen on July 3, 2015.
*/
public abstract class ErrorName3_3Error extends ErrorName2Error {

    public static final ErrorCode CODE = new ErrorCode("error-name-3-3", ErrorName2Error.CODE);

    private static String MESSAGE_FORMAT = "ABCDE";

    public static void throwException() {

        throw new ErrorName3_3Exception(String.format(MESSAGE_FORMAT));
    }
}

package com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified.common_name1.common_name2.common_name3_3;

import com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified.common_name1.common_name2.CommonName2Error;


import com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified.ErrorCode;
import com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified.RootNameException.ExceptionType;

/**
* Autogenerated by XGen on July 8, 2015.
*/
public abstract class CommonName3_3Error extends CommonName2Error {

    public static final ErrorCode CODE = new ErrorCode("common-name-3-3", CommonName2Error.CODE);

    private static String MESSAGE_FORMAT = "ABCDE";

    private static String createMessage() {
        return String.format(MESSAGE_FORMAT);
    }

    public static void throwException() {

        throw new CommonName3_3Exception(createMessage());
    }

    public static void throwException(ExceptionType exceptionType) {

        throwExceptionForCommonError(exceptionType, createMessage());
    }

}

package com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames.common_name1.common_name2.common_name3_2;

import com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames.common_name1.common_name2.CommonName2Error;


import com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames.ErrorCode;
import com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames.RootNameException.ExceptionType;

/**
* Autogenerated by XGen on July 6, 2015.
*/
public abstract class CommonName3_2Error extends CommonName2Error {

    public static final ErrorCode CODE = new ErrorCode("common-name-3-2", CommonName2Error.CODE);

    private static String MESSAGE_FORMAT = "ABCDE";

    private static String createMessage() {
        return String.format(MESSAGE_FORMAT);
    }

    public static void throwException() {

        throw new CommonName3_2Exception(createMessage());
    }

    public static void throwException(ExceptionType exceptionType) {

        throwExceptionForCommonError(exceptionType, createMessage());
    }

}

package com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames.common_name1.common_name2.common_name3_3;

import com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames.common_name1.common_name2.CommonName2Error;


import com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames.ErrorCode;
import com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames.RootNameException;
import com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames.RootNameException.ExceptionType;

/**
 * Autogenerated by XGen on July 13, 2015.
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

    public static void throwException(Throwable cause) {
        throw new CommonName3_3Exception(createMessage(), cause);
    }

    public static void throwException(ExceptionType exceptionType) {
        throwExceptionForCommonError(exceptionType, createMessage());
    }

    public static void throwException(ExceptionType exceptionType, Throwable cause) {
        throwExceptionForCommonError(exceptionType, createMessage(), cause);
    }

}

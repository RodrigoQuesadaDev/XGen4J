package com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames.error_name1.error_name2.error_name3_3;

import com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames.error_name1.error_name2.ErrorName2Error;
import com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames.ErrorCode;


/**
* Autogenerated by XGen on June 30, 2015.
*/
public abstract class ErrorName3_3Error extends ErrorName2Error {

    public static final ErrorCode CODE = new ErrorCode("root-name.error-name-1.error-name-2.error-name-3-3");

    private static String MESSAGE_FORMAT = "ABCDE";

    public static void throwException() {
        throw new ErrorName3_3Exception(String.format(MESSAGE_FORMAT));
    }
}

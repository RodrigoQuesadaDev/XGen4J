package com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames.common_name1.common_name2.common_name3_3;

import com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames.common_name1.common_name2.CommonName2Error;
import com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames.ErrorCode;


/**
* Autogenerated by XGen on June 29, 2015.
*/
public abstract class CommonName3_3Error extends CommonName2Error {

    public static final ErrorCode CODE = new ErrorCode("root-name.common-name-1.common-name-2.common-name-3-3");

    private static String MESSAGE_FORMAT = "ABCDE";

    public static void throwException() {
        throw new CommonName3_3Exception(String.format(MESSAGE_FORMAT));
    }
}
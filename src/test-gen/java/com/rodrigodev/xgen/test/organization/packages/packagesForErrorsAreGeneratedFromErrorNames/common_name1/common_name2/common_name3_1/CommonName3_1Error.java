package com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames.common_name1.common_name2.common_name3_1;

import com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames.common_name1.common_name2.CommonName2Error;
import com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames.ErrorCode;


/**
* Autogenerated by XGen on July 1, 2015.
*/
public abstract class CommonName3_1Error extends CommonName2Error {

    public static final ErrorCode CODE = new ErrorCode("common-name-3-1", CommonName2Error.CODE);

    private static String MESSAGE_FORMAT = "ABCDE";

    public static void throwException() {
        throw new CommonName3_1Exception(String.format(MESSAGE_FORMAT));
    }
}

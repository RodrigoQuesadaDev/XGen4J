package com.rodrigodev.xgen.test.organization.packages.common_name1.common_name2.common_name3_2;

import com.rodrigodev.xgen.test.organization.packages.common_name1.common_name2.CommonName2Error;


/**
* Autogenerated by XGen on 12/05/15.
*/
public abstract class CommonName3_2Error extends CommonName2Error {

    private static String MESSAGE_FORMAT = "ABCDE";

    public static void throwException() {
        throw new CommonName3_2Exception(String.format(MESSAGE_FORMAT));
    }
}

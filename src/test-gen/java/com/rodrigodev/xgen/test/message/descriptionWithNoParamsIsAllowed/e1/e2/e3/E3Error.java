package com.rodrigodev.xgen.test.message.descriptionWithNoParamsIsAllowed.e1.e2.e3;

import com.rodrigodev.xgen.test.message.descriptionWithNoParamsIsAllowed.e1.e2.E2Error;
import com.rodrigodev.xgen.test.message.descriptionWithNoParamsIsAllowed.ErrorCode;


/**
* Autogenerated by XGen on June 29, 2015.
*/
public abstract class E3Error extends E2Error {

    public static final ErrorCode CODE = new ErrorCode("root.e-1.e-2.e-3");

    private static String MESSAGE_FORMAT = "Some description.";

    public static void throwException() {
        throw new E3Exception(String.format(MESSAGE_FORMAT));
    }
}

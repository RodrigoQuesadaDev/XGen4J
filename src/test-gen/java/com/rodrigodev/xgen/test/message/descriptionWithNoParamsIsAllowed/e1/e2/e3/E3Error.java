package com.rodrigodev.xgen.test.message.descriptionWithNoParamsIsAllowed.e1.e2.e3;

import com.rodrigodev.xgen.test.message.descriptionWithNoParamsIsAllowed.e1.e2.E2Error;


/**
* Autogenerated by XGen on 12/05/15.
*/
public abstract class E3Error extends E2Error {

    private static String MESSAGE_FORMAT = "Some description.";

    public static void throwException() {
        throw new E3Exception(String.format(MESSAGE_FORMAT));
    }
}

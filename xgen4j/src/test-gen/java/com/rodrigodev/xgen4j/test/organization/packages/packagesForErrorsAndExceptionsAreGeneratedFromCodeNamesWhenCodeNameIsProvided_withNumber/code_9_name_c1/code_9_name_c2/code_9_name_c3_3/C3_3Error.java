package com.rodrigodev.xgen4j.test.organization.packages.packagesForErrorsAndExceptionsAreGeneratedFromCodeNamesWhenCodeNameIsProvided_withNumber.code_9_name_c1.code_9_name_c2.code_9_name_c3_3;

import com.rodrigodev.xgen4j.test.organization.packages.packagesForErrorsAndExceptionsAreGeneratedFromCodeNamesWhenCodeNameIsProvided_withNumber.code_9_name_c1.code_9_name_c2.C2Error;


import com.rodrigodev.xgen4j.test.organization.packages.packagesForErrorsAndExceptionsAreGeneratedFromCodeNamesWhenCodeNameIsProvided_withNumber.ErrorCode;
import com.rodrigodev.xgen4j.test.organization.packages.packagesForErrorsAndExceptionsAreGeneratedFromCodeNamesWhenCodeNameIsProvided_withNumber.RootException;
import com.rodrigodev.xgen4j.test.organization.packages.packagesForErrorsAndExceptionsAreGeneratedFromCodeNamesWhenCodeNameIsProvided_withNumber.RootException.ExceptionType;

/**
 * Autogenerated by XGen4J on January 1, 0001.
 */
public abstract class C3_3Error extends C2Error {

    public static final ErrorCode CODE = new ErrorCode("code-9-name-c3-3", 6, C2Error.CODE);

    private static String MESSAGE_FORMAT = "ABCDE";

    private static String createMessage() {

        return String.format(MESSAGE_FORMAT);
    }

    public static void throwException() {
        throw new C3_3Exception(CODE, createMessage());
    }

    public static void throwException(Throwable cause) {
        throw new C3_3Exception(CODE, createMessage(), cause);
    }

    public static void throwException(ExceptionType exceptionType) {
        throwExceptionForCommonError(CODE, exceptionType, createMessage());
    }

    public static void throwException(ExceptionType exceptionType, Throwable cause) {
        throwExceptionForCommonError(CODE, exceptionType, createMessage(), cause);
    }

}

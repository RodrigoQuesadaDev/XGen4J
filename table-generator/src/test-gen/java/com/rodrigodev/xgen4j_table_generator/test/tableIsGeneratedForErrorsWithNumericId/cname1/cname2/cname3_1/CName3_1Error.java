package com.rodrigodev.xgen4j_table_generator.test.tableIsGeneratedForErrorsWithNumericId.cname1.cname2.cname3_1;

import com.rodrigodev.xgen4j_table_generator.test.tableIsGeneratedForErrorsWithNumericId.cname1.cname2.CName2Error;


import com.rodrigodev.xgen4j_table_generator.test.tableIsGeneratedForErrorsWithNumericId.ErrorCode;
import com.rodrigodev.xgen4j_table_generator.test.tableIsGeneratedForErrorsWithNumericId.RootNameException;
import com.rodrigodev.xgen4j_table_generator.test.tableIsGeneratedForErrorsWithNumericId.RootNameException.ExceptionType;

/**
 * Autogenerated by XGen on January 1, 0001.
 */
public abstract class CName3_1Error extends CName2Error {

    public static final ErrorCode CODE = new ErrorCode("common-code-name-3-1", 4, CName2Error.CODE);

    private static String MESSAGE_FORMAT = "Message for CName3_1 error.";

    private static String createMessage() {

        return String.format(MESSAGE_FORMAT);
    }

    public static void throwException() {
        throw new CName3_1Exception(createMessage());
    }

    public static void throwException(Throwable cause) {
        throw new CName3_1Exception(createMessage(), cause);
    }

    public static void throwException(ExceptionType exceptionType) {
        throwExceptionForCommonError(exceptionType, createMessage());
    }

    public static void throwException(ExceptionType exceptionType, Throwable cause) {
        throwExceptionForCommonError(exceptionType, createMessage(), cause);
    }

}
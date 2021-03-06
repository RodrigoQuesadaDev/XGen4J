package com.rodrigodev.xgen4j_table_generator.test.tableIsGeneratedForErrorsWithNoNumericId.common_code_name_1.common_code_name_2.common_code_name_3_1;

import com.rodrigodev.xgen4j_table_generator.test.tableIsGeneratedForErrorsWithNoNumericId.common_code_name_1.common_code_name_2.CName2Error;


import com.rodrigodev.xgen4j_table_generator.test.tableIsGeneratedForErrorsWithNoNumericId.ErrorCode;
import com.rodrigodev.xgen4j_table_generator.test.tableIsGeneratedForErrorsWithNoNumericId.RootNameException;
import com.rodrigodev.xgen4j_table_generator.test.tableIsGeneratedForErrorsWithNoNumericId.RootNameException.ExceptionType;

/**
 * Autogenerated by XGen4J on January 1, 0001.
 */
public abstract class CName3_1Error extends CName2Error {

    public static final ErrorCode CODE = new ErrorCode("common-code-name-3-1", CName2Error.CODE);

    private static String MESSAGE_FORMAT = "Message for CName3_1 error.";

    private static String createMessage() {

        return String.format(MESSAGE_FORMAT);
    }

    public static void throwException() {
        throw new CName3_1Exception(CODE, createMessage());
    }

    public static void throwException(Throwable cause) {
        throw new CName3_1Exception(CODE, createMessage(), cause);
    }

    public static void throwException(ExceptionType exceptionType) {
        throwExceptionForCommonError(CODE, exceptionType, createMessage());
    }

    public static void throwException(ExceptionType exceptionType, Throwable cause) {
        throwExceptionForCommonError(CODE, exceptionType, createMessage(), cause);
    }

}

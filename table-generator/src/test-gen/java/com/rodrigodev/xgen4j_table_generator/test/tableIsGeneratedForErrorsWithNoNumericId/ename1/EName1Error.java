package com.rodrigodev.xgen4j_table_generator.test.tableIsGeneratedForErrorsWithNoNumericId.ename1;

import com.rodrigodev.xgen4j_table_generator.test.tableIsGeneratedForErrorsWithNoNumericId.RootNameError;


import com.rodrigodev.xgen4j_table_generator.test.tableIsGeneratedForErrorsWithNoNumericId.ErrorCode;

/**
 * Autogenerated by XGen on January 1, 0001.
 */
public abstract class EName1Error extends RootNameError {

    public static final ErrorCode CODE = new ErrorCode("error-code-name-1", RootNameError.CODE);

    private static String MESSAGE_FORMAT = "Message for EName1 error.";

    private static String createMessage() {

        return String.format(MESSAGE_FORMAT);
    }

    public static void throwException() {
        throw new EName1Exception(createMessage());
    }

    public static void throwException(Throwable cause) {
        throw new EName1Exception(createMessage(), cause);
    }


}
package com.rodrigodev.xgen4j_table_generator.test.tableIsGeneratedForErrorsWithNoNumericId.error_2_code_name_1.error_2_code_name_2.error_2_code_name_3_2;

import com.rodrigodev.xgen4j_table_generator.test.tableIsGeneratedForErrorsWithNoNumericId.error_2_code_name_1.error_2_code_name_2.E2Name2Error;

import java.lang.String;
import java.lang.Integer;
import com.rodrigodev.xgen4j.test.common.doubles.error.message.TestObject;

import com.rodrigodev.xgen4j_table_generator.test.tableIsGeneratedForErrorsWithNoNumericId.ErrorCode;

/**
 * Autogenerated by XGen4J on January 1, 0001.
 */
public abstract class E2Name3_2Error extends E2Name2Error {

    public static final ErrorCode CODE = new ErrorCode("error-2-code-name-3-2", E2Name2Error.CODE);

    private static String MESSAGE_FORMAT = "E2Name3_2: {param1: '%s', param2: %d, param3: '%s'}";

    private static String createMessage(String param1, Integer param2, TestObject param3) {
        if(param1 == null) throw new NullPointerException("param1");
        if(param2 == null) throw new NullPointerException("param2");
        if(param3 == null) throw new NullPointerException("param3");

        return String.format(MESSAGE_FORMAT, param1, param2, param3);
    }

    public static void throwException(String param1, Integer param2, TestObject param3) {
        throw new E2Name3_2Exception(CODE, createMessage(param1, param2, param3));
    }

    public static void throwException(String param1, Integer param2, TestObject param3, Throwable cause) {
        throw new E2Name3_2Exception(CODE, createMessage(param1, param2, param3), cause);
    }


}

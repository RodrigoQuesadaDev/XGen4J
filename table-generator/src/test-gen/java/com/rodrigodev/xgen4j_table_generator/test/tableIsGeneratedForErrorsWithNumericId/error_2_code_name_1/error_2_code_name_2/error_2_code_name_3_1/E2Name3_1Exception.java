package com.rodrigodev.xgen4j_table_generator.test.tableIsGeneratedForErrorsWithNumericId.error_2_code_name_1.error_2_code_name_2.error_2_code_name_3_1;

import com.rodrigodev.xgen4j_table_generator.test.tableIsGeneratedForErrorsWithNumericId.error_2_code_name_1.error_2_code_name_2.E2Name2Exception;
import com.rodrigodev.xgen4j_table_generator.test.tableIsGeneratedForErrorsWithNumericId.RootNameException;
import com.rodrigodev.xgen4j_table_generator.test.tableIsGeneratedForErrorsWithNumericId.ErrorCode;

/**
 * Autogenerated by XGen4J on January 1, 0001.
 */
public class E2Name3_1Exception extends E2Name2Exception {

    public static final ExceptionType TYPE = new ExceptionType();

    protected E2Name3_1Exception(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    protected E2Name3_1Exception(ErrorCode errorCode, String message, Throwable cause) {
        super(errorCode, message, cause);
    }

    private static class ExceptionType extends RootNameException.ExceptionType {

        @Override
        protected RootNameException createException(ErrorCode errorCode, String message) {
            return new E2Name3_1Exception(errorCode, message);
        }

        @Override
        protected RootNameException createException(ErrorCode errorCode, String message, Throwable cause) {
            return new E2Name3_1Exception(errorCode, message, cause);
        }
    }
}

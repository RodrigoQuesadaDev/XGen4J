package com.rodrigodev.xgen4j_table_generator.test.tableIsGeneratedForErrorsWithNoNumericId.error_2_code_name_1.error_2_code_name_2;

import com.rodrigodev.xgen4j_table_generator.test.tableIsGeneratedForErrorsWithNoNumericId.error_2_code_name_1.E2Name1Exception;
import com.rodrigodev.xgen4j_table_generator.test.tableIsGeneratedForErrorsWithNoNumericId.RootNameException;
import com.rodrigodev.xgen4j_table_generator.test.tableIsGeneratedForErrorsWithNoNumericId.ErrorCode;

/**
 * Autogenerated by XGen4J on January 1, 0001.
 */
public class E2Name2Exception extends E2Name1Exception {

    public static final ExceptionType TYPE = new ExceptionType();

    protected E2Name2Exception(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    protected E2Name2Exception(ErrorCode errorCode, String message, Throwable cause) {
        super(errorCode, message, cause);
    }

    private static class ExceptionType extends RootNameException.ExceptionType {

        @Override
        protected RootNameException createException(ErrorCode errorCode, String message) {
            return new E2Name2Exception(errorCode, message);
        }

        @Override
        protected RootNameException createException(ErrorCode errorCode, String message, Throwable cause) {
            return new E2Name2Exception(errorCode, message, cause);
        }
    }
}

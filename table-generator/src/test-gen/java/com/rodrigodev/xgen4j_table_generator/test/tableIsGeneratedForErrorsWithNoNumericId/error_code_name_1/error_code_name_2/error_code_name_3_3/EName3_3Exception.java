package com.rodrigodev.xgen4j_table_generator.test.tableIsGeneratedForErrorsWithNoNumericId.error_code_name_1.error_code_name_2.error_code_name_3_3;

import com.rodrigodev.xgen4j_table_generator.test.tableIsGeneratedForErrorsWithNoNumericId.error_code_name_1.error_code_name_2.EName2Exception;
import com.rodrigodev.xgen4j_table_generator.test.tableIsGeneratedForErrorsWithNoNumericId.RootNameException;
import com.rodrigodev.xgen4j_table_generator.test.tableIsGeneratedForErrorsWithNoNumericId.ErrorCode;

/**
 * Autogenerated by XGen4J on January 1, 0001.
 */
public class EName3_3Exception extends EName2Exception {

    public static final ExceptionType TYPE = new ExceptionType();

    protected EName3_3Exception(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    protected EName3_3Exception(ErrorCode errorCode, String message, Throwable cause) {
        super(errorCode, message, cause);
    }

    private static class ExceptionType extends RootNameException.ExceptionType {

        @Override
        protected RootNameException createException(ErrorCode errorCode, String message) {
            return new EName3_3Exception(errorCode, message);
        }

        @Override
        protected RootNameException createException(ErrorCode errorCode, String message, Throwable cause) {
            return new EName3_3Exception(errorCode, message, cause);
        }
    }
}

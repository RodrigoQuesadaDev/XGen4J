package com.rodrigodev.xgen4j_table_generator.test.tableIsGeneratedForErrorsWithNumericId.e2name1.e2name2.e2name3_1;

import com.rodrigodev.xgen4j_table_generator.test.tableIsGeneratedForErrorsWithNumericId.e2name1.e2name2.E2Name2Exception;
import com.rodrigodev.xgen4j_table_generator.test.tableIsGeneratedForErrorsWithNumericId.RootNameException;

/**
 * Autogenerated by XGen4J on January 1, 0001.
 */
public class E2Name3_1Exception extends E2Name2Exception {

    public static final ExceptionType TYPE = new ExceptionType();

    private static class ExceptionType extends RootNameException.ExceptionType {

        @Override
        protected RootNameException createException(String message) {
            return new E2Name3_1Exception(message);
        }

        @Override
        protected RootNameException createException(String message, Throwable cause) {
            return new E2Name3_1Exception(message, cause);
        }
    }

    protected E2Name3_1Exception(String message) {
        super(message);
    }

    protected E2Name3_1Exception(String message, Throwable cause) {
        super(message, cause);
    }
}

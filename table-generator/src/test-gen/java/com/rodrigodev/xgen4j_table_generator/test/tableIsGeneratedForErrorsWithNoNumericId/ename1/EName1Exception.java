package com.rodrigodev.xgen4j_table_generator.test.tableIsGeneratedForErrorsWithNoNumericId.ename1;

import com.rodrigodev.xgen4j_table_generator.test.tableIsGeneratedForErrorsWithNoNumericId.RootNameException;
import com.rodrigodev.xgen4j_table_generator.test.tableIsGeneratedForErrorsWithNoNumericId.RootNameException;

/**
 * Autogenerated by XGen4J on January 1, 0001.
 */
public class EName1Exception extends RootNameException {

    public static final ExceptionType TYPE = new ExceptionType();

    private static class ExceptionType extends RootNameException.ExceptionType {

        @Override
        protected RootNameException createException(String message) {
            return new EName1Exception(message);
        }

        @Override
        protected RootNameException createException(String message, Throwable cause) {
            return new EName1Exception(message, cause);
        }
    }

    protected EName1Exception(String message) {
        super(message);
    }

    protected EName1Exception(String message, Throwable cause) {
        super(message, cause);
    }
}

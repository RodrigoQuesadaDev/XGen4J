package com.rodrigodev.xgen4j_table_generator.test.tableIsGeneratedForErrorsWithNoNumericId.ename1.ename2;

import com.rodrigodev.xgen4j_table_generator.test.tableIsGeneratedForErrorsWithNoNumericId.ename1.EName1Exception;
import com.rodrigodev.xgen4j_table_generator.test.tableIsGeneratedForErrorsWithNoNumericId.RootNameException;

/**
 * Autogenerated by XGen on January 1, 0001.
 */
public class EName2Exception extends EName1Exception {

    public static final ExceptionType TYPE = new ExceptionType();

    private static class ExceptionType extends RootNameException.ExceptionType {

        @Override
        protected RootNameException createException(String message) {
            return new EName2Exception(message);
        }

        @Override
        protected RootNameException createException(String message, Throwable cause) {
            return new EName2Exception(message, cause);
        }
    }

    protected EName2Exception(String message) {
        super(message);
    }

    protected EName2Exception(String message, Throwable cause) {
        super(message, cause);
    }
}

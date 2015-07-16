package com.rodrigodev.xgen4j_table_generator.test.tableIsGeneratedForErrorsWithNumericId;




import com.rodrigodev.xgen4j_table_generator.test.tableIsGeneratedForErrorsWithNumericId.RootNameException.ExceptionType;

/**
 * Autogenerated by XGen on January 1, 0001.
 */
public abstract class RootNameError {

    public static final ErrorCode CODE = new ErrorCode("root-code-name", 1);


    protected static void throwExceptionForCommonError(ExceptionType exceptionType, String message) {
        if(exceptionType == null) throw new NullPointerException("exceptionType");

        throw exceptionType.createException(message);
    }

    protected static void throwExceptionForCommonError(ExceptionType exceptionType, String message, Throwable cause) {
        if(exceptionType == null) throw new NullPointerException("exceptionType");

        throw exceptionType.createException(message, cause);
    }
}

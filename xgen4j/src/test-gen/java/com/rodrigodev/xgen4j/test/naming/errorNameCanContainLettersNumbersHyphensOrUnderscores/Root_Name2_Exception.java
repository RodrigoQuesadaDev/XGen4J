package com.rodrigodev.xgen4j.test.naming.errorNameCanContainLettersNumbersHyphensOrUnderscores;



/**
 * Autogenerated by XGen4J on January 1, 0001.
 */
public class Root_Name2_Exception extends RuntimeException {

    final private ErrorCode errorCode;

    protected Root_Name2_Exception(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    protected Root_Name2_Exception(ErrorCode errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public ErrorCode errorCode() {
        return errorCode;
    }

    public abstract static class ExceptionType {

        protected ExceptionType() {
        }

        protected abstract Root_Name2_Exception createException(ErrorCode errorCode, String message);

        protected abstract Root_Name2_Exception createException(ErrorCode errorCode, String message, Throwable cause);
    }
}

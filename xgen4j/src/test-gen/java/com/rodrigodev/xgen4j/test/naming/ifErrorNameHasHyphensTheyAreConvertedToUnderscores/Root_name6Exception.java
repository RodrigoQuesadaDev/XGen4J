package com.rodrigodev.xgen4j.test.naming.ifErrorNameHasHyphensTheyAreConvertedToUnderscores;



/**
 * Autogenerated by XGen4J on January 1, 0001.
 */
public class Root_name6Exception extends RuntimeException {

    final private ErrorCode errorCode;

    protected Root_name6Exception(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    protected Root_name6Exception(ErrorCode errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public ErrorCode errorCode() {
        return errorCode;
    }

    public abstract static class ExceptionType {

        protected ExceptionType() {
        }

        protected abstract Root_name6Exception createException(ErrorCode errorCode, String message);

        protected abstract Root_name6Exception createException(ErrorCode errorCode, String message, Throwable cause);
    }
}

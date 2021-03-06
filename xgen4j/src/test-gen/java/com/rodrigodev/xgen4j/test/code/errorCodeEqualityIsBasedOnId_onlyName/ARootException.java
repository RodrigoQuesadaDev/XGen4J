package com.rodrigodev.xgen4j.test.code.errorCodeEqualityIsBasedOnId_onlyName;



/**
 * Autogenerated by XGen4J on January 1, 0001.
 */
public class ARootException extends RuntimeException {

    final private ErrorCode errorCode;

    protected ARootException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    protected ARootException(ErrorCode errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public ErrorCode errorCode() {
        return errorCode;
    }

    public abstract static class ExceptionType {

        protected ExceptionType() {
        }

        protected abstract ARootException createException(ErrorCode errorCode, String message);

        protected abstract ARootException createException(ErrorCode errorCode, String message, Throwable cause);
    }
}

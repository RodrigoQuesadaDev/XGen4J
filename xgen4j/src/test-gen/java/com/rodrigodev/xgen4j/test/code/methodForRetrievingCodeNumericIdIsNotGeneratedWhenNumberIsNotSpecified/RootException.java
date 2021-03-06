package com.rodrigodev.xgen4j.test.code.methodForRetrievingCodeNumericIdIsNotGeneratedWhenNumberIsNotSpecified;



/**
 * Autogenerated by XGen4J on January 1, 0001.
 */
public class RootException extends RuntimeException {

    final private ErrorCode errorCode;

    protected RootException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    protected RootException(ErrorCode errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public ErrorCode errorCode() {
        return errorCode;
    }

    public abstract static class ExceptionType {

        protected ExceptionType() {
        }

        protected abstract RootException createException(ErrorCode errorCode, String message);

        protected abstract RootException createException(ErrorCode errorCode, String message, Throwable cause);
    }
}

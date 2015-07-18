package com.rodrigodev.xgen4j.test.naming.errorNameCanBeginWithUpperCaseLetter;



/**
 * Autogenerated by XGen4J on January 1, 0001.
 */
public class RootNameException extends RuntimeException {

    final private ErrorCode errorCode;

    protected RootNameException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    protected RootNameException(ErrorCode errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public ErrorCode errorCode() {
        return errorCode;
    }

    public abstract static class ExceptionType {

        protected ExceptionType() {
        }

        protected abstract RootNameException createException(ErrorCode errorCode, String message);

        protected abstract RootNameException createException(ErrorCode errorCode, String message, Throwable cause);
    }
}

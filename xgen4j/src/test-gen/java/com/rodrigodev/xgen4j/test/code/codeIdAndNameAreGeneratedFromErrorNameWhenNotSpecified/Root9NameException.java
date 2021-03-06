package com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified;



/**
 * Autogenerated by XGen4J on January 1, 0001.
 */
public class Root9NameException extends RuntimeException {

    final private ErrorCode errorCode;

    protected Root9NameException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    protected Root9NameException(ErrorCode errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public ErrorCode errorCode() {
        return errorCode;
    }

    public abstract static class ExceptionType {

        protected ExceptionType() {
        }

        protected abstract Root9NameException createException(ErrorCode errorCode, String message);

        protected abstract Root9NameException createException(ErrorCode errorCode, String message, Throwable cause);
    }
}

package com.rodrigodev.xgen4j.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified_specialCases;



/**
 * Autogenerated by XGen4J on January 1, 0001.
 */
public class RootName___10___Exception extends RuntimeException {

    final private ErrorCode errorCode;

    protected RootName___10___Exception(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    protected RootName___10___Exception(ErrorCode errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public ErrorCode errorCode() {
        return errorCode;
    }

    public abstract static class ExceptionType {

        protected ExceptionType() {
        }

        protected abstract RootName___10___Exception createException(ErrorCode errorCode, String message);

        protected abstract RootName___10___Exception createException(ErrorCode errorCode, String message, Throwable cause);
    }
}
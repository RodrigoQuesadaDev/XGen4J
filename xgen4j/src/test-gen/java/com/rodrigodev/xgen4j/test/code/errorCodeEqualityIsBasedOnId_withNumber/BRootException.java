package com.rodrigodev.xgen4j.test.code.errorCodeEqualityIsBasedOnId_withNumber;




/**
 * Autogenerated by XGen on January 1, 0001.
 */
public class BRootException extends RuntimeException {


    public abstract static class ExceptionType {

        protected ExceptionType() {
        }

        protected abstract BRootException createException(String message);

        protected abstract BRootException createException(String message, Throwable cause);
    }

    protected BRootException(String message) {
        super(message);
    }

    protected BRootException(String message, Throwable cause) {
        super(message, cause);
    }
}

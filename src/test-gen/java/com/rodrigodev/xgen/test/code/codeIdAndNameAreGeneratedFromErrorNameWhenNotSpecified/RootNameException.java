package com.rodrigodev.xgen.test.code.codeIdAndNameAreGeneratedFromErrorNameWhenNotSpecified;




/**
 * Autogenerated by XGen on July 12, 2015.
 */
public class RootNameException extends RuntimeException {


    public abstract static class ExceptionType {

        protected ExceptionType() {
        }

        protected abstract RootNameException createException(String message);

        protected abstract RootNameException createException(String message, Throwable cause);
    }

    protected RootNameException(String message) {
        super(message);
    }

    protected RootNameException(String message, Throwable cause) {
        super(message, cause);
    }
}

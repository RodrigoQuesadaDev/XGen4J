package com.rodrigodev.xgen4j.test.message.descriptionWithCustomObjectThatGeneratesTheMessageCanBeUsed;




/**
 * Autogenerated by XGen4J on January 1, 0001.
 */
public class RootException extends RuntimeException {


    public abstract static class ExceptionType {

        protected ExceptionType() {
        }

        protected abstract RootException createException(String message);

        protected abstract RootException createException(String message, Throwable cause);
    }

    protected RootException(String message) {
        super(message);
    }

    protected RootException(String message, Throwable cause) {
        super(message, cause);
    }
}

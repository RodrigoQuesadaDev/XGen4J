package com.rodrigodev.xgen.test.instantiation.errorWithNoDescriptionAreAbstract;




/**
* Autogenerated by XGen on July 8, 2015.
*/
public class RootException extends RuntimeException {

    public abstract static class ExceptionType {

        protected ExceptionType() {
        }

        protected abstract RootException createException(String message);
    }

    protected RootException(String message) {
        super(message);
    }
}

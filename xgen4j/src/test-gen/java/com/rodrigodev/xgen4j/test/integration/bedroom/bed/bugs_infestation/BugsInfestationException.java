package com.rodrigodev.xgen4j.test.integration.bedroom.bed.bugs_infestation;

import com.rodrigodev.xgen4j.test.integration.bedroom.bed.BedException;
import com.rodrigodev.xgen4j.test.integration.HouseException;
import com.rodrigodev.xgen4j.test.integration.ErrorCode;

/**
 * Autogenerated by XGen4J on January 1, 0001.
 */
public class BugsInfestationException extends BedException {

    public static final ExceptionType TYPE = new ExceptionType();

    protected BugsInfestationException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    protected BugsInfestationException(ErrorCode errorCode, String message, Throwable cause) {
        super(errorCode, message, cause);
    }

    private static class ExceptionType extends HouseException.ExceptionType {

        @Override
        protected HouseException createException(ErrorCode errorCode, String message) {
            return new BugsInfestationException(errorCode, message);
        }

        @Override
        protected HouseException createException(ErrorCode errorCode, String message, Throwable cause) {
            return new BugsInfestationException(errorCode, message, cause);
        }
    }
}

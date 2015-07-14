package com.rodrigodev.xgen.test.integration.bedroom.bed.bugs_infestation;

import com.rodrigodev.xgen.test.integration.bedroom.bed.BedException;
import com.rodrigodev.xgen.test.integration.HouseException;

/**
 * Autogenerated by XGen on January 1, 0001.
 */
public class BugsInfestationException extends BedException {

    public static final ExceptionType TYPE = new ExceptionType();

    private static class ExceptionType extends HouseException.ExceptionType {

        @Override
        protected HouseException createException(String message) {
            return new BugsInfestationException(message);
        }

        @Override
        protected HouseException createException(String message, Throwable cause) {
            return new BugsInfestationException(message, cause);
        }
    }

    protected BugsInfestationException(String message) {
        super(message);
    }

    protected BugsInfestationException(String message, Throwable cause) {
        super(message, cause);
    }
}

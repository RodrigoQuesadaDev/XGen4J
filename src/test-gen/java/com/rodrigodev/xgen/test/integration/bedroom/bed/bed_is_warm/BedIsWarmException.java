package com.rodrigodev.xgen.test.integration.bedroom.bed.bed_is_warm;

import com.rodrigodev.xgen.test.integration.bedroom.bed.BedException;
import com.rodrigodev.xgen.test.integration.HouseException;

/**
* Autogenerated by XGen on July 8, 2015.
*/
public class BedIsWarmException extends BedException {

    public static final ExceptionType TYPE = new ExceptionType();

    private static class ExceptionType extends HouseException.ExceptionType {

        @Override
        protected HouseException createException(String message) {
            return new BedIsWarmException(message);
        }

        @Override
        protected HouseException createException(String message, Throwable cause) {
            return new BedIsWarmException(message, cause);
        }
    }

    protected BedIsWarmException(String message) {
        super(message);
    }

    protected BedIsWarmException(String message, Throwable cause) {
        super(message, cause);
    }
}

package com.rodrigodev.xgen4j.test.info_generation.regularTest.ea1.ea2;

import com.rodrigodev.xgen4j.test.info_generation.regularTest.ea1.EA1Exception;
import com.rodrigodev.xgen4j.test.info_generation.regularTest.RootException;
import com.rodrigodev.xgen4j.test.info_generation.regularTest.ErrorCode;

/**
 * Autogenerated by XGen4J on January 1, 0001.
 */
public class EA2Exception extends EA1Exception {

    public static final ExceptionType TYPE = new ExceptionType();

    protected EA2Exception(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    protected EA2Exception(ErrorCode errorCode, String message, Throwable cause) {
        super(errorCode, message, cause);
    }

    private static class ExceptionType extends RootException.ExceptionType {

        @Override
        protected RootException createException(ErrorCode errorCode, String message) {
            return new EA2Exception(errorCode, message);
        }

        @Override
        protected RootException createException(ErrorCode errorCode, String message, Throwable cause) {
            return new EA2Exception(errorCode, message, cause);
        }
    }
}

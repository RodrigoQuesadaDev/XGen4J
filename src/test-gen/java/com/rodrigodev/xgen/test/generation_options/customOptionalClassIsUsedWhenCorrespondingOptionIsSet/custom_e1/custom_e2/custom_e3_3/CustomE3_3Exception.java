package com.rodrigodev.xgen.test.generation_options.customOptionalClassIsUsedWhenCorrespondingOptionIsSet.custom_e1.custom_e2.custom_e3_3;

import com.rodrigodev.xgen.test.generation_options.customOptionalClassIsUsedWhenCorrespondingOptionIsSet.custom_e1.custom_e2.CustomE2Exception;
import com.rodrigodev.xgen.test.generation_options.customOptionalClassIsUsedWhenCorrespondingOptionIsSet.CustomRootException;

/**
 * Autogenerated by XGen on July 13, 2015.
 */
public class CustomE3_3Exception extends CustomE2Exception {

    public static final ExceptionType TYPE = new ExceptionType();

    private static class ExceptionType extends CustomRootException.ExceptionType {

        @Override
        protected CustomRootException createException(String message) {
            return new CustomE3_3Exception(message);
        }

        @Override
        protected CustomRootException createException(String message, Throwable cause) {
            return new CustomE3_3Exception(message, cause);
        }
    }

    protected CustomE3_3Exception(String message) {
        super(message);
    }

    protected CustomE3_3Exception(String message, Throwable cause) {
        super(message, cause);
    }
}

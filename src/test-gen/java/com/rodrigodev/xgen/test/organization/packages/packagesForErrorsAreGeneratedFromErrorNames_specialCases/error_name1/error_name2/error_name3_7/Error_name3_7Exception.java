package com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames_specialCases.error_name1.error_name2.error_name3_7;

import com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames_specialCases.error_name1.error_name2.ErrorName2Exception;
import com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames_specialCases.RootNameException;

/**
* Autogenerated by XGen on July 6, 2015.
*/
public class Error_name3_7Exception extends ErrorName2Exception {

    public static final ExceptionType TYPE = new ExceptionType();

    private static class ExceptionType extends RootNameException.ExceptionType {

        @Override
        protected RootNameException createException(String message) {
            return new Error_name3_7Exception(message);
        }
    }

    protected Error_name3_7Exception(String message) {
        super(message);
    }
}

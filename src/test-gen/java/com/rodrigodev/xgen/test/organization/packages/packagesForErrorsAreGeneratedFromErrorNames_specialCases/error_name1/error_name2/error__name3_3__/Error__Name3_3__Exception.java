package com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames_specialCases.error_name1.error_name2.error__name3_3__;

import com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames_specialCases.error_name1.error_name2.ErrorName2Exception;
import com.rodrigodev.xgen.test.organization.packages.packagesForErrorsAreGeneratedFromErrorNames_specialCases.RootNameException;

/**
* Autogenerated by XGen on July 8, 2015.
*/
public class Error__Name3_3__Exception extends ErrorName2Exception {

    public static final ExceptionType TYPE = new ExceptionType();

    private static class ExceptionType extends RootNameException.ExceptionType {

        @Override
        protected RootNameException createException(String message) {
            return new Error__Name3_3__Exception(message);
        }
    }

    protected Error__Name3_3__Exception(String message) {
        super(message);
    }
}

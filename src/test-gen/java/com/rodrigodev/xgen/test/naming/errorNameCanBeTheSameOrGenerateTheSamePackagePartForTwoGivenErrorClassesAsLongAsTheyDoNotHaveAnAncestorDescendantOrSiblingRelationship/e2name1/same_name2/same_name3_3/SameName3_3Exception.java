package com.rodrigodev.xgen.test.naming.errorNameCanBeTheSameOrGenerateTheSamePackagePartForTwoGivenErrorClassesAsLongAsTheyDoNotHaveAnAncestorDescendantOrSiblingRelationship.e2name1.same_name2.same_name3_3;

import com.rodrigodev.xgen.test.naming.errorNameCanBeTheSameOrGenerateTheSamePackagePartForTwoGivenErrorClassesAsLongAsTheyDoNotHaveAnAncestorDescendantOrSiblingRelationship.e2name1.same_name2.SameName2Exception;
import com.rodrigodev.xgen.test.naming.errorNameCanBeTheSameOrGenerateTheSamePackagePartForTwoGivenErrorClassesAsLongAsTheyDoNotHaveAnAncestorDescendantOrSiblingRelationship.RootNameException;

/**
 * Autogenerated by XGen on January 1, 0001.
 */
public class SameName3_3Exception extends SameName2Exception {

    public static final ExceptionType TYPE = new ExceptionType();

    private static class ExceptionType extends RootNameException.ExceptionType {

        @Override
        protected RootNameException createException(String message) {
            return new SameName3_3Exception(message);
        }

        @Override
        protected RootNameException createException(String message, Throwable cause) {
            return new SameName3_3Exception(message, cause);
        }
    }

    protected SameName3_3Exception(String message) {
        super(message);
    }

    protected SameName3_3Exception(String message, Throwable cause) {
        super(message, cause);
    }
}

package com.rodrigodev.xgen4j.test.naming.errorNameCanBeTheSameOrGenerateTheSamePackagePartForTwoGivenErrorClassesAsLongAsTheyDoNotHaveAnAncestorDescendantOrSiblingRelationship.same_name3_4.same_name2.same_name3_1;

import com.rodrigodev.xgen4j.test.naming.errorNameCanBeTheSameOrGenerateTheSamePackagePartForTwoGivenErrorClassesAsLongAsTheyDoNotHaveAnAncestorDescendantOrSiblingRelationship.same_name3_4.same_name2.SameName2Exception;
import com.rodrigodev.xgen4j.test.naming.errorNameCanBeTheSameOrGenerateTheSamePackagePartForTwoGivenErrorClassesAsLongAsTheyDoNotHaveAnAncestorDescendantOrSiblingRelationship.RootNameException;

/**
 * Autogenerated by XGen on January 1, 0001.
 */
public class SameName3_1Exception extends SameName2Exception {

    public static final ExceptionType TYPE = new ExceptionType();

    private static class ExceptionType extends RootNameException.ExceptionType {

        @Override
        protected RootNameException createException(String message) {
            return new SameName3_1Exception(message);
        }

        @Override
        protected RootNameException createException(String message, Throwable cause) {
            return new SameName3_1Exception(message, cause);
        }
    }

    protected SameName3_1Exception(String message) {
        super(message);
    }

    protected SameName3_1Exception(String message, Throwable cause) {
        super(message, cause);
    }
}

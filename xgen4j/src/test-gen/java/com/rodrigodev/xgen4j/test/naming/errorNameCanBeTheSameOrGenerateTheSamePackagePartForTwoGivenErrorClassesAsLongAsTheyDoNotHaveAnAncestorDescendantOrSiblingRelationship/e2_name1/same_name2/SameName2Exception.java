package com.rodrigodev.xgen4j.test.naming.errorNameCanBeTheSameOrGenerateTheSamePackagePartForTwoGivenErrorClassesAsLongAsTheyDoNotHaveAnAncestorDescendantOrSiblingRelationship.e2_name1.same_name2;

import com.rodrigodev.xgen4j.test.naming.errorNameCanBeTheSameOrGenerateTheSamePackagePartForTwoGivenErrorClassesAsLongAsTheyDoNotHaveAnAncestorDescendantOrSiblingRelationship.e2_name1.E2Name1Exception;
import com.rodrigodev.xgen4j.test.naming.errorNameCanBeTheSameOrGenerateTheSamePackagePartForTwoGivenErrorClassesAsLongAsTheyDoNotHaveAnAncestorDescendantOrSiblingRelationship.RootNameException;
import com.rodrigodev.xgen4j.test.naming.errorNameCanBeTheSameOrGenerateTheSamePackagePartForTwoGivenErrorClassesAsLongAsTheyDoNotHaveAnAncestorDescendantOrSiblingRelationship.ErrorCode;

/**
 * Autogenerated by XGen4J on January 1, 0001.
 */
public class SameName2Exception extends E2Name1Exception {

    public static final ExceptionType TYPE = new ExceptionType();

    protected SameName2Exception(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    protected SameName2Exception(ErrorCode errorCode, String message, Throwable cause) {
        super(errorCode, message, cause);
    }

    private static class ExceptionType extends RootNameException.ExceptionType {

        @Override
        protected RootNameException createException(ErrorCode errorCode, String message) {
            return new SameName2Exception(errorCode, message);
        }

        @Override
        protected RootNameException createException(ErrorCode errorCode, String message, Throwable cause) {
            return new SameName2Exception(errorCode, message, cause);
        }
    }
}

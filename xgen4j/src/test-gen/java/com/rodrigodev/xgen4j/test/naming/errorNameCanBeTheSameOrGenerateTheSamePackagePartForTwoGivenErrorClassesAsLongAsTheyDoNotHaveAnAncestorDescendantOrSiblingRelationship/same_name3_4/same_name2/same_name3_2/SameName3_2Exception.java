package com.rodrigodev.xgen4j.test.naming.errorNameCanBeTheSameOrGenerateTheSamePackagePartForTwoGivenErrorClassesAsLongAsTheyDoNotHaveAnAncestorDescendantOrSiblingRelationship.same_name3_4.same_name2.same_name3_2;

import com.rodrigodev.xgen4j.test.naming.errorNameCanBeTheSameOrGenerateTheSamePackagePartForTwoGivenErrorClassesAsLongAsTheyDoNotHaveAnAncestorDescendantOrSiblingRelationship.same_name3_4.same_name2.SameName2Exception;
import com.rodrigodev.xgen4j.test.naming.errorNameCanBeTheSameOrGenerateTheSamePackagePartForTwoGivenErrorClassesAsLongAsTheyDoNotHaveAnAncestorDescendantOrSiblingRelationship.RootNameException;
import com.rodrigodev.xgen4j.test.naming.errorNameCanBeTheSameOrGenerateTheSamePackagePartForTwoGivenErrorClassesAsLongAsTheyDoNotHaveAnAncestorDescendantOrSiblingRelationship.ErrorCode;

/**
 * Autogenerated by XGen4J on January 1, 0001.
 */
public class SameName3_2Exception extends SameName2Exception {

    public static final ExceptionType TYPE = new ExceptionType();

    protected SameName3_2Exception(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    protected SameName3_2Exception(ErrorCode errorCode, String message, Throwable cause) {
        super(errorCode, message, cause);
    }

    private static class ExceptionType extends RootNameException.ExceptionType {

        @Override
        protected RootNameException createException(ErrorCode errorCode, String message) {
            return new SameName3_2Exception(errorCode, message);
        }

        @Override
        protected RootNameException createException(ErrorCode errorCode, String message, Throwable cause) {
            return new SameName3_2Exception(errorCode, message, cause);
        }
    }
}

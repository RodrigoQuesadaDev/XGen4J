package com.rodrigodev.xgen4j.test.naming.errorNameCanBeTheSameOrGenerateTheSamePackagePartForTwoGivenErrorClassesAsLongAsTheyDoNotHaveAnAncestorDescendantOrSiblingRelationship.e2name1.same_name2.same_name3_3;

import com.rodrigodev.xgen4j.test.naming.errorNameCanBeTheSameOrGenerateTheSamePackagePartForTwoGivenErrorClassesAsLongAsTheyDoNotHaveAnAncestorDescendantOrSiblingRelationship.e2name1.same_name2.SameName2Error;


import com.rodrigodev.xgen4j.test.naming.errorNameCanBeTheSameOrGenerateTheSamePackagePartForTwoGivenErrorClassesAsLongAsTheyDoNotHaveAnAncestorDescendantOrSiblingRelationship.ErrorCode;

/**
 * Autogenerated by XGen on January 1, 0001.
 */
public abstract class SameName3_3Error extends SameName2Error {

    public static final ErrorCode CODE = new ErrorCode("same-name-3-3", SameName2Error.CODE);

    private static String MESSAGE_FORMAT = "ABCDE";

    private static String createMessage() {

        return String.format(MESSAGE_FORMAT);
    }

    public static void throwException() {
        throw new SameName3_3Exception(createMessage());
    }

    public static void throwException(Throwable cause) {
        throw new SameName3_3Exception(createMessage(), cause);
    }


}
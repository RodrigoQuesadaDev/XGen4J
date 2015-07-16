package com.rodrigodev.xgen4j_table_generator.test.tableIsGeneratedForErrorsWithNumericId.e2name1.e2name2.e2name3_3;

import com.rodrigodev.xgen4j_table_generator.test.tableIsGeneratedForErrorsWithNumericId.e2name1.e2name2.E2Name2Error;

import com.rodrigodev.xgen4j_table_generator.test.TableCreationTestSpecification.TestMessageGeneratorObject3;

import com.rodrigodev.xgen4j_table_generator.test.tableIsGeneratedForErrorsWithNumericId.ErrorCode;

/**
 * Autogenerated by XGen on January 1, 0001.
 */
public abstract class E2Name3_3Error extends E2Name2Error {

    public static final ErrorCode CODE = new ErrorCode("error-2-code-name-3-3", 16, E2Name2Error.CODE);

    private static String createMessage(TestMessageGeneratorObject3 generator) {
        if(generator == null) throw new NullPointerException("generator");

        return generator.message();
    }

    public static void throwException(TestMessageGeneratorObject3 generator) {
        throw new E2Name3_3Exception(createMessage(generator));
    }

    public static void throwException(TestMessageGeneratorObject3 generator, Throwable cause) {
        throw new E2Name3_3Exception(createMessage(generator), cause);
    }


}
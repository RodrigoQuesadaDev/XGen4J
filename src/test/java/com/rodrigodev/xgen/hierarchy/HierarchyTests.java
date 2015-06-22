package com.rodrigodev.xgen.hierarchy;

import com.rodrigodev.xgen.ExceptionsGenerator;
import org.junit.Test;

import static com.rodrigodev.xgen.configuration.ErrorConfiguration.*;

import static org.assertj.core.api.Assertions.*;

/**
 * Created by Rodrigo Quesada on 21/06/15.
 */
public class HierarchyTests {

    public HierarchyTests() {
        createExceptions();
    }

    private void createExceptions() {

        /*ExceptionsGenerator xgen = new ExceptionsGenerator("src/test-gen/java");

        // @formatter:off
        xgen.generate(baseError("Root").errors(
                error("E1").errors(
                        error("E2").errors(
                                error("E3_1").description(""),
                                error("E3_2").description(""),
                                error("E3_3").description("")
                        )
                )
        ).basePackage("com.rodrigodev.xgen.test.hierarchy").build());*/
        // @formatter:on
    }

    @Test
    public void errorClassesHaveCorrectHierarchy() {
        //assertThat(RootError.class).isAssignableFrom(C1Error.class);
    }

    @Test
    public void exceptionClassesHaveCorrectHierarchy() {
        //TODO implement this
    }
}

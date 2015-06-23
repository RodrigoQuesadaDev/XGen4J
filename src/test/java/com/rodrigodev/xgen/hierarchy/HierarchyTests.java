package com.rodrigodev.xgen.hierarchy;

import com.rodrigodev.xgen.ExceptionsGenerator;
import com.rodrigodev.xgen.test.hierarchy.*;
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

        ExceptionsGenerator xgen = new ExceptionsGenerator("src/test-gen/java");

        // @formatter:off
        xgen.generate(baseError("Root").errors(
                commonError("C1").errors(
                        error("C2").errors(
                                error("C3_1").description("ABCDE"),
                                error("C3_2").description("ABCDE"),
                                error("C3_3").description("ABCDE")
                        )
                ),
                error("E1").errors(
                        error("E2").errors(
                                error("E3_1").description("ABCDE"),
                                error("E3_2").description("ABCDE"),
                                error("E3_3").description("ABCDE")
                        )
                )
        ).basePackage("com.rodrigodev.xgen.test.hierarchy").build());
        // @formatter:on
    }

    @Test
    public void errorClassesHaveCorrectHierarchy() {
        assertThat(RootError.class).isAssignableFrom(C1Error.class);
        assertThat(C1Error.class).isAssignableFrom(C2Error.class);
        assertThat(C2Error.class).isAssignableFrom(C3_1Error.class);
        assertThat(C2Error.class).isAssignableFrom(C3_2Error.class);
        assertThat(C2Error.class).isAssignableFrom(C3_3Error.class);

        assertThat(RootError.class).isAssignableFrom(E1Error.class);
        assertThat(E1Error.class).isAssignableFrom(E2Error.class);
        assertThat(E2Error.class).isAssignableFrom(E3_1Error.class);
        assertThat(E2Error.class).isAssignableFrom(E3_2Error.class);
        assertThat(E2Error.class).isAssignableFrom(E3_3Error.class);
    }

    @Test
    public void exceptionClassesHaveCorrectHierarchy() {
        assertThat(RootException.class).isAssignableFrom(C1Exception.class);
        assertThat(C1Exception.class).isAssignableFrom(C2Exception.class);
        assertThat(C2Exception.class).isAssignableFrom(C3_1Exception.class);
        assertThat(C2Exception.class).isAssignableFrom(C3_2Exception.class);
        assertThat(C2Exception.class).isAssignableFrom(C3_3Exception.class);

        assertThat(RootException.class).isAssignableFrom(E1Exception.class);
        assertThat(E1Exception.class).isAssignableFrom(E2Exception.class);
        assertThat(E2Exception.class).isAssignableFrom(E3_1Exception.class);
        assertThat(E2Exception.class).isAssignableFrom(E3_2Exception.class);
        assertThat(E2Exception.class).isAssignableFrom(E3_3Exception.class);
    }
}

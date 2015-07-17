package com.rodrigodev.xgen4j.test.organization;

import com.rodrigodev.xgen4j.test.TestSpecification;
import com.rodrigodev.xgen4j.test.organization.hierarchy.RootError;
import com.rodrigodev.xgen4j.test.organization.hierarchy.RootException;
import com.rodrigodev.xgen4j.test.organization.hierarchy.c1.C1Error;
import com.rodrigodev.xgen4j.test.organization.hierarchy.c1.C1Exception;
import com.rodrigodev.xgen4j.test.organization.hierarchy.c1.c2.C2Error;
import com.rodrigodev.xgen4j.test.organization.hierarchy.c1.c2.C2Exception;
import com.rodrigodev.xgen4j.test.organization.hierarchy.c1.c2.c3_1.C3_1Error;
import com.rodrigodev.xgen4j.test.organization.hierarchy.c1.c2.c3_1.C3_1Exception;
import com.rodrigodev.xgen4j.test.organization.hierarchy.c1.c2.c3_2.C3_2Error;
import com.rodrigodev.xgen4j.test.organization.hierarchy.c1.c2.c3_2.C3_2Exception;
import com.rodrigodev.xgen4j.test.organization.hierarchy.c1.c2.c3_3.C3_3Error;
import com.rodrigodev.xgen4j.test.organization.hierarchy.c1.c2.c3_3.C3_3Exception;
import com.rodrigodev.xgen4j.test.organization.hierarchy.e1.E1Error;
import com.rodrigodev.xgen4j.test.organization.hierarchy.e1.E1Exception;
import com.rodrigodev.xgen4j.test.organization.hierarchy.e1.e2.E2Error;
import com.rodrigodev.xgen4j.test.organization.hierarchy.e1.e2.E2Exception;
import com.rodrigodev.xgen4j.test.organization.hierarchy.e1.e2.e3_1.E3_1Error;
import com.rodrigodev.xgen4j.test.organization.hierarchy.e1.e2.e3_1.E3_1Exception;
import com.rodrigodev.xgen4j.test.organization.hierarchy.e1.e2.e3_2.E3_2Error;
import com.rodrigodev.xgen4j.test.organization.hierarchy.e1.e2.e3_2.E3_2Exception;
import com.rodrigodev.xgen4j.test.organization.hierarchy.e1.e2.e3_3.E3_3Error;
import com.rodrigodev.xgen4j.test.organization.hierarchy.e1.e2.e3_3.E3_3Exception;
import org.junit.Test;

import static com.rodrigodev.xgen4j.model.error.configuration.ErrorConfiguration.*;
import static org.assertj.core.api.Assertions.*;

/**
 * Created by Rodrigo Quesada on 17/07/15.
 */
public class HierarchyTests extends TestSpecification {

    public HierarchyTests() {
        generateErrorsForHierarchyTests();
    }

    private void generateErrorsForHierarchyTests() {
        // @formatter:off
        generator().generate(rootError("Root").errors(
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
        ).basePackage("com.rodrigodev.xgen4j.test.organization.hierarchy").build());
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

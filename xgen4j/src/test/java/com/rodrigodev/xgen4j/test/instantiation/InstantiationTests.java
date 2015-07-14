package com.rodrigodev.xgen4j.test.instantiation;

import com.rodrigodev.xgen4j.test.TestSpecification;
import com.rodrigodev.xgen4j.test.instantiation.errorWithNoDescriptionAreAbstract.RootError;
import com.rodrigodev.xgen4j.test.instantiation.errorWithNoDescriptionAreAbstract.c1.C1Error;
import com.rodrigodev.xgen4j.test.instantiation.errorWithNoDescriptionAreAbstract.c1.c2.C2Error;
import com.rodrigodev.xgen4j.test.instantiation.errorWithNoDescriptionAreAbstract.c1.c2.c3.C3Error;
import com.rodrigodev.xgen4j.test.instantiation.errorWithNoDescriptionAreAbstract.e1.E1Error;
import com.rodrigodev.xgen4j.test.instantiation.errorWithNoDescriptionAreAbstract.e1.e2.E2Error;
import com.rodrigodev.xgen4j.test.instantiation.errorWithNoDescriptionAreAbstract.e1.e2.e3.E3Error;
import org.junit.Test;

import static com.rodrigodev.xgen4j.model.error.configuration.ErrorConfiguration.*;
import static java.lang.reflect.Modifier.isAbstract;
import static org.assertj.core.api.Assertions.*;

/**
 * Created by Rodrigo Quesada on 22/06/15.
 */
public class InstantiationTests extends TestSpecification {

    @Test
    public void errorsClassesAreAbstract() {
        // @formatter:off
        generator().generate(rootError("Root").errors(
                commonError("C1").errors(
                        error("C2").errors(
                                error("C3").description("ABCDE")
                        )
                ),
                error("E1").errors(
                        error("E2").errors(
                                error("E3").description("ABCDE")
                        )
                )
        ).basePackage("com.rodrigodev.xgen4j.test.instantiation.errorWithNoDescriptionAreAbstract").build());
        // @formatter:on

        assertThat(isAbstract(RootError.class.getModifiers())).isTrue();
        assertThat(isAbstract(C1Error.class.getModifiers())).isTrue();
        assertThat(isAbstract(C2Error.class.getModifiers())).isTrue();
        assertThat(isAbstract(C3Error.class.getModifiers())).isTrue();
        assertThat(isAbstract(E1Error.class.getModifiers())).isTrue();
        assertThat(isAbstract(E2Error.class.getModifiers())).isTrue();
        assertThat(isAbstract(E3Error.class.getModifiers())).isTrue();
    }
}

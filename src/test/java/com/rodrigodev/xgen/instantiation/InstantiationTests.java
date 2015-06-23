package com.rodrigodev.xgen.instantiation;

import com.rodrigodev.xgen.ExceptionsGenerator;
import com.rodrigodev.xgen.test.instantiation.errorWithNoDescriptionAreAbstract.*;
import org.junit.Test;

import java.lang.reflect.Modifier;

import static com.rodrigodev.xgen.configuration.ErrorConfiguration.baseError;
import static com.rodrigodev.xgen.configuration.ErrorConfiguration.commonError;
import static com.rodrigodev.xgen.configuration.ErrorConfiguration.error;

import static java.lang.reflect.Modifier.isAbstract;
import static org.assertj.core.api.Assertions.*;

/**
 * Created by Rodrigo Quesada on 22/06/15.
 */
public class InstantiationTests {

    @Test
    public void errorsClassesAreAbstract(){
        ExceptionsGenerator xgen = new ExceptionsGenerator("src/test-gen/java");
        // @formatter:off
        xgen.generate(baseError("Root").errors(
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
        ).basePackage("com.rodrigodev.xgen.test.instantiation.errorWithNoDescriptionAreAbstract").build());
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
